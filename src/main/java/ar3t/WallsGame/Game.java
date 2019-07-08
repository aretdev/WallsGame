package ar3t.WallsGame;

import java.io.FileOutputStream;
import java.io.IOException;
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
	private ObjectOutputStream gameSaver;
	
	private GameWindows GUI;
	
	public Game() {
		p = new Player("P");
		mapa = new Map(p);
		GUI = new GameWindows(this.p, this.mapa);
		loopGame();
	}
	//Cargando Partida Constructor
	public Game(Map ChargedMap, Player ply) {
		mapa = ChargedMap;
		this.p = ply;
		GUI = new GameWindows(this.p, this.mapa);
		loopGame();
	}
	public void loopGame() {
		
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
					if(p.getBomb() > 0 && !mapa.getBombAct()) {mapa.activateBomb(); textInfo = "Bomba activada! "; break;}
					textInfo = (mapa.getBombAct()) ? "Ya hay una bomba activa!" : "No tienes bombas";
					break;
				case "h":
					Dialogs.dialogSelect(this.sc, 1);;
					break;
				case "g":
					try {
						
						gameSaver = new ObjectOutputStream(new FileOutputStream("Data/Slot.data"));
						MapPlayerObj auxiliar = new MapPlayerObj(this.p, this.mapa);
						gameSaver.writeObject(auxiliar);
						gameSaver.close();
						textInfo = "Partida guardada";
						
					}catch(IOException e) {
						System.out.println("ERROR! No se ha encontrado la ruta de guardado. ¿Existe la carpeta Data/?");
					}
					
					break;
				default:
					textInfo = "Si necesitas ayuda, pulsa 'h' ";
					break;
			}
			if(mapa.getDataCell(new Vector2D(x, y)) == 3) {
				textInfo = "◉ +1";
				p.setBomb(true);
			}else if(mapa.getBombStepLeft() == 1) {
				textInfo = "◉ BOOM! ◉ ";
			}
			mapa.setPlayerPosition(new Vector2D(x, y), 4);
		}
		
		StringText.blankSpaces(10);
		if(mapa.isWinner()) {
			this.GUI.GameWindow("BY: Ar3T", 2);
		}else {
			this.GUI.GameWindow("BY: Ar3T", 2);
		}
		
	}
	
	
}
