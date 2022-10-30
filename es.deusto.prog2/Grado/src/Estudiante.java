
public class Estudiante {
	
	// Propiedades
	private String nombre = "";
	private String dni = "";
	private int curso = 0;
	private Asignatura[] matricula = new Asignatura[40];
	
	// Constructores
	
	
	public Estudiante(String nombre, String dni, int curso) {
		this.nombre = nombre;
		this.dni = dni;
		this.curso = curso;
	}
	
	// Getter y setters
	
	public String getNombre() {
		return this.nombre;
	}
	public String getDni() {
		return this.dni;
	}
	public int getCurso() {
		return this.curso;
	}
	public Asignatura[] getMatricula() {
		return this.matricula;
	}
	
	public void anyadirAsignatura(Asignatura a){
		int posicion = buscarPosicionLibre();
		
		if (posicion != -1) {
			this.matricula[posicion] = a;
		}
	}
	private int buscarPosicionLibre() {
		int resultado = -1;
		for(int i =  this.matricula.length - 1; i >= 0 ; i--) {
			if (this.matricula[i] == null){
				resultado = i;
			}
		}
		return resultado;
	}
	
	public void eliminarAsignatura(Asignatura a) {
		this.eliminarAsignatura(a.getCodigo());
	}
	public void eliminarAsignatura(int codigo) {
		for(int i = 0; i <= this.matricula.length ; i++) {
			if (this.matricula[i].getCodigo() == codigo) {
					this.matricula[i] = null;
			}
		}
	}
}