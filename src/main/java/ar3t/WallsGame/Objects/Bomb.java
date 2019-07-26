package ar3t.WallsGame.Objects;

import java.io.Serializable;

public class Bomb extends Item implements Serializable{

	private static final long serialVersionUID = 7315859560991500703L;
	private int  bombWarningSteps = 4;
	private boolean isBombActivated = false;
	
	public Bomb(String ic) {
		super(ic);
	}
	
	public int stepsLeft() {
		return this.bombWarningSteps;
	}
	public boolean actBomb() {
		return this.isBombActivated;
	}
	
	public void setWarningSteps(int steps) {
		this.bombWarningSteps = steps;
	}
	public void setBombStatus(boolean status) {
		this.isBombActivated = status;
	}
}
