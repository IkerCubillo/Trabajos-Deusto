package deustoTrain;

public class Pasajero {
	private String nombre = "";
	private int dni = 0;
	private int telefono = 000000000;
	
	public Pasajero(String nombre, int dni, int telefono) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getDni() {
		return dni;
	}
	public int getTelefono() {
		return telefono;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Pasajero [nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + "]";
	}
	
}
