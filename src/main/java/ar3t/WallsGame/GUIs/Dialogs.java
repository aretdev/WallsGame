package ar3t.WallsGame.GUIs;

import java.util.Scanner;

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
}
