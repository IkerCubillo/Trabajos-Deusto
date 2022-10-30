package es.deusto.progii.multimedia;

public class Multimedia {
	// Propiedades
	
	private String rutaFichero = "";
	
	
	// Constructor
	
	public Multimedia() {}
	
	public Multimedia(String rutaFichero) {
		
		this.rutaFichero = rutaFichero;
				
	}
	// Metodos
	
	
	public String getRutaFichero() {
		return this.rutaFichero;
	}
	
	
	public void setRutaFichero(String ruta) {
		this.rutaFichero = rutaFichero;
	}
	
	@Override
	public String toString() {
		return this.rutaFichero;
	}
}
