package topos.Pruebas;

import topos.Estructura.Escenario;
import topos.Estructura.Posicion;

public class PruebaGestionTiempo {

	public static void main(String[] args) {
		Escenario esc = new Escenario(5,5);
		Posicion p = new Posicion(2,2);
		esc.getPanel(p).derribar();
		System.out.println(esc.consultarEscenarioVisible(p));
		long fin = System.currentTimeMillis() + 4000;
		while(System.currentTimeMillis()<fin);		esc.actualizar();
		System.out.println(esc.consultarEscenarioVisible(p));

	}

}
