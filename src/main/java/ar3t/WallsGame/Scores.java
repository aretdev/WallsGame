package ar3t.WallsGame;

import java.io.Serializable;

public class Scores implements Serializable{

	private static final long serialVersionUID = -1538921029690899919L;
	private int Total_games;
	private double BombsxGames;
	private int Looses;
	private long PromTime;
	private int HighBombsPick;
	
	private int CurrentBombsInGame = 0;
	
	public Scores(int TG, int BxG, int Los, long PT, int HbP) {
		this.Total_games = TG;
		this.BombsxGames = BxG;
		this.Looses = Los;
		this.PromTime = PT;
		this.HighBombsPick = HbP;
	}
	public Scores() {
		this(0,0,0,0,0);
	}
	public int getLooses() {
		return this.Looses;
	}
	public int getTG() {
		return this.Total_games;
	}
	public double getBxG() {
		return this.BombsxGames;
	}
	public double getPT() {
		return this.PromTime;
	}
	public int getHbP() {
		return this.HighBombsPick;
	}
	
	public void addTG() {
		this.Total_games++;
	}
	public void addLose() {
		this.Looses++;
	}
	public void addHighScoreBomb() {
		this.HighBombsPick = (this.CurrentBombsInGame > this.HighBombsPick) ? this.CurrentBombsInGame : this.HighBombsPick;
	}
	
	public void setPromTime(long d) {
		this.PromTime = ( (this.PromTime + d) / this.Total_games) / 1_000_000_000;
	}
	
	public void setBombxGame() {
		this.BombsxGames =  (this.BombsxGames + this.CurrentBombsInGame) / this.Total_games;
	}
	public void addBombCurrentGame() {
		this.CurrentBombsInGame++;
	}
	
	public void close() {
		this.CurrentBombsInGame = 0;
	}
}
