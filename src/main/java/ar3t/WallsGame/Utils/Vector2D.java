package ar3t.WallsGame.Utils;

import java.io.Serializable;

public class Vector2D implements Serializable {
	
	private static final long serialVersionUID = -2578427190216538450L;
	private int x;
	private int y;
	
	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setPos(Vector2D pos) {
		this.x = pos.getX();
		this.y = pos.getY();
	}
	public boolean equals(Object o) {
		return o instanceof Vector2D && 
				this.x == ((Vector2D) o).x &&
				this.y == ((Vector2D) o).y;
	}
}
