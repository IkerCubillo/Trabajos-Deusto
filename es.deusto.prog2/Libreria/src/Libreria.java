
public class Libreria {
	
	// Propiedades
	
	private String nombre = "";
	private String calle = "";
	private String localidad = "";
	private String cp = "";
	private Libro[] libros;
	
	// Constructores
	public Libreria() {}
	
	public Libreria(String nombre, String calle, String localidad, String cp, Libro[] libros) {
		this.nombre = nombre;
		this.calle = calle;
		this.localidad = localidad;
		this.cp = cp;
		this.libros = libros;
	}
	
	public Libreria(Libreria l) {
		this.nombre = l.nombre;
		this.calle = l.calle;
		this.localidad = l.localidad;
		this.cp = l.cp;
		this.libros = l.libros;
	}
	// Getter y setters
	
	public String getNombre() {
		return this.nombre;
	}
	public String getCalle() {
		return this.calle;
	}
	public String getLocalidad() {
		return this.localidad;
	}
	public String getCp() {
		return this.cp;
	}
	public Libro[] getLibros() {
		return this.libros;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public void setLibros(Libro[] libros) {
		this.libros = libros;
	}
	// M�todos
	//public String toString() {
		//return this.nombre + " " + this.calle;
	//}
}
