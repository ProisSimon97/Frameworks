package preuss.utilizacion2;

import preuss.frameworkv2.Accion;

public class AccionFuego implements Accion {

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		System.out.println("Expandiendo el Fuego");
	}

	@Override
	public String nombreItemMenu() {
		// TODO Auto-generated method stub
		return "Accion Fuego";
	}

	@Override
	public String descripcionItemMenu() {
		// TODO Auto-generated method stub
		return "Fuego";
	}
}
