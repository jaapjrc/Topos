package topos.Pruebas;

import topos.Estructura.Escenario;
import topos.Estructura.PanelBasico;
import topos.Estructura.Posicion;

public class PruebaEscenario {

	public static void main(String[] args) {

		Posicion p = new Posicion(5,6);
		Posicion p2 = new Posicion(1,2);
		Posicion p3 = new Posicion(5,1);
		Posicion p4 = new Posicion(2,3);
		Escenario escenario1 = new Escenario(p.getX(),p.getY());
		System.out.println(escenario1.getAncho());
		System.out.println(escenario1.getAlto());

		System.out.println(escenario1.consultarSeccionValida(p2));

		System.out.println(escenario1.consultarSeccionValida(p3));

		PanelBasico panel = new PanelBasico(2,3);

		escenario1.establecerPanel(panel);
		System.out.println(panel.getPosicion());
		System.out.println(escenario1.consultarSeccionValida(p4));
		System.out.println(escenario1.consultarEscenarioVisible(p4));
		escenario1.derribarPanel(panel.getPosicion());
		System.out.println(escenario1.consultarEscenarioVisible(p4));


	}

}
