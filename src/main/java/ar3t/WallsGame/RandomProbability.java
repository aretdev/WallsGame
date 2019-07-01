package ar3t.WallsGame;

public class RandomProbability {
	private int data = 1;
	private int prevData = 1; //
	/*
	 * @TODO Creación de paredes veticales , NO de posiciones aleatorias
	 * 
	 * 
	 * Lo principal será "Asegurar" un camino con las probs
	 */
	public RandomProbability() {
		generationData();
	}
	
	private void generationData() {
		double randomProb = Math.random();
		if(randomProb <= 0.65) {
			prevData = data;
			data = 1;
		}else {
			prevData = data; 
			data = (randomProb >= 0.95) ? 3 : 2;}
	}
	public int getData() {
		return data;
	}
}
