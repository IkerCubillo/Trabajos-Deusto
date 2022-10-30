
public class Estudiantes {
	
	// Propiedades
	
	private String nombre = "";
	private String apellido = "";
	private int DNI = 0;
	private String codigoPostal = "";
	
	// Constructores
	public Estudiantes() {
		nombre = "";
		apellido = "";
		DNI = 0;
		codigoPostal = "";
	}
	
	
	public Estudiantes(String nombre, String apellido, int DNI, String codigoPostal) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.codigoPostal = codigoPostal;		
	}
	
	// Getter y setters
	
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public int getDNI() {
		return this.DNI;
	}
	public String getCodigoPostal() {
		return this.codigoPostal;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDNI(int DNI) {
		this.DNI = DNI;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	// Métodos
	public String toString() {
		return this.nombre + " patata " + this.apellido;
	}
}
