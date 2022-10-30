package examen202205.datos;

import java.util.Date;
import examen202205.Utils;
import examen202205.gui.VentanaVisualizacionRegistros;

/** Registro de datos. Clase abstracta con lo común de toda la jerarquía de registros
 */
public abstract class Registro 
{
	
	/** Crea un nuevo registro partiendo de una línea de texto con todos los datos en orden, separados por tabulador
	 * El objeto que se crea depende de la línea y se instancia alguna de las clases hijas (PrecioCarburante, PrecioElectricidad, etc.)
	 * @param linea	Línea de texto de la que extraer los datos
	 * @return	nuevo registro con esos datos, null si hay algún error
	 * @throws Exception	Si hay cualquier error de datos o formato en la línea recibida
	 */
	public static Registro crearDeLinea( String linea ) throws Exception {
		Registro registro = PrecioCarburante.crearDeLinea( linea );
		if (registro!=null) {
			return registro;
		}
		registro = PrecioElectricidad.crearDeLinea( linea );
		if (registro!=null) {
			return registro;
		}
		registro = SesionUsuario.crearDeLinea( linea );
		if (registro!=null) {
			return registro;
		}
		registro = Consulta.crearDeLinea( linea );
		if (registro!=null) {
			return registro;
		}
		return null;
	}

	
	protected Date fecha;
	public Registro(Date fecha) {
		super();
		this.fecha = fecha;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/** Dibuja simbólicamente el registro
	 * @param ventana	Ventana en la que dibujarlo
	 * @param x	Coordenada x del centro de dibujado
	 * @param y	Coordenada y del centro de dibujado
	 */
	public abstract void dibuja( VentanaVisualizacionRegistros ventana, double x, double y );
	
	/** Lee por teclado los datos del registro (partiendo de los que ya tenga)
	 * Operación bloqueante (no devuelve el control hasta que el usuario introduzca una fecha correcta o pulse Escape))
	 * @return	true si se han introducido datos correctamente, false si el usuario ha pulsado escape o cierre de cualquiera de las ventanas de la interacción
	 */
	public boolean leerDatosDeTeclado() {
		Date nuevaFecha = Utils.leerFechaHoraDeTeclado( fecha );
		if (nuevaFecha!=null) {
			fecha = nuevaFecha;
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return Utils.FORMATEADOR_FECHA_DMA_HM.format( fecha );
	}
	
}
