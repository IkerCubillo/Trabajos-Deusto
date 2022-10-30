
public class Asignatura {
	
	// Propiedades
	private String nombre = "";
	private int codigo = 0;
	private int curso = 0;
	private int creditos = 0;
	
	// Constructores
	
	public Asignatura() {
		
	}
	
	public Asignatura(String nombre, int codigo, int curso, int creditos) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.curso = curso;
		this.creditos = creditos;
	}
	
	// Getter y setters
	
	public String getNombre() {
		return this.nombre;
	}
	public int getCodigo() {
		return this.codigo;
	}
	public int getCurso() {
		return this.curso;
	}
	public int getCreditos() {
		return this.creditos;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	// Métodos
	
	public String toString() {
		return this.nombre + ", " + this.codigo + ", " + this.curso + ", " + this.creditos;
	}
	
}
