package topos.juego;

public class Imagen {
	private String ruta;
	private int x;
	private int y;

	public Imagen(String ruta, int x, int y) {
		this.ruta=ruta;
		this.x=x;
		this.y=y;
	}
	public String getRuta() {
		return ruta;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
