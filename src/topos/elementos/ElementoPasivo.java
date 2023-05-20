package topos.elementos;

import topos.Estructura.Escenario;

public abstract class ElementoPasivo extends Elemento{

	private final int cantidad;

	public ElementoPasivo(int cantidad) {
		super();
		this.cantidad = cantidad;
	}

	@Override
	public void actualizar(Escenario esc) {
		//no hace nada

	}

	public int getCantidad() {
		return cantidad;
	}


}
