public class Grado {
	
	// Propiedades
	
	private String nombre = "";
	private Estudiante[] estudiantes = new Estudiante[100];
	
	// Constructores
	public Grado() {}
	
	public Grado(String nombre) {
		this.nombre = nombre;

	}
	
	public Grado(Grado l) {
		this.nombre = l.nombre;
		this.estudiantes = l.estudiantes;
	}
	// Getter y setters
	
	public String getNombre() {
		return this.nombre;
	}
	public Estudiante[] getEstudiantes() {
		return this.estudiantes;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEstudiantes(Estudiante[] estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	public void anyadirEstudiante(Estudiante a){
		int posicion = buscarPosicionLibre();
		
		if (posicion != -1) {
			this.estudiantes[posicion] = a;
		}
	}
	private int buscarPosicionLibre() {
		int resultado = -1;
		for(int i =  this.estudiantes.length - 1; i >= 0 ; i--) {
			if (this.estudiantes[i] == null){
				resultado = i;
			}
		}
		return resultado;
	}
	public void eliminarEstudiante(String dni) {
		for(int i = 0; i <= this.estudiantes.length ; i++) {
			if (this.estudiantes[i].getDni() == dni) {
					this.estudiantes[i] = null;
			}
		}
	}
	public String toString() {
		return this.nombre + "; " + this.numeroAlumnos();
	}
	
	private int numeroAlumnos() {
		int contador = 0;
		for (int i = 0; i < estudiantes.length; i++) {
			if(estudiantes[i] != null) {
				contador++;
			}
		}
		return contador;
	}
}
