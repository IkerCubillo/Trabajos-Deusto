package animales;

public class Ave extends Animal {
	
	private int tamañoHuevo = 0;
	private String colorHuevo = "blanco";
	
	public Ave(String nombre, String especie, int edad, int peso, int longitud, int tamañoHuevo, String colorHuevo) {
		super(nombre, especie, edad, peso, longitud);
		this.tamañoHuevo = tamañoHuevo;
		this.colorHuevo = colorHuevo;
	}
	
	public int getTamañoHuevo() {
		return this.tamañoHuevo;
	}
	public String getColorHuevo() {
		return this.colorHuevo;
	}

	@Override
	public String toString() {
		return "Ave [tamañoHuevo=" + tamañoHuevo + ", colorHuevo=" + colorHuevo + ", getNombre()=" + getNombre()
				+ ", getEspecie()=" + getEspecie() + ", getEdad()=" + getEdad() + ", getPeso()=" + getPeso()
				+ ", getLongitud()=" + getLongitud() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	public void hablar() {
		System.out.println("PioPioPioPio");
	}
	
}
