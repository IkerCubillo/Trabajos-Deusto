package animales;

public abstract class Animal {
	private String nombre = "";
	private String especie = "";
	private int edad = 0;
	private int peso = 0;
	private int longitud = 0;
	
	public Animal(String nombre, String especie, int edad, int peso, int longitud) {
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
		this.peso = peso;
		this.longitud = longitud;
	}

	public String getNombre() {
		return this.nombre;
	}
	public String getEspecie() {
		return this.especie;
	}
	public int getEdad() {
		return this.edad;
	}
	public int getPeso() {
		return this.peso;
	}
	public int getLongitud() {
		return this.longitud;
	}

	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	public abstract void hablar();

}
