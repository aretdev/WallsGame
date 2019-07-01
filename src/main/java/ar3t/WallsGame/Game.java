package ar3t.WallsGame;

import java.util.Scanner;

public class Game {
	private Scanner sc = new Scanner(System.in);
	private Player p = new Player("P");
	private Map mapa = new Map(p);
	public Game() {
		loopGame();
	}
	
	public void loopGame() {
		String textInfo = "";
		
		while(!mapa.isWinner() && !p.dead){
			int x = p.getPos().getX();
			int y = p.getPos().getY();
			blankSpaces(10);
			GUI(textInfo, 1);
			textInfo = "";
			String keyPress = sc.nextLine().toLowerCase();
			switch (keyPress) {
				case "d":
					y++;
					break;
				case "s":
					x++;
					break;
				case "w":
					x--;
					break;
				case "a":
					y--;
					break;
				case "t":
					if(p.getBomb() > 0 && !mapa.bombIsActivated) {mapa.activateBomb(); textInfo = "Bomba activada! "; break;}
					textInfo = (mapa.bombIsActivated) ? "Ya hay una bomba activa!" : "No tienes bombas";
					break;
				case "h":
					helpDialog();
					break;
				default:
					textInfo = "Si necesitas ayuda, pulsa 'h' ";
					break;
			}
			if(mapa.getDataCell(new Vector2D(x, y)) == 3) {
				textInfo = "◉ +1";
				p.setBomb(true);
			}else if(mapa.bombStepDelay == 0) {
				textInfo = "◉ BOOM! ◉";
			}
			mapa.setPlayerPosition(new Vector2D(x, y), 4);
		}
		
		blankSpaces(10);
		if(mapa.isWinner()) {
			GUI("BY: Ar3T", 2);
		}else {
			GUI("BY: Ar3T", 3);
		}
		
	}
	
	private void GUI(String Message, int ScreenMode) {
		if(Message.equals("")) {Message = "ENCUENTRA UNA SALIDA!!";}
		System.out.println("╔══════════════════════════════════════╗");
		System.out.println("║" + alignText("WallsGame v1.0", 38) + "║");
		System.out.println("╠══════════════════════════════════════╣");
		if(ScreenMode == 1) {
			
		for (int rows = 1; rows < mapa.MapaOverLay.length - 1; rows++) {
			System.out.print("║");
			for (int colum = 1; colum < mapa.MapaOverLay[0].length - 1; colum++) {
				System.out.print(mapa.MapaOverLay[rows][colum] + " ");
			}
			System.out.println("║");
		}
		
		}else if (ScreenMode == 2) {
			for (int i = 1; i < (mapa.MapaOverLay.length - 2) / 2; i++) {
				System.out.println("║                                      ║");
			}
			System.out.println("║" + alignText("HAS GANADO! ", 38) + "║");
			System.out.println("║" + alignText("▢ Gracias por jugar! ▢", 38) + "║");
			
			for (int i = 1; i < (mapa.MapaOverLay.length - 2) / 2; i++) {
				System.out.println("║                                      ║");
			}
		}else {
			for (int i = 1; i < (mapa.MapaOverLay.length - 2) / 2; i++) {
				System.out.println("║                                      ║");
			}
			System.out.println("║" + alignText("HAS PERDIDO ", 38) + "║");
			System.out.println("║" + alignText("▢ ☠ ▢ ", 38) + "║");
			
			for (int i = 1; i < (mapa.MapaOverLay.length - 2) / 2; i++) {
				System.out.println("║                                      ║");
			}
		}
		System.out.println("╠══════════════════╦═══════════════════╣");
		System.out.println("║ w↑ a← s↓ d→ h(?) ║" + alignText("◉ : " + p.getBomb(), 19) + "║");
		System.out.println("╠══════════════════╩═══════════════════╣");
		
		System.out.println("║" + alignText(Message, 38) + "║");
		System.out.println("╚══════════════════════════════════════╝");
	}
	
	private void helpDialog() {
		blankSpaces(10);
		do {
		System.out.println("◈" + alignText("AYUDA", 38) +  "◈ \n");
		System.out.println("-> El juego consiste en llegar a la salida '⌂'");
		System.out.println("-> Deberás usar las teclas w↑ a← s↓ d→ para moverte.");
		System.out.println("-> Una vez recogida una bomba '◉' , pulsa 't' para activarla en tu posición.");
		System.out.println("	+ Una vez la bomba esté activada , tendrás 3 movimientos para llegar a un lugar seguro.");
		System.out.println("	+ Si una bomba te golpea, perderás. \n");
		System.out.println("[X] pulsa 'r' para volver");
		}while(!sc.nextLine().equals("r"));
	}
	
	private String alignText(String text, int lineLength) {
		String res = "";
		int prev = (lineLength - text.length()) / 2;
		for (int i = 0; i < prev; i++) {
			res += " ";}
		res += text;
		for (int i = 0; i < prev; i++) {
			res += " ";}
		return res;
		
	}
	private void blankSpaces(int len) {
		for (int i = 0; i < len; i++) {
			System.out.println();
		}
	}
}
