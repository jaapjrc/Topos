package topos.Pruebas;

import topos.Estructura.Direccion;
import topos.juego.Partida;

public class PruebaPartida {

	public static void main(String[] args) {
		Partida partida = new Partida(5, 5, 60, 3);
		partida.arrancarPartida();
		System.out.println(partida.isPartidaEnJuego());
		System.out.println(partida.getPuntos());
		partida.desplazar(Direccion.DERECHA);
		System.out.println(partida.getObjetivo());
		partida.disparar();
		partida.disparar();
		System.out.println(partida.getDisparosRestantes());
		long fin = System.currentTimeMillis() + 4000;
		while (System.currentTimeMillis() < fin);
		System.out.println(partida.getSegundosRestantes()); //REVISAR
		System.out.println(partida.isPartidaFinalizada());
		partida.disparar();
		System.out.println(partida.isPartidaEnJuego());


	}

}
