package animales;

public class Mamifero extends Animal {
	
	private int camada = 0;
	
	public Mamifero(String nombre, String especie, int edad, int peso, int longitud, int camada) {
		super(nombre, especie, edad, peso, longitud);
		this.camada = camada;
	}
	
	public int getCamada() {
		return this.camada;
	}

	@Override
	public String toString() {
		return "Mamifero [camada=" + camada + ", getNombre()=" + getNombre() + ", getEspecie()=" + getEspecie()
				+ ", getEdad()=" + getEdad() + ", getPeso()=" + getPeso() + ", getLongitud()=" + getLongitud()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	public void hablar() {
		System.out.println("Arghhh");
	}
}
