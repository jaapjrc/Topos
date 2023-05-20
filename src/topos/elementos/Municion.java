package topos.elementos;

import topos.juego.ContribucionJuego;

public class Municion extends ElementoPasivo{

	private static final String RUTA = "imagenes/municion.png";

	public Municion(int cantidad) {
		super(cantidad);
	}
	@Override
	public ContribucionJuego getContribucionJuego() {
		// TODO Auto-generated method stub
		return new ContribucionJuego(0,0,getCantidad());
	}

	@Override
	public String getRuta() {
		// TODO Auto-generated method stub
		return RUTA;
	}

}
