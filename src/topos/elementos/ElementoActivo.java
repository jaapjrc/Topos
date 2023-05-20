package topos.elementos;

import topos.Estructura.Direccion;
import topos.Estructura.Escenario;
import topos.Estructura.PanelBasico;
import topos.Estructura.Posicion;

public abstract class ElementoActivo extends Elemento{


	protected boolean desplazar(Direccion dir, Escenario esc) {
		Posicion posActual = this.getPanel().getPosicion();
		Posicion posDestino= posActual.getVecina(dir);

		boolean isPosiValida = esc.consultarSeccionValida(posDestino);
		if(isPosiValida) {
			this.getPanel().quitar(this);
			PanelBasico panelDestino = esc.getPanel(posDestino);
			panelDestino.introducir(this);
			this.setPanel(panelDestino);
			return true;
		}
		else
			return false;
	}
}
