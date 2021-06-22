package preuss.utilizacion2;

import preuss.frameworkv2.Accion;

public class AccionAgua implements Accion {

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		System.out.println("Tirando Agua");
	}

	@Override
	public String nombreItemMenu() {
		// TODO Auto-generated method stub
		return "Accion Agua";
	}

	@Override
	public String descripcionItemMenu() {
		// TODO Auto-generated method stub
		return "Agua";
	}

}
