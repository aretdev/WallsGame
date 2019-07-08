package ar3t.WallsGame;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import ar3t.WallsGame.GUIs.StartMenu;
import ar3t.WallsGame.Utils.MapPlayerObj;

/*
 * WallsGame v1.0
 * 
 * By : Aretdev
 *TODO Menu principal
 *TODO Generación de habitaciones
 *TODO Plantearse crear mapas más grandes , para nuevas estructuras
 *TODO Crear guardado y carga de partidas
 *TODO ¿Interfaz bonica?
 *TODO Nuevos items
 *
 */
public class Main {

	public static void main(String[] args) {
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
