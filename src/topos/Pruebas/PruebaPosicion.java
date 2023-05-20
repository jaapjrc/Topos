package topos.Pruebas;

import topos.Estructura.Direccion;
import topos.Estructura.Posicion;

public class PruebaPosicion {

	public static void main(String[] args) {
		Posicion posicion1 = new Posicion(0,0);
		System.out.println(posicion1.toString());
		posicion1.desplazar(Direccion.ARRIBA);
		System.out.println(posicion1.toString());
		posicion1.desplazar(Direccion.ABAJO);
		System.out.println(posicion1.toString());
		posicion1.desplazar(Direccion.IZQUIERDA);
		System.out.println(posicion1.toString());
		posicion1.desplazar(Direccion.DERECHA);
		System.out.println(posicion1.toString());


		System.out.println("-------------------------------------------------------------");
		Posicion vecina = posicion1.getVecina(Direccion.ARRIBA);
		System.out.println(vecina.toString());
		vecina=posicion1.getVecina(Direccion.ABAJO);
		System.out.println(vecina.toString());
		vecina=posicion1.getVecina(Direccion.IZQUIERDA);
		System.out.println(vecina.toString());
		vecina=posicion1.getVecina(Direccion.DERECHA);
		System.out.println(vecina.toString());
	}
}
