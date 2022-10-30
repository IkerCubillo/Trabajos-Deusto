package es.deusto.progii.multimedia;

public class Jpg extends Imagen{
	// Propiedades
	private int compresion;
	
	// Constructores
	public Jpg() {
	}
	
	public Jpg(String rutaFichero,int colores,int compresion) {
		super(rutaFichero,colores, tipo);
		this.compresion = compresion;
	}
	
	// Metodos
	public int getCompresion() {
		return this.compresion;
	}
	public void setCompresion(int compresion) {
		this.compresion = compresion;
	}
	
}
