package topos.Estructura;

import java.util.Random;

public class PanelAleatorio extends PanelBasico {
	private static final String RUTA = "imagenes/panel-aleatorio.png";

	public PanelAleatorio(int x, int y ) {
		super(x,y);
	}

	@Override
	public void derribar() {
		Random aleatorio = new Random();
		boolean ignorar = aleatorio.nextBoolean();
		if(!ignorar) {
			super.derribar();
		}
	}

	@Override
	public String getRuta() {
		// TODO Auto-generated method stub
		return RUTA;
	}


}
