package ar3t.WallsGame.Utils;

public class StringText {
	
	public static  String alignText(String text, int lineLength) {
		String res = "";
		int prev = (lineLength - text.length()) / 2;
		for (int i = 0; i < prev; i++) {
			res += " ";}
		res += text;
		for (int i = 0; i < prev; i++) {
			res += " ";}
		return res;
		
	}
	public static void blankSpaces(int len) {
		for (int i = 0; i < len; i++) {
			System.out.println();
		}
	}
	public static void createLimitsDialog(String[] x) {
		for (int i = 0; i < 6; i++) {
			if(i == 2) {System.out.println("║" + alignText(x[0], 59) + "║" ); continue;}
			System.out.println("║" + alignText("", 59) + "║" );
		}
		for (int i = 1; i <= 10; i++) System.out.println("║" + alignText(x[i], 59) + "║" );
		System.out.println("║" + alignText(x[11], 59) + "║" );
		System.out.println("║" + alignText("", 59) + "║" );
		System.out.println("║" + alignText("", 59) + "║" );
		
	}
}
