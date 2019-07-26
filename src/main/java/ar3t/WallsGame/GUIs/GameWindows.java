package ar3t.WallsGame.GUIs;

import ar3t.WallsGame.Map;
import ar3t.WallsGame.Player;
import ar3t.WallsGame.Utils.StringText;

public class GameWindows {
	private Player player;
	private Map mapa;
	
	public GameWindows(Player p, Map mapa) {
		this.player = p;
		this.mapa = mapa;
	}
	public void GameWindow(String Message, int ScreenMode) {
		int widthCorrector = (Map.DIMENSIONX * 2) - 4;
		if(Message.equals("")) {Message = "ENCUENTRA UNA SALIDA!!";}
		System.out.println("╔══════════════════════════════════════════════════════════╗");
		System.out.println("║" + StringText.alignText("WallsGame v1.1", widthCorrector) + "║");
		System.out.println("╠══════════════════════════════════════════════════════════╣");
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
				System.out.println("║" + StringText.alignText("", widthCorrector) + "║");
			}
			System.out.println("║" + StringText.alignText("HAS GANADO! ", widthCorrector) + "║");
			System.out.println("║" + StringText.alignText("▢ Gracias por jugar! ▢", widthCorrector) + "║");
			
			for (int i = 1; i < (mapa.MapaOverLay.length - 2) / 2; i++) {
				System.out.println("║" + StringText.alignText("", widthCorrector) + "║");
			}
		}else {
			for (int i = 1; i < (mapa.MapaOverLay.length - 2) / 2; i++) {
				System.out.println("║" + StringText.alignText("", widthCorrector) + "║");
			}
			System.out.println("║" + StringText.alignText("HAS PERDIDO ", widthCorrector) + "║");
			System.out.println("║" + StringText.alignText("▢ ☠ ▢ ", widthCorrector) + "║");
			
			for (int i = 1; i < (mapa.MapaOverLay.length - 2) / 2; i++) {
				System.out.println("║" + StringText.alignText("", widthCorrector) + "║");
			}
		}
		System.out.println("╠════════════════════════════╦═════════════════════════════╣");
		System.out.println("║" + StringText.alignText("w↑ a← s↓ d→ t(◉) g(✐) ", widthCorrector / 2) + "║" + StringText.alignText("◉ : " + player.getBombSize(), widthCorrector / 2) + "║");
		System.out.println("╠════════════════════════════╩═════════════════════════════╣");
		System.out.println("║" + StringText.alignText("", widthCorrector) + "║");
		System.out.println("║" + StringText.alignText(Message, widthCorrector) + "║");
		System.out.println("║" + StringText.alignText("", widthCorrector) + "║");
		System.out.println("╚══════════════════════════════════════════════════════════╝");
	}
}
