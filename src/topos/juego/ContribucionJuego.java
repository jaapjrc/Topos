package topos.juego;

public class ContribucionJuego {
	private final int puntos;
	private final int tiempo;
	private final int disparos;

	public ContribucionJuego(int puntos, int tiempo, int disparos) {
		this.puntos = puntos;
		this.tiempo = tiempo;
		this.disparos = disparos;
	}
	public int getPuntos() {
		return puntos;
	}
	public int getTiempo() {
		return tiempo;
	}
	public int getDisparos() {
		return disparos;
	}

}
