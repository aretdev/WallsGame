package ar3t.WallsGame;

import java.util.Arrays;
import java.util.List;

public class RandMazeGen {

		  private List<String> indexAssets = Arrays.asList(Map.MAPASSET_BASIC);
	      private int[][] map;
	      private int width;
	      private int height;
	      private java.util.Random rand = new java.util.Random();

	      public RandMazeGen() {
	         this.width = Map.DIMENSIONY;
	         this.height = Map.DIMENSIONX;
	         map = new int[width][height];
	      }

	      private void carve(int x, int y) {

	         final int[] upx = { 1, -1, 0, 0 };
	         final int[] upy = { 0, 0, 1, -1 };

	         int count = 0;
	         int dir = rand.nextInt(4);
	         while(count < 7) {
	            final int x1 = x + upx[dir];
	            final int y1 = y + upy[dir];
	            final int x2 = x1 + upx[dir];
	            final int y2 = y1 + upy[dir];
	            
	            if(map[x1][y1] == indexAssets.indexOf("▩") && map[x2][y2] == indexAssets.indexOf("▩")) {
	            	map[x1][y1] = (rand.nextInt(10) > 8) ? indexAssets.indexOf("B") : indexAssets.indexOf("▢");
	            	map[x2][y2] = indexAssets.indexOf("▢");
	               carve(x2, y2);
	            } else { 
	               dir = (dir + 1) % 4;
	               count++;
	            }
	         }
	      }

	      public void generate() {
	         for(int x = 0; x < width; x++) {
	            for(int y = 0; y < height; y++) {
	            	map[x][y] = indexAssets.indexOf("▩");
	            }
	         }
	         for(int x = 0; x < width; x++) {
	        	 map[x][0] = indexAssets.indexOf("");
	        	 map[x][height - 1] = indexAssets.indexOf("");
	         }
	         for(int y = 0; y < height; y++) {
	        	 map[0][y] = indexAssets.indexOf("");
	        	 map[width - 1][y] = indexAssets.indexOf("");
	         }
	         carve(1, 1);
	      }	  
	      
	      public int[][] getMaze(){
	    	  return map;
	      }
	   }