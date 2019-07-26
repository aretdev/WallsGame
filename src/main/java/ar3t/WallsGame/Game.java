package ar3t.WallsGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import ar3t.WallsGame.GUIs.Dialogs;
import ar3t.WallsGame.GUIs.GameWindows;
import ar3t.WallsGame.Utils.MapPlayerObj;
import ar3t.WallsGame.Utils.StringText;
import ar3t.WallsGame.Utils.Vector2D;

public class Game {
	
	private Scanner sc = new Scanner(System.in);
	private Player p;
	private Map mapa;
	private Scores scor;
	private long startTime;
	private long endTime;
	
	private ObjectInputStream objectReader;
	private ObjectOutputStream objectSaver;
	private File path;
	
	
	private GameWindows GUI;
	
	//Cargando Partida Constructor
	public Game(Map ChargedMap, Player ply) {
		mapa = ChargedMap;
		this.p = ply;
		GUI = new GameWindows(this.p, this.mapa);
		loopGame();
	}
	
	public Game() {
		p = new Player("P");
		mapa = new Map(p);
		GUI = new GameWindows(this.p, this.mapa);
		loopGame();
	}
	public void loopGame() {
		try {
			objectReader = new ObjectInputStream(new FileInputStream("Data/Scores/Stats.data"));
			scor = (Scores) objectReader.readObject();
			objectReader.close();
		} catch(IOException | ClassNotFoundException e) {}
		
		startTime = System.nanoTime();
		
		String textInfo = "";
		while(!mapa.isWinner() && !p.dead){
			
			int x = p.getPos().getX();
			int y = p.getPos().getY();
			
			StringText.blankSpaces(10);
			this.GUI.GameWindow(textInfo, 1);
			textInfo = "";
			String keyPress = sc.nextLine().toLowerCase().trim();
			
			switch (keyPress) {
				case "d":
					y++;
					break;
				case "s":
					x++;
					break;
				case "w":
					x--;
					break;
				case "a":
					y--;
					break;
				case "t":
					if(p.getBombSize() != 0 && mapa.getPlacedBomb() == null) {
						textInfo = "Bomba colocada! ";
						mapa.activateBomb();
						continue;
					}
					textInfo = (mapa.getPlacedBomb() != null && p.getBombSize() != 0) ? "Ya hay una bomba activa " : "No tienes bombas! ";
					break;
				case "h":
					Dialogs.dialogSelect(this.sc, 1);;
					break;
				case "g":
					try {
						path = new File("Data");
						objectSaver = new ObjectOutputStream(new FileOutputStream(path + "/Slot.data"));
						MapPlayerObj auxiliar = new MapPlayerObj(this.p, this.mapa);
						objectSaver.writeObject(auxiliar);
						objectSaver.close();
						textInfo = "Partida guardada";
						continue;
					}catch(IOException e) {
						textInfo = "ERROR! Ruta 'Data/' no encontrada."; 
					}
					
					break;
				default:
					textInfo = (new java.util.Random().nextInt(10) > 5) ? "Si necesitas ayuda, pulsa 'h' " : "" ;
					break;
			}
			if(mapa.getDataCell(new Vector2D(x, y)) == 3) {
				scor.addBombCurrentGame();
				textInfo = "◉ +1";
				p.setBomb(true);
			}else if(mapa.getPlacedBomb() != null && mapa.getPlacedBomb().actBomb()) {
				mapa.getPlacedBomb().setWarningSteps(mapa.getPlacedBomb().stepsLeft() - 1);
				if(mapa.getPlacedBomb().stepsLeft() == 0) {mapa.exploteBomb(); textInfo = "BOOM! ◉ ";}
			}
			mapa.setPlayerPosition(new Vector2D(x, y), 4);
		}
		
		StringText.blankSpaces(10);
		if(mapa.isWinner()) {
			this.GUI.GameWindow("BY: Ar3T", 2);
		}else {
			this.GUI.GameWindow("BY: Ar3T", 3);
			scor.addLose();
		}
		endTime = System.nanoTime();
		
		scor.addTG();
		scor.addHighScoreBomb();
		scor.setBombxGame();
		scor.setPromTime(endTime - startTime);
		scor.close();
		try {
			objectSaver = new ObjectOutputStream(new FileOutputStream("Data/Scores/Stats.data"));
			objectSaver.writeObject(this.scor);
			objectSaver.close();
		}catch(IOException e) {
			
		}
		
	}
	
	
}
