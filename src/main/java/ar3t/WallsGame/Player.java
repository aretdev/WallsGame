package ar3t.WallsGame;

public class Player {
	private static Vector2D position = new Vector2D(1, 1);
	private static String name;
	public static boolean dead = false;
	
	public static int bombs;
	
	public Player(String name) {
		this.name = name;
		this.bombs = 0;}
	
	public void setPos(Vector2D pos) {
		this.position = pos;
	}
	
	public Vector2D getPos() {
		return this.position;
	}
	
	public void setBomb(boolean option) {
		this.bombs = (option) ? bombs + 1 : bombs; 
	}
	public int getBomb() {
		return this.bombs;
	}
	

}
