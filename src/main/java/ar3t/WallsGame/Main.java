package ar3t.WallsGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ar3t.WallsGame.GUIs.StartMenu;
import ar3t.WallsGame.Utils.MapPlayerObj;

/*
 * WallsGame v1.0
 * 
 * By : Aretdev
 */
public class Main {

	public static void main(String[] args) {
		if(!new File("Data").exists()) {new File("Data").mkdir();}
		if(!new File("Data/Scores").exists()) {
			/*
			 * En caso de que no se haya registrado ninguna partida
			 * Deberemos crear unas stats a 0! de esta forma podrán 
			 * empezar a sumarse nuevas partidas.
			 */
			new File("Data/Scores").mkdir();
			Scores parentScore = new Scores();
			try {
				ObjectOutputStream statsFirstCreator = new ObjectOutputStream(new FileOutputStream("Data/Scores/Stats.data"));
				statsFirstCreator.writeObject(parentScore);
				statsFirstCreator.close();
			}catch(IOException e) {
				System.out.println("No se pudo inicializar el proceso de puntuación.");
			}
			
		}
		StartMenu q = new StartMenu();
		q.initMenu();
		if(q.getOpt() == 1) {
			try {
				
			ObjectInputStream mapReader = new ObjectInputStream(new FileInputStream("Data/Slot.data"));
			MapPlayerObj readedOBJ = (MapPlayerObj) mapReader.readObject();
			new Game(readedOBJ.m, readedOBJ.p);
			mapReader.close();
			
			}catch(IOException | ClassNotFoundException e) {
				System.out.println("Ha ocurrido un error Cargando la partida, esta puede estar corrupta, en su defecto se empezará una nueva.");
				new Game();}
			
		}else {
			new Game();
		}
	}

}
