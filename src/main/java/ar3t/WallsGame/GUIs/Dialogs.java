package ar3t.WallsGame.GUIs;

import java.util.Scanner;

import ar3t.WallsGame.Scores;
import ar3t.WallsGame.Utils.StringText;

public class Dialogs {
	public static String[] Info_dialog = {
							"◈ INFORMACIÓN ◈ ",
							"Updates: https://github.com/aretdev/WallsGame ",
							"",
							"Unicodes sacados de : ",
							"https://unicode-table.com/es/ ",
							"",
							"",
							"Hecho con <3",
							"Por Ar3T",
							"",
							"",
							"[X] pulsa 'r' para volver "		
	};
	public static String[] Help_dialog = {
						   "◈ AYUDA ◈ ",
						   "El juego consiste en llegar a la salida '⌂' ",
						   "",
						   "Deberás usar las teclas w↑ a← s↓ d→ para moverte. ",
						   "",
						   "Si tienes bombas '◉' , pulsa 't' para soltarla: ",
						   "",
						   "◈ Tienes 3 movimientos para resguardarte.   ",
						   "◈ Si te golpea, perderás.                   ",
						   "",
						   "",
						   "[X] pulsa 'r' para volver "				   
	};
	public static String[] Scores_dialog = {
			   "TUS ESTADÍSTICAS",
			   "",
			   "[◉] Bombas por Partida : ",
			   "",
			   "",
			   "",
			   "",
			   "",
			   "",
			   "",
			   "",
			   "[X] pulsa 'r' para volver "				   
};
	
	public static void dialogSelect(Scanner sc, int IDdialog) {
		StringText.blankSpaces(10);
		do {
			System.out.println("╔══════════════════════════════════════════════════════════╗");
			switch (IDdialog) {
			case 1:
				StringText.createLimitsDialog(Help_dialog);
				break;
			case 2:
			StringText.createLimitsDialog(Info_dialog);
				break;
			default:
				break;
			}
			System.out.println("╚══════════════════════════════════════════════════════════╝");
		}while(!sc.next().equals("r"));
	}
	public static void ScoresDialog(Scanner sc, Scores objectScore) {
		StringText.blankSpaces(10);
		do {
			System.out.println("╔══════════════════════════════════════════════════════════╗");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("TUS ESTADÍSTICAS",59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("Promedio Bombas: " + objectScore.getBxG() + "     Partidas Totales: " + objectScore.getTG()  ,59)  + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("Mayor Número de Bombas:  " + objectScore.getHbP() ,59)  + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("Tiempo por partida: " + objectScore.getPT() + "s" + "        Derrotas: " + objectScore.getLooses(), 59)  +"║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("[X] pulsa 'r' para volver "	,59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("╚══════════════════════════════════════════════════════════╝");
		}while(!sc.next().equals("r"));
	}
}
