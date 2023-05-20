package topos.elementos;

import java.util.ArrayList;
import java.util.Random;

import topos.Estructura.Direccion;
import topos.Estructura.Escenario;
import topos.Estructura.Estado;
import topos.Estructura.Posicion;
import topos.juego.ContribucionJuego;

public class TopoListo extends Topo{

	private static final String RUTA = "imagenes/topo-listo.png";

		@Override
		protected Direccion getDireccionDesplazamiento(Escenario esc) {
			Posicion posi = this.getPanel().getPosicion();
			Random random = new Random();
			ArrayList<Direccion> salida = new ArrayList<Direccion>();
			for(Direccion d : Direccion.values()) {
				if(esc.getPanel(posi.getVecina(d)).getEstado()==Estado.LEVANTADO) {
					salida.add(d);
				}
			}
			int aleatorio = random.nextInt(salida.size());
			return salida.get(aleatorio);
		}
		
	@Override
	protected boolean puedeMoverse(Escenario esc) {
		Posicion posi= this.getPanel().getPosicion();
		return esc.consultarEscenarioVisible(posi);
	}

	@Override
	public ContribucionJuego getContribucionJuego() {
		return new ContribucionJuego(3, 0, 0);
	}

	@Override
	public String getRuta() {
		return RUTA;
	}

}
