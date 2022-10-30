package es.deusto.progii.multimedia;

public class Imagen extends Multimedia{
	
	// Propiedades
	private int colores = 0;
	protected static TiposImagen tipo = TiposImagen.JPG;
	
	// Constructores
	public Imagen() {
	}
	
	public Imagen(String rutaFichero,int colores, TiposImagen tipo) {
		super(rutaFichero);
		
		this.colores = colores;
		this.tipo = tipo;
	}
	
	// Metodos
	
	public int getColores() {
		return this.colores;
	}
	
	public void setColores(int colores) {
		this.colores = colores;
	}
	
	public String toString() {
		return super.toString() + ";colores: " + this.colores;
	}
	
}
