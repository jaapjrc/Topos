
package topos.Estructura;

import java.util.LinkedList;

import topos.juego.ContribucionJuego;

public class Escenario {
	private int ancho;
	private int alto;
	private PanelBasico[][] paneles;



	public Escenario(int ancho, int alto) {
		this.alto=alto;
		this.ancho=ancho;
		paneles = new PanelBasico[ancho][alto];
		for(int i=0;i<ancho;i++) {
			for(int j =0;j<alto; j++) {
				paneles[i][j] = new PanelBasico(i,j);
			}
		}
	}

	public boolean consultarSeccionValida(Posicion p) {
		if((p.getX()<0)||(p.getX()>(ancho-1)||(p.getY()<0)||(p.getY()>(alto-1)))) {
			return false;

		}
		else return true;
	}
	public void establecerPanel(PanelBasico panel) {
		paneles[panel.getPosicion().getX()][panel.getPosicion().getY()] = panel;
	}

	public boolean consultarEscenarioVisible(Posicion p) {
		if(paneles[p.getX()][p.getY()].getEstado()==Estado.DERRIBADO) {
			return true;
		}
		else
			return false;
	}

	public void derribarPanel(Posicion p) {
		paneles[p.getX()][p.getY()].derribar();
	}

	public void actualizar() {
		for(int i = 0;i<ancho;i++) {
			for(int j =0;j<alto; j++) {
				paneles[i][j].actualizar(this);
			}
		} 
	}

	public PanelBasico getPanel(int x, int y){
		return paneles[x][y];
	}
	public PanelBasico getPanel(Posicion p) {
		if((p.getX()>0)||(p.getX()<(ancho-1)||(p.getY()>0)||(p.getY()<(alto-1)))) {
			return paneles[p.getX()][p.getY()];
		}
		return null;
	}
	public LinkedList<ContribucionJuego> capturar(Posicion p){
		if(consultarEscenarioVisible(p)) {
			PanelBasico panel = getPanel(p);
			return panel.capturar();	
		}
		else return new LinkedList<ContribucionJuego>();
	}
	public int getAlto() {
		return alto;
	}
	public int getAncho() {
		return ancho;
	}

}
