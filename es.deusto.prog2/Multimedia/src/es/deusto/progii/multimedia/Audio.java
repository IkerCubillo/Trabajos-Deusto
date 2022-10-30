package es.deusto.progii.multimedia;

public class Audio extends Multimedia {
	// Propiedades
	private int ancho = 0;
	private int alto = 0;
	private int resolucion = 0;
	private int profundidad;
	private String colores = "";
	
	// Constructores
	public Imagen() {
	}
	
	public Imagen(String nombre, String rutaFichero, int fechaCreacion, int tama�o, int ancho, int alto, int resolucion, int profundidad, String colores) {
		super(nombre,rutaFichero,fechaCreacion,tama�o);
		this.ancho = ancho;
		this.alto = alto;
		this.resolucion = resolucion;
		this.profundidad = profundidad;
		this.colores = colores;
	}
	
	// Metodos
	public int getAncho() {
		return this.ancho;
	}
	public int getAlto() {
		return this.alto;
	}
	public int getResolucion() {
		return this.resolucion;
	}
	public int getProfundidad() {
		return this.profundidad;
	}
	public String getColores() {
		return this.colores;
	}	
}
