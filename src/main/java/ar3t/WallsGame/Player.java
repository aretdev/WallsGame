package ar3t.WallsGame;

import java.io.Serializable;

import ar3t.WallsGame.Objects.Bomb;
import ar3t.WallsGame.Utils.Vector2D;

public class Player implements Serializable{

	private static final long serialVersionUID = 4915398908648982525L;
	private Vector2D position = new Vector2D(1, 1);
	private String name = "";
	public boolean dead = false;
	
	private Bomb[] bombs;
	private int bombSize = 0;
	
	public Player(String name) {
		this.name = name;
		bombs = new Bomb[99];
		}
	
	public void setPos(Vector2D pos) {
		position = pos;
	}
	
	public Vector2D getPos() {
		return position;
	}
	
	public void setBomb(boolean option) {
		if(option) {
			bombs[bombSize++] = new Bomb("◉");
		}
	}
	public int getBombSize() {
		return this.bombSize;
	}
	
	public String getName() {
		return this.name;
	}
	public void decreaseBombSize() {
		bombs[bombSize - 1] = null;
		bombSize--;
	}
	public boolean isAnyBombActive() {
		for (Bomb bomb : bombs) {
			if(bomb.actBomb()) {return true;}
		}
		return false;
	}
	public Bomb getBomb() {
		if(bombSize > 0) {
			return this.bombs[bombSize - 1];
		}else {return this.bombs[bombSize];}
	}

}
