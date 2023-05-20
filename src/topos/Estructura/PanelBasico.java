	package topos.Estructura;

import java.util.LinkedList;

import topos.elementos.Elemento;
import topos.juego.ContribucionJuego;
import topos.juego.Imagen;

public class PanelBasico {

	private Posicion posicion;
	private Estado estado;
	private LinkedList <Elemento> elementos;
	private long inicio;
	private static final int TIEMPO =3000;
	private static final String RUTA = "imagenes/panel-basico.gif";
	private PanelAleatorio pa ;


	public PanelBasico(int x, int y ) {
		this.posicion= new Posicion(x,y);
		this.estado = Estado.LEVANTADO;
		this.elementos=new LinkedList <Elemento>();
		//this.pa = new PanelAleatorio(3,2);

	}
	public void derribar() {
		if (this.estado == Estado.LEVANTADO) {
			this.estado= Estado.DERRIBADO;
			inicio = System.currentTimeMillis();
		}
	}

	public boolean introducir(Elemento e) {
		if(elementos.contains(e)==false) {
			elementos.add(e);
			e.setPanel(this);
			return true;
		}
		else return false;
	}
	public boolean quitar(Elemento e) {
		if(elementos.contains(e)==true) {
			elementos.remove(e);
			e.setPanel(null);
			return true;
		}
		else return false;
	}
	public void actualizar(Escenario esc) {
		long tiempo3 = this.inicio+TIEMPO;
		long actual = System.currentTimeMillis();
		if((this.estado == Estado.DERRIBADO) && (actual>tiempo3)) {
			this.estado = Estado.LEVANTADO;

		}
		for (Elemento elem : elementos) {
			elem.actualizar(esc);
		}
	}
	@Override
	public String toString() {
		return "PanelBasico [posicion=" + posicion + ", estado=" + estado + "]";
	}
	public Posicion getPosicion() {
		//EVITAR ALIASING
		return new Posicion(posicion);
	}
	public Estado getEstado() {
		return estado;
	}
	public LinkedList<Elemento> getElementos() {
		return elementos;
	}
	public String getRuta() {
		return RUTA;
	}

	public LinkedList<Imagen> getImagenes() {
		LinkedList<Imagen> imagenes = new LinkedList<Imagen>();
		if(estado==Estado.LEVANTADO) {	
			Imagen imagenPanel = new Imagen(this.getRuta(),posicion.getX(), posicion.getY());
			imagenes.add(imagenPanel);
		}
		else {
			//devolver las imagenes de detrás del panel
			for (Elemento elem : elementos) {
				Imagen imagen = new Imagen(elem.getRuta(),posicion.getX(),posicion.getY());
				imagenes.add(imagen);
			}
		}
		return imagenes;
	}
	public LinkedList<ContribucionJuego> capturar(){
		LinkedList<ContribucionJuego> contribucion = new LinkedList<ContribucionJuego>();
		for (Elemento e : elementos) {
			contribucion.add(e.getContribucionJuego());
			quitar(e);
		}
		return contribucion;
	}
	private int getX() {
		return posicion.getX();
	}
	private int getY() {
		return posicion.getY() 	;
	}

}
