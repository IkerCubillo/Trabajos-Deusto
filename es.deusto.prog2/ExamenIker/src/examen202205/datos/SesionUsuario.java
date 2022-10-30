package examen202205.datos;

import java.io.Serializable;
import java.util.Date;
import examen202205.Utils;
import examen202205.gui.VentanaVisualizacionRegistros;

/** Registro de sesión de usuario
 */
public class SesionUsuario extends Registro implements RegistroDeUsuario, Serializable {
	
	/** Crea una nueva sesión partiendo de una línea de texto con todos los datos en orden, separados por tabulador
	 * Ejemplo de línea: "DuracionSesion	18/03/2022 12:10	andoni	25500"
	 * @param linea	Línea de texto de la que extraer los datos
	 * @return	nuevo objeto con esos datos, null si hay algún error
	 * @throws Exception	Si hay cualquier error de datos o formato en la línea recibida
	 */
	public static SesionUsuario crearDeLinea( String linea ) throws Exception {
		if (!linea.startsWith("DuracionSesion\t")) {
			return null;
		}
		String[] partes = linea.split( "\t" );
		Date fecha =  Utils.getFechaFromString( partes[1] );
		int duracion = Integer.parseInt( partes[3] );
		SesionUsuario nueva = new SesionUsuario( fecha, partes[2], duracion );
		return nueva;
	}
	
	protected String usuario;
	int duracionSesionMilis;
	public SesionUsuario(Date fecha, String usuario, int duracionSesionMilis) {
		super(fecha);
		this.usuario = usuario;
		this.duracionSesionMilis = duracionSesionMilis;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getDuracionSesionMilis() {
		return duracionSesionMilis;
	}
	public void setDuracionSesionMilis(int duracionSesionMilis) {
		this.duracionSesionMilis = duracionSesionMilis;
	}

	@Override
	public String toString() {
		return "{" + super.toString() + " " + usuario + " - " + duracionSesionMilis/1000 + " sgs.}";
	}
	
	@Override
	public boolean esDeUsuario(String usuario) {
		return this.usuario.equals( usuario );
	}
	
	@Override
	public void dibuja( VentanaVisualizacionRegistros ventana, double x, double y ) {
		double zoom = Utils.proyectar( duracionSesionMilis, 30000, 300000, 0.05, 0.15, true );  // Convierte el valor (30 a 300 segundos) en un rango de zoom de la imagen del 5% al 15%
		ventana.dibujaImagen( "../gui/img/sesion.png", x, y, zoom, 0, 1.0f );
	}

	@Override
	public boolean leerDatosDeTeclado() {
		boolean ret = super.leerDatosDeTeclado();  // Lee la fecha (padre)
		if (ret) { // Leer el resto de datos
			String usuario = Utils.leerString( "Introduce usuario:", this.usuario );
			if (usuario==null) {
				return false;
			}
			int tiempo = Utils.leerInt( "Introduce tiempo de duración de la sesión (en segundos)", (int)(this.duracionSesionMilis/1000), true );
			if (tiempo == Integer.MAX_VALUE) {
				return false;
			}
			this.usuario = usuario;
			this.duracionSesionMilis = tiempo * 1000;
			return true;
		} else {
			return false;
		}		
	}
	
}
