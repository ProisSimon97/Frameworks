package preuss.utilizacion2;

import preuss.frameworkv2.Accion;

public class AccionAire implements Accion {

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		System.out.println("Creando corriente de Aire");
	}

	@Override
	public String nombreItemMenu() {
		// TODO Auto-generated method stub
		return "Accion Aire";
	}

	@Override
	public String descripcionItemMenu() {
		// TODO Auto-generated method stub
		return "Aire";
	}

}
