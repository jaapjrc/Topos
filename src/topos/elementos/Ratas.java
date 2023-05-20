package topos.elementos;

import topos.Estructura.Direccion;
import topos.Estructura.Escenario;
import topos.Estructura.Estado;
import topos.Estructura.PanelBasico;
import topos.Estructura.Posicion;
import topos.juego.ContribucionJuego;

public  class Ratas extends ElementoActivo{

	private static final String RUTA = "imagenes/rata.png";

	@Override
	public ContribucionJuego getContribucionJuego() {
		return new ContribucionJuego(-1,0,0);
	}

	@Override
	public String getRuta() {
		return RUTA;
	}
	//PREGUNTAR QUE SI ESTÁ BIEN
	@Override
	public void actualizar(Escenario esc) {
		PanelBasico panel = this.getPanel();
		Posicion posi = panel.getPosicion();
		for (Direccion d : Direccion.values()) {
			if((esc.consultarSeccionValida(posi))
					&& (esc.consultarEscenarioVisible(posi.getVecina(d)))){
				posi.desplazar(d);
			
		}
		/*if(panel.getEstado()==Estado.LEVANTADO) {
			if((esc.consultarSeccionValida(posi))
					&& (esc.consultarEscenarioVisible(posi.getVecina(Direccion.DERECHA)))){
				posi.desplazar(Direccion.DERECHA);

			}
			else if((esc.consultarSeccionValida(posi))
					&& (esc.consultarEscenarioVisible(posi.getVecina(Direccion.ARRIBA)))) {
				posi.desplazar(Direccion.ARRIBA);
			}
			else if((esc.consultarSeccionValida(posi))
					&& (esc.consultarEscenarioVisible(posi.getVecina(Direccion.IZQUIERDA)))){
				posi.desplazar(Direccion.IZQUIERDA);
			}
			else if((esc.consultarSeccionValida(posi))
					&& (esc.consultarEscenarioVisible(posi.getVecina(Direccion.ABAJO)))){
				posi.desplazar(Direccion.ABAJO);
			}
		}
*/
	}

	}
}
