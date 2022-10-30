package animales;

public class Pez extends Animal {
	
	private int velocidad = 0;
	private boolean aguaDulce = true;
	
	public Pez(String nombre, String especie, int edad, int peso, int longitud, int velocidad, boolean aguaDulce) {
		super(nombre, especie, edad, peso, longitud);
		this.velocidad = velocidad;
		this.aguaDulce = aguaDulce;
	}

	public int getVelocidad() {
		return this.velocidad;
	}
	public boolean getAgua() {
		return this.aguaDulce;
	}

	@Override
	public String toString() {
		return "Pez [velocidad=" + velocidad + ", aguaDulce=" + aguaDulce + ", getNombre()=" + getNombre()
				+ ", getEspecie()=" + getEspecie() + ", getEdad()=" + getEdad() + ", getPeso()=" + getPeso()
				+ ", getLongitud()=" + getLongitud() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	public void hablar() {
		System.out.println("Mamahuevo, digo gluglugluglu");
	}

}
