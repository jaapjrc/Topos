package topos.Pruebas;

import topos.Estructura.Direccion;
import topos.Estructura.PanelBasico;
import topos.Estructura.Posicion;

public class PruebaPanelBasico {
	public static void main(String[] args) {


		PanelBasico panel1 = new PanelBasico(0,0);
		System.out.println(panel1.toString());

		Posicion posi1 = panel1.getPosicion();

		posi1.desplazar(Direccion.DERECHA);
		System.out.println(posi1.toString());

		panel1.derribar();
		System.out.println(panel1.toString());

	}
}
