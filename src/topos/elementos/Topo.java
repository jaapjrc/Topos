package topos.elementos;

import topos.Estructura.Direccion;
import topos.Estructura.Escenario;

public abstract class Topo extends ElementoActivo{
	private static final long TIEMPO_ESPERA = 1000;
	private long tiempoUltimoMovimiento;
	private Direccion ultimaDir;

	@Override
	public void actualizar(Escenario esc) {
		if(puedeMoverse(esc)) {
			long tiempoActual = System.currentTimeMillis();
			long tiempoTranscurrido= tiempoActual-tiempoUltimoMovimiento;
			if (tiempoTranscurrido >= TIEMPO_ESPERA ) {
				Direccion dirDestino = getDireccionDesplazamiento(esc);

				boolean movidoTopo=desplazar(dirDestino,esc);
				if(movidoTopo) {
					tiempoUltimoMovimiento = tiempoActual;
					ultimaDir=dirDestino;
				}
			}
		}

	}

	public Direccion getUltimaDir() {
		return ultimaDir;
	}

	protected abstract Direccion getDireccionDesplazamiento(Escenario esc);

	protected abstract boolean puedeMoverse(Escenario esc);



}
