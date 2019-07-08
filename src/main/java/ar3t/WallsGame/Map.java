package ar3t.WallsGame;

import java.io.Serializable;

import ar3t.WallsGame.Utils.Vector2D;


public class Map implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final int DIMENSIONX = 31;
	public static final int DIMENSIONY = 13;
	
	private int[][] Mapa = new int[DIMENSIONY][DIMENSIONX];
	public String[][] MapaOverLay = new String[DIMENSIONY][DIMENSIONX];
	public static String[] MAPASSET_BASIC = {
			"⌂","▢","▩","B","P","","◉","▤"
			};
	
	private static Vector2D Exit = new Vector2D(11, 29);
	private Player ply;
	
	private boolean bombIsActivated = false;
	private int bombStepDelay = 4;
	private Vector2D bombPos = null;
		
	/**
	 *Crea aleatoriamente paredes y un overlay al mapa vacio
	 *ofreciendo invisibilidad.
	 *
	 *	ASSETS:
	 *	0 - Salida
	 *	1 - Camino
	 *	2 - Pared
	 *	3 - Bomba
	 *	4 - Jugador
	 */
	
	public Map(Player jugador) {
		this.ply = jugador;
		GenerateRandomWallsMaps();
		updatePos(4, ply.getPos());
		updatePos(0, Exit);
	}
	/*
	 * Generación del mapa REAL aleatorio 
	 */
	private void GenerateRandomWallsMaps(){
		RandMazeGen m = new RandMazeGen(); 
		m.generate();
		this.Mapa = m.getMaze();
		for (int rows = 0; rows < Mapa.length; rows++) {
			for (int columns = 0; columns < Mapa[0].length; columns++) {
				MapaOverLay[rows][columns] = " ";
			}
		}
	}
	/*
	 * Movimiento principal del jugador
	 */
	public void setPlayerPosition(Vector2D pos, int typeAsset) {
		if(canAdvance(pos)) {
			//Creamos el camino - >
			if(getDataCell(ply.getPos()) != 6){
			updatePos(1, ply.getPos());}
			//Actualizamos - >
			ply.setPos(pos);
			updatePos(typeAsset, ply.getPos());
			//Detección de la activación de la bomba - >
			this.bombStepDelay = (this.bombIsActivated) ? --this.bombStepDelay : 4;
			if(this.bombStepDelay == 0) {exploteBomb();}
		}else{
			MapaOverLay[pos.getX()][pos.getY()] = MAPASSET_BASIC[getDataCell(pos)];
		}
	}
	/*
	 * Método para colocar objetos predeterminados en el mapa
	 */
	private void updatePos(int asset, Vector2D position) {
		Mapa[position.getX()][position.getY()] = asset;
		MapaOverLay[position.getX()][position.getY()] = MAPASSET_BASIC[asset];
	}
	/*
	 * Información de la pos pedida
	 */
	public int getDataCell(Vector2D pos) {
		return Mapa[pos.getX()][pos.getY()];
	}
	/*
	 * Devuelve si puede avanzar
	 */
	private boolean canAdvance(Vector2D next) {
		int data = getDataCell(next);
		return data != 2 && data != 5 && data != 6;
	}
	/*
	 * Empieza la ejecución del estado de la bomba
	 */
	public void activateBomb() {
		ply.bombs--;
		bombPos = ply.getPos();
		updatePos(6, bombPos);
		bombIsActivated = true;
	}
	/*
	 * Explosión de la bomba
	 */
	private void exploteBomb() {
		int x = this.bombPos.getX();
		int y = this.bombPos.getY();
		Vector2D[] positionsToDestroy = { new Vector2D(x + 1, y), new Vector2D(x - 1, y), new Vector2D(x, y + 1), new Vector2D(x, y - 1) };
		updatePos(1, this.bombPos);
		for (Vector2D pos : positionsToDestroy) {
			if(getDataCell(pos) == 4) {
				ply.dead = true;}
			if(getDataCell(pos) != 0 && getDataCell(pos) != 5) {
				int auxiliarBloq = (getDataCell(pos) == 2) ? 7 : 1;
				updatePos(auxiliarBloq, pos);
			}
		}
		this.bombIsActivated = false;
	}
	/*
	 * Detecta si se ha ganado
	 */
	public boolean isWinner() {
		return this.ply.getPos().equals(Exit);}	
	
	public boolean getBombAct() {
		return this.bombIsActivated;
	}
	public int getBombStepLeft() {
		return this.bombStepDelay;
	}
}
