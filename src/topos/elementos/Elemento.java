package topos.elementos;

import topos.Estructura.Escenario;
import topos.Estructura.PanelBasico;
import topos.juego.ContribucionJuego;

public abstract class Elemento {
	private PanelBasico panel;

	public Elemento() {
		panel=null;
	}
	public PanelBasico getPanel() {
		return panel;
	}

	public void setPanel(PanelBasico panel) {
		this.panel = panel;
	}
	public abstract ContribucionJuego getContribucionJuego();
	public abstract String getRuta();
	public abstract void actualizar(Escenario esc);
}
