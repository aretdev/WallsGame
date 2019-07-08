package ar3t.WallsGame;

import java.io.Serializable;

import ar3t.WallsGame.Utils.Vector2D;

public class Player implements Serializable{

	private static final long serialVersionUID = 4915398908648982525L;
	private Vector2D position = new Vector2D(1, 1);
	private String name = "";
	public boolean dead = false;
	
	public int bombs;
	
	public Player(String name) {
		this.name = name;
		bombs = 0;}
	
	public void setPos(Vector2D pos) {
		position = pos;
	}
	
	public Vector2D getPos() {
		return position;
	}
	
	public void setBomb(boolean option) {
		this.bombs = (option) ? bombs + 1 : bombs; 
	}
	public int getBomb() {
		return this.bombs;
	}
	
	public String getName() {
		return this.name;
	}
	

}
