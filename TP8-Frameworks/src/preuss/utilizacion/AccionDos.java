package preuss.utilizacion;

import preuss.frameworkv2.Accion;

public class AccionDos implements Accion {

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		System.out.println("Ejecutando AccionDos...");
	}

	@Override
	public String nombreItemMenu() {
		// TODO Auto-generated method stub
		return "Accion 2";
	}

	@Override
	public String descripcionItemMenu() {
		// TODO Auto-generated method stub
		return "Esto trae las primeras diez personas de la BD...";
	}
}
