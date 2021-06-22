package preuss.utilizacion;

import preuss.frameworkv2.Accion;

public class AccionUno implements Accion {

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		System.out.println("Ejecutando AccionUno...");
	}

	@Override
	public String nombreItemMenu() {
		// TODO Auto-generated method stub
		return "Accion 1";
	}

	@Override
	public String descripcionItemMenu() {
		// TODO Auto-generated method stub
		return "Esto es para traer los twitts de Maradona...";
	}
}
