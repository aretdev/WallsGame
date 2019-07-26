package ar3t.WallsGame.Objects;

import java.io.Serializable;

import ar3t.WallsGame.Utils.Vector2D;

public class Item implements Serializable{
	
	private static final long serialVersionUID = -4473126820161395095L;
	private String Icon;
	private Vector2D posInMap;
	
	public Item(String Ic) {
		this.Icon = Ic;
	}
	
	public Vector2D getPos() {
		return this.posInMap;
	}
	public void setPos(Vector2D pos) {
		this.posInMap = pos;
	}
	
	public String getIcon() {
		return this.Icon;
	}
	
}
