package ar3t.WallsGame.GUIs;

import java.io.File;
import java.util.Scanner;

import ar3t.WallsGame.Utils.StringText;

public class StartMenu {
	private String[] menuOptions = {
			"Nueva Partida ",
			"Buscar Partida Guardada ",
			"Más Información "
	};
	private Scanner sc = new Scanner(System.in);
	private int optionCh = 0;
	
	public void initMenu() {
		String errorGameNotFound = "";
		
		while(true) {
			selectionOpt();
			System.out.println("╔══════════════════════════════════════════════════════════╗");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText(" __     __  ______  __      __      ______    ",59) + "║");
			System.out.println("║" + StringText.alignText("/\\ \\  _ \\ \\/\\  __ \\/\\ \\    /\\ \\    /\\  ___\\   ",59) + "║");
			System.out.println("║" + StringText.alignText("\\ \\ \\/ \".\\ \\ \\  __ \\ \\ \\___\\ \\ \\___\\ \\___  \\  ",59) + "║");
			System.out.println("║" + StringText.alignText(" \\ \\__/\".~\\_\\ \\_\\ \\_\\ \\_____\\ \\_____\\/\\_____\\ ",59) + "║");
			System.out.println("║" + StringText.alignText("  \\/_/   \\/_/\\/_/\\/_/\\/_____/\\/_____/\\/_____/ ",59) + "║");
			
			for (int i = 0; i < 4; i++) System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			
			for (int i = 0; i < menuOptions.length; i++) System.out.println("║" + StringText.alignText(menuOptions[i],59) + "║");
		
			System.out.println("║" + StringText.alignText("Usa : W ↑  S ↓  A (Seleccionar) ", 59) + "║");
			for (int i = 0; i < 2; i++) System.out.println("║" + StringText.alignText("",59) + "║");
		
			System.out.println("║" + StringText.alignText(errorGameNotFound,59) + "║");
			System.out.println("║" + StringText.alignText("",59) + "║");
			System.out.println("╚══════════════════════════════════════════════════════════╝");
			errorGameNotFound = "";
			String aux = sc.next().trim().toLowerCase();
			
			if(aux.equals("s") && optionCh != menuOptions.length - 1) {
				optionCh++;
			} else if(aux.equals("w") && optionCh != 0) {
				optionCh--;
			} else if(aux.equals("a")) {
				
				if(optionCh == 1) {
					File checker = new File("Data/Slot.data");
					if(!checker.exists()) {
						errorGameNotFound = "NO SE HA ENCONTRADO UNA PARTIDA ";
						
					}else {break;}
					
				}else if (optionCh == 2){
					
					Dialogs.dialogSelect(sc, 2);
				} else { break;}
			}
			StringText.blankSpaces(10);
		}
	}
	
	private void selectionOpt() {
			for (int i = 0; i < menuOptions.length; i++) {
				if(i == this.optionCh && !menuOptions[i].contains("→ ")) {
					menuOptions[i] = "→ " + menuOptions[i];
				}else {
					menuOptions[i] = (i == optionCh) ?  menuOptions[i]:
						menuOptions[i].replace("→ ", "");
				}
			}
	}
	public int getOpt() {
		return this.optionCh;
	}

}
