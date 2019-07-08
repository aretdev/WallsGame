package ar3t.WallsGame.Utils;

import java.io.Serializable;

import ar3t.WallsGame.Map;
import ar3t.WallsGame.Player;

public class MapPlayerObj implements Serializable {
/*
 * Esta clase simplemente actua como un "Array" para poder guardar 2 objetos diferentes
 */
	private static final long serialVersionUID = -3494891530813353648L;
	public Player p;
	public Map m;
	
	public MapPlayerObj(Player ply, Map mapa) {
		this.m = mapa;
		this.p = ply;
	}
}
