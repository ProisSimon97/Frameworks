package preuss.framework;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Proceso {

	private List<Accion> acciones = new ArrayList<Accion>();

	public Proceso(String url) {

		Properties prop = new Properties();

		try (InputStream file = getClass().getResourceAsStream(url);) {

			prop.load(file);

			String clases = prop.getProperty("acciones");

			String[] clase = clases.split(";");

			for (int i = 0; i < clase.length; i++) {

				Class cla = Class.forName(clase[i]);
				this.acciones.add((Accion) cla.getDeclaredConstructor().newInstance());

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("No puede crear una intancia de Accion.", e);
		}
	}

	public void imprimir(int accion) {

		this.acciones.get(accion).ejecutar();
	}

	@SuppressWarnings("resource")
	public void menu() {

		int opcion = 0;

		do {

			for (int i = 0; i < acciones.size(); i++) {

				System.out.println(i + 1 + "." + acciones.get(i).nombreItemMenu());
			}
			System.out.println(acciones.size() + 1 + ".Salir");

			Scanner scan = new Scanner(System.in);

			try {
				opcion = scan.nextInt();

				if (opcion > acciones.size() + 1 || opcion == 0) {
					System.out.println("Valor no valido, el valor a ingresar debe estar en rango de opciones.");
				} else

				if (opcion != acciones.size() + 1)
					imprimir(opcion - 1);

			} catch (InputMismatchException e) {

				opcion = 0;
				System.out.println("Valor no valido, el valor a ingresar debe ser un numero.");
			}

		} while (opcion != acciones.size() + 1);
	}
}
