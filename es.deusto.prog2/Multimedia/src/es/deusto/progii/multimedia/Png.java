package es.deusto.progii.multimedia;

public class Png extends Imagen {
	
	// Propiedades
	private int canalAlfa = 0;
	
	// Constructores
	public Png() {
	}
	
	public Png(String rutaFichero, int colores) {
		super(rutaFichero,colores);
		this.canalAlfa = canalAlfa;
	}
	
	// Metodos
	public int getCanalAlfa() {
		return this.canalAlfa;
	}
	
	public void setCanalAlfa(int alfa) {
		this.canalAlfa = canalAlfa;
	}
	
}
