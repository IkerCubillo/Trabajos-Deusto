package examen202205.datos;

import java.util.Date;

import examen202205.Utils;
import examen202205.gui.VentanaVisualizacionRegistros;

/** Registro de atención a consulta de usuario
 */
public class Consulta extends Registro implements RegistroDeUsuario {

	/** Crea una nueva consulta partiendo de una línea de texto con todos los datos en orden, separados por tabulador
	 * Ejemplo de línea: "Consulta	18/03/2022 12:00	andoni	Consulta de operaciones	9	92500"
	 * @param linea	Línea de texto de la que extraer los datos
	 * @return	nuevo objeto con esos datos, null si hay algún error
	 * @throws Exception	Si hay cualquier error de datos o formato en la línea recibida
	 */
	public static Consulta crearDeLinea( String linea ) throws Exception {
		if (!linea.startsWith("Consulta\t")) {
			return null;
		}
		String[] partes = linea.split( "\t" );
		Date fecha =  Utils.getFechaFromString( partes[1] );
		int valoracion = Integer.parseInt( partes[4] );
		int duracion = Integer.parseInt( partes[5] );
		Consulta nueva = new Consulta( fecha, partes[2], partes[3], valoracion, duracion );
		return nueva;
	}
	
	protected String usuario;
	protected String tipoConsulta;
	protected int gradoSatisfaccion;
	protected long tiempoAtencionMilis;
	public Consulta(Date fecha, String usuario, String tipoConsulta, int gradoSatisfaccion, long tiempoAtencion) {
		super(fecha);
		this.usuario = usuario;
		this.tipoConsulta = tipoConsulta;
		this.gradoSatisfaccion = gradoSatisfaccion;
		this.tiempoAtencionMilis = tiempoAtencion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	/** Devuelve el grado de satisfacción (valor de 0 a 10)
	 * @return	Grado de satisfacción del usuario
	 */
	public int getGradoSatisfaccion() {
		return gradoSatisfaccion;
	}
	/** Modifica el grado de satisfacción del usuario
	 * @param gradoSatisfaccion	Nuevo valor, de 0 a 10
	 */
	public void setGradoSatisfaccion(int gradoSatisfaccion) {
		this.gradoSatisfaccion = gradoSatisfaccion;
	}
	public long getTiempoAtencionMilis() {
		return tiempoAtencionMilis;
	}
	public void setTiempoAtencionMilis(long tiempoAtencion) {
		this.tiempoAtencionMilis = tiempoAtencion;
	}

	@Override
	public String toString() {
		return "{" + super.toString() + " " + usuario + " - " + tipoConsulta + " / " + tiempoAtencionMilis/1000 + " sgs.}";
	}
	
	@Override
	public boolean esDeUsuario(String usuario) {
		return this.usuario.equals( usuario );
	}

	@Override
	public void dibuja( VentanaVisualizacionRegistros ventana, double x, double y ) {
		double zoom = Utils.proyectar( tiempoAtencionMilis, 30000, 300000, 0.05, 0.15, true );  // Convierte el valor (30 a 300 segundos) en un rango de zoom de la imagen del 5% al 15%
		ventana.dibujaImagen( "../gui/img/consulta.png", x, y, zoom, 0, 1.0f );
	}

	@Override
	public boolean leerDatosDeTeclado() {
		boolean ret = super.leerDatosDeTeclado();  // Lee la fecha (padre)
		if (ret) { // Leer el resto de datos
			String usuario = Utils.leerString( "Introduce usuario:", this.usuario );
			if (usuario==null) {
				return false;
			}
			String tipoConsulta = Utils.leerString( "Introduce descripción de consulta:", this.tipoConsulta );
			if (tipoConsulta == null) {
				return false;
			}
			int gradoSat = Utils.leerInt( "Introduce grado de satisfacción del usuario (0-10)", this.gradoSatisfaccion, 0, 10 );
			if (gradoSat == Integer.MAX_VALUE) {
				return false;
			}
			int tiempo = Utils.leerInt( "Introduce tiempo de la consulta (en segundos)", (int)(this.tiempoAtencionMilis/1000), true );
			if (tiempo == Integer.MAX_VALUE) {
				return false;
			}
			this.usuario = usuario;
			this.tipoConsulta = tipoConsulta;
			this.gradoSatisfaccion = gradoSat;
			this.tiempoAtencionMilis = tiempo * 1000;
			return true;
		} else {
			return false;
		}		
	}
	
}
