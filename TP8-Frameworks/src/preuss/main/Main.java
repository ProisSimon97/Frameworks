package preuss.main;

import preuss.framework.Proceso;

public class Main {

	public static void main(String[] args) {

		Proceso proceso = new Proceso("../utilizacion/config.txt");

		proceso.menu();
	}
}
