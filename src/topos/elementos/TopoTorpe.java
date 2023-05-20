package topos.elementos;

import java.util.Random;

import topos.Estructura.Direccion;
import topos.Estructura.Escenario;
import topos.Estructura.Posicion;
import topos.juego.ContribucionJuego;

public class TopoTorpe extends Topo{

	private static final String RUTA= "imagenes/topo-torpe.png";
	/*
	 * Calcula una direccion destino  
	 */

	@Override
	protected Direccion getDireccionDesplazamiento(Escenario esc) {
		Direccion[] direcciones = Direccion.values();
		Random rnd = new Random();
		int destino = rnd.nextInt(direcciones.length);
		return direcciones[destino];
	}
	/*
	 * Nos podemos mover si el panel en el que estamos está 
	 * derribado
	 */

	@Override
	protected boolean puedeMoverse(Escenario esc) {
		Posicion posi= this.getPanel().getPosicion();
		return esc.consultarEscenarioVisible(posi);
	}

	@Override
	public ContribucionJuego getContribucionJuego() {
		//contribuye con 1 punto
		return new ContribucionJuego(1, 0, 0);
	}

	@Override
	public String getRuta() {
		return RUTA;
	}


}
