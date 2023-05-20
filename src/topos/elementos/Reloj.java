package topos.elementos;

import topos.juego.ContribucionJuego;

public class Reloj extends ElementoPasivo{

	private static final String RUTA = "imagenes/reloj.png";

	public Reloj(int cantidad) {
		super(cantidad);
	}
	@Override
	public ContribucionJuego getContribucionJuego() {
		// TODO Auto-generated method stub
		return new ContribucionJuego(0, getCantidad(), 0);
	}

	@Override
	public String getRuta() {
		// TODO Auto-generated method stub
		return RUTA;
	}

}
