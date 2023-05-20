package topos.elementos;

import java.util.ArrayList;
import java.util.Random;

import topos.Estructura.Direccion;
import topos.Estructura.Escenario;
import topos.juego.ContribucionJuego;

public class TopoCiego extends Topo{
	private static final String RUTA = "imagenes/topo-ciego.png";
	@Override
	protected Direccion getDireccionDesplazamiento(Escenario esc) {
		Random random = new Random();
		int aleatorio = random.nextInt(4);
		ArrayList<Direccion> salida = new ArrayList<Direccion>();
		for(Direccion d : Direccion.values()) {
			salida.add(d);
		}
		return salida.get(aleatorio);
	}

	

	@Override
	protected boolean puedeMoverse(Escenario esc) {
		return true;
	}

	@Override
	public ContribucionJuego getContribucionJuego() {
		return new ContribucionJuego(2, 0, 0);
	}

	@Override
	public String getRuta() {
		return RUTA;
	}


}
