package topos.juego;

import java.awt.Color;
import java.awt.Panel;

import topos.Estructura.Direccion;
import topos.Estructura.PanelAleatorio;
import topos.Estructura.PanelBasico;
import topos.Estructura.PanelDebil;
import topos.Estructura.PanelResistente;
import topos.elementos.Moneda;
import topos.elementos.Municion;
import topos.elementos.Ratas;
import topos.elementos.Reloj;
import topos.elementos.TopoCiego;
import topos.elementos.TopoListo;
import topos.elementos.TopoTorpe;
import topos.vista1.Alarma;
import topos.vista1.Pantalla;

public class Programa {

	private static final int ANCHO=7;
	private static final int ALTO=7;
	private static final int TIEMPO = 60;
	private static final int DISPAROS=50;
	private static final int TAMANO_LADO = 50;

	public static void main(String[] args) {
		Partida partida = new Partida(ANCHO, ALTO, TIEMPO, DISPAROS);
		Pantalla pantalla = new Pantalla(ANCHO, ALTO,TAMANO_LADO, Color.GREEN);
		
		PanelAleatorio panelAletorio = new PanelAleatorio(3,2);
		partida.getEscenario().establecerPanel(panelAletorio);
		
		PanelResistente panelResistente = new PanelResistente(3,3);
		partida.getEscenario().establecerPanel(panelResistente);
		
		PanelDebil panelDebil=new PanelDebil(2,4);
		partida.getEscenario().establecerPanel(panelDebil);
		
		TopoTorpe topotorpe = new TopoTorpe();
		PanelBasico paneltorpe = new PanelBasico(3,4);
		paneltorpe.introducir(topotorpe);
		partida.getEscenario().establecerPanel(paneltorpe);
		
		TopoCiego topociego = new TopoCiego();
		PanelBasico panelciego = new PanelBasico(2, 2);
		panelciego.introducir(topociego);
		partida.getEscenario().establecerPanel(panelciego);
		
		TopoListo topolisto = new TopoListo();
		PanelBasico panellisto = new PanelBasico(4, 3);
		panellisto.introducir(topolisto);
		partida.getEscenario().establecerPanel(panellisto);
		
		Ratas rata = new Ratas();
		PanelBasico panelrata = new PanelBasico(1, 2);
		panelrata.introducir(rata);
		partida.getEscenario().establecerPanel(panelrata);
		
		
		Moneda moneda = new Moneda(10);
		PanelBasico panelmoneda = new PanelBasico(6,6);
		panelmoneda.introducir(moneda);
		partida.getEscenario().establecerPanel(panelmoneda);
		
		Municion municion = new Municion(20);
		PanelBasico panelmunicion = new PanelBasico(6,1);
		panelmunicion.introducir(municion);
		partida.getEscenario().establecerPanel(panelmunicion);
		
		Reloj reloj = new Reloj(10);
		PanelBasico panelreloj = new PanelBasico(6,2);
		panelreloj.introducir(reloj);
		partida.getEscenario().establecerPanel(panelreloj);
		
		partida.arrancarPartida();
		while (partida.isPartidaEnJuego()==true) {	
			pantalla.resetear();
			if(pantalla.hayTecla()) {
				switch (pantalla.leerTecla()) {
				case "i": partida.desplazar(Direccion.ARRIBA);
				break;
				case "k": partida.desplazar(Direccion.ABAJO);
				break;
				case "l": partida.desplazar(Direccion.DERECHA);
				break;
				case "j": partida.desplazar(Direccion.IZQUIERDA);
				break;
				case "d": partida.disparar();
				break;
				}
			}
			partida.actualizar();

			for (Imagen i : partida.getImagenes()) {
				pantalla.addImagen(i.getX(), i.getY(), i.getRuta());
			}

			pantalla.setBarraEstado(partida.toString());
			pantalla.dibujar();
			Alarma.dormir(200);

		}
		pantalla.setBarraEstado("Fin del juego "+" Puntos: "+ partida.getPuntos());
	}
}