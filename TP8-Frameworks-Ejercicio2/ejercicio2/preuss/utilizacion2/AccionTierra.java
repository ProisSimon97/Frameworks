package preuss.utilizacion2;

import preuss.frameworkv2.Accion;

public class AccionTierra implements Accion {

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		System.out.println("Juntando Tierra");
	}

	@Override
	public String nombreItemMenu() {
		// TODO Auto-generated method stub
		return "Accion Tierra";
	}

	@Override
	public String descripcionItemMenu() {
		// TODO Auto-generated method stub
		return "Tierra";
	}
}
