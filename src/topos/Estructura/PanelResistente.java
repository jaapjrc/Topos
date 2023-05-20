package topos.Estructura;

public class PanelResistente extends PanelBasico{
	private static int dureza;
	private int llamada;
	private static final String RUTA = "imagenes/panel-resistente.gif";

	public PanelResistente(int x, int y, int dureza) {
		super(x,y);
		this.dureza=dureza;
		llamada=0;
	}
	public PanelResistente(int x, int y) {
		super(x,y);
		dureza = 2;
		llamada=0;
	}
	@Override
	public void derribar() {
		if(llamada==dureza) {
			super.derribar();
			llamada=0;
		}
		else llamada++;
	}
	@Override
	public String getRuta() {
		// TODO Auto-generated method stub
		return RUTA;
	}

}
