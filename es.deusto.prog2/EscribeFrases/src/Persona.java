
public class Persona {
	private int dni = 0;
	private String nombre = "";
	private int edad = 0;
	
	public Persona(int dni, String nombre, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}

	public int getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	
	
}
