package topos.juego;

import java.util.LinkedList;

import topos.Estructura.Direccion;
import topos.Estructura.Escenario;
import topos.Estructura.PanelAleatorio;
import topos.Estructura.PanelBasico;
import topos.Estructura.Posicion;

public class Partida {
	private Escenario escenario;
	private Posicion objetivo;
	private int segundos;
	private int disparosRestantes;
	private int puntos;
	private long inicioPartida;
	private int segundosRestantes;
	private boolean partidaFinalizada;
	private boolean partidaEnJuego ;
	private static final String RUTA_OBJETIVO="imagenes/objetivo.png";
	private PanelAleatorio al;

	public Partida(int ancho, int alto, int segundos, int disparosDisponibles) {
		this.escenario = new Escenario(ancho, alto);
		this.segundos=segundos;
		this.disparosRestantes=disparosDisponibles;
		this.puntos=0;
		this.objetivo = new Posicion(0,0);
		partidaEnJuego=true;
		
	}
	public boolean partidaFinalizada() {

		if((getSegundosRestantes()==0)) {
			return partidaFinalizada =true;
		}
		else return partidaFinalizada=false;
	}
	public boolean partidaEnJuego() {
		if((isPartidaFinalizada()==false) && (disparosRestantes>0)) {
			return partidaEnJuego=true;
		}
		else return partidaEnJuego=false;
	}
	public boolean arrancarPartida() {
		inicioPartida = System.currentTimeMillis();
		return partidaEnJuego();

	}
	public boolean desplazar(Direccion dir) {
		if(escenario.consultarSeccionValida(objetivo.getVecina(dir))) {
			objetivo.desplazar(dir);
			return true;
		}
		else return false;
	}
	public void disparar() {
		//FALTA PROCESAR LAS CONTRIBUCIONES
		if(partidaEnJuego()==true) {
			if(!escenario.consultarEscenarioVisible(objetivo)) {
				escenario.derribarPanel(objetivo);
			}
			else {
				LinkedList<ContribucionJuego> contribuciones = new LinkedList<ContribucionJuego>();
				contribuciones=this.escenario.capturar(objetivo);
				for (ContribucionJuego contribucionJuego : contribuciones) {
					puntos+=contribucionJuego.getPuntos();
					segundosRestantes+=contribucionJuego.getTiempo();
					disparosRestantes+=contribucionJuego.getDisparos();
				}
			}
			disparosRestantes=disparosRestantes-1;
		}
	}
	public void actualizar() {
		escenario.actualizar();
	}
	public void anadirPaneles(PanelBasico ...paneles) {
		for (PanelBasico panelBasico : paneles) {
			escenario.establecerPanel(panelBasico);
		}	
	}
	public Escenario getEscenario() {
		return escenario;
	}
	public Posicion getObjetivo() {
		return objetivo;
	}
	public int getSegundos() {
		return segundos;
	}
	public int getDisparosRestantes() {
		return disparosRestantes;
	}
	public int getPuntos() {
		return puntos;
	}
	public long getInicioPartida() {
		return inicioPartida;
	}
	public int getSegundosRestantes() {
		segundosRestantes =segundos-((int) Math.ceil(((System.currentTimeMillis()-inicioPartida)/1000 ))) ;
		return segundosRestantes;
	}
	public boolean isPartidaFinalizada() {
		return partidaFinalizada();
	}
	public boolean isPartidaEnJuego() {
		return partidaEnJuego();
	}
	public LinkedList<Imagen> getImagenes(){
		LinkedList<Imagen> imagenes = new LinkedList<Imagen>();
		for(int i=0; i< escenario.getAncho(); i++) {
			for(int j=0;j<escenario.getAlto(); j++) {
				imagenes.addAll(escenario.getPanel(i,j).getImagenes());
			}
		}
		Imagen imgobjetivo = new Imagen(RUTA_OBJETIVO, objetivo.getX(), objetivo.getY());
		//Imagen imgAleatorio = new Imagen(al.getRuta(),al.getPosicion().getX(),al.getPosicion().getY());
		imagenes.add(imgobjetivo);
		//imagenes.add(imgAleatorio);
		return imagenes;	
	}
	@Override
	public String toString() {
		return "Disparos=" + disparosRestantes + ", Puntos=" + puntos + ", Tiempo="
				+ getSegundosRestantes() ;
	}


}
