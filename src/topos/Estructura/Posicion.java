package topos.Estructura;


public class Posicion implements Cloneable{
	private int x;
	private int y;

	//constructor con argumentos
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//constructor de copia
	public Posicion(Posicion p) {
		this(p.getX(), p.getY());
	}

	//funcionalidad
	public void desplazar(int cantidadx, int cantidady) {
		x = cantidadx+x;
		y = cantidady+y;
	}
	public void desplazar(Direccion direccion) {

		switch(direccion) {
		case ARRIBA:
			this.desplazar(0,1);
			break;
		case ABAJO:
			this.desplazar(0,-1);
			break;
		case IZQUIERDA:
			this.desplazar(-1,0);
			break;
		case DERECHA:
			this.desplazar(1,0);
			break;
		}
	}
	public Posicion getVecina(Direccion dir) {
		Posicion vecina = new Posicion(this);
		vecina.desplazar(dir);
		return vecina;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Posicion [x=" + x + ", y=" + y + "]";
	}

	public Posicion clone(){
		//1o hacer copia superficial
		Posicion copia = copiaSuperficial();
		//2o arreglar aliasing
		return copia;
	}
	private Posicion copiaSuperficial() {
		Posicion copia = null;
		try {
			copia = (Posicion) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			System.err.println("Clase no cloneable");
		}
		return copia;
	}

}
