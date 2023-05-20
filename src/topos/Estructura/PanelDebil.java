package topos.Estructura;

public class PanelDebil extends PanelBasico{
	private static final String RUTA = "imagenes/panel-debil.gif";

	private final int dureza;
	private int derribos;

	public PanelDebil(int x, int y ) {
		super(x,y);
		dureza = 3;
		derribos=0;
	}
	@Override
	public void derribar() {
		if (derribos <= dureza) {
			derribos++;
			super.derribar();
		}
	}
	@Override
	public String getRuta() {
		// TODO Auto-generated method stub
		return RUTA;
	}
	@Override
	public void actualizar(Escenario esc) {
		if (derribos<dureza)
			super.actualizar(esc);
	}

}
