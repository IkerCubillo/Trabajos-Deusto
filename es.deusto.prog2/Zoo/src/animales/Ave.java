package animales;

public class Ave extends Animal {
	
	private int tama�oHuevo = 0;
	private String colorHuevo = "blanco";
	
	public Ave(String nombre, String especie, int edad, int peso, int longitud, int tama�oHuevo, String colorHuevo) {
		super(nombre, especie, edad, peso, longitud);
		this.tama�oHuevo = tama�oHuevo;
		this.colorHuevo = colorHuevo;
	}
	
	public int getTama�oHuevo() {
		return this.tama�oHuevo;
	}
	public String getColorHuevo() {
		return this.colorHuevo;
	}

	@Override
	public String toString() {
		return "Ave [tama�oHuevo=" + tama�oHuevo + ", colorHuevo=" + colorHuevo + ", getNombre()=" + getNombre()
				+ ", getEspecie()=" + getEspecie() + ", getEdad()=" + getEdad() + ", getPeso()=" + getPeso()
				+ ", getLongitud()=" + getLongitud() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	public void hablar() {
		System.out.println("PioPioPioPio");
	}
	
}