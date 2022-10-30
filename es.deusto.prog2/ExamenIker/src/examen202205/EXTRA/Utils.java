package examen202205;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/** Utilidades de fechas
 */
public class Utils {

	public static final SimpleDateFormat FORMATEADOR_FECHA_AAAAMMDD = new SimpleDateFormat( "yyyyMMdd" );
	public static final SimpleDateFormat FORMATEADOR_FECHA_AAAAMMDD_HM = new SimpleDateFormat( "yyyyMMdd HH:mm" );
	public static final SimpleDateFormat FORMATEADOR_FECHA_DMA = new SimpleDateFormat( "dd/MM/yy" );
	public static final SimpleDateFormat FORMATEADOR_FECHA_DM = new SimpleDateFormat( "dd/MM" );
	public static final SimpleDateFormat FORMATEADOR_FECHA_DMA_HM = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );
	public static final SimpleDateFormat FORMATEADOR_FECHA_HMS = new SimpleDateFormat( "HHmmss" );


	/** Devuelve la fecha en formato AAAAMMDD
	 * @param fecha
	 * @return	Fecha representada en un string en formato AAAAMMDD
	 */
	public static String getAAAAMMDDdeFecha( Date fecha ) {
		return FORMATEADOR_FECHA_AAAAMMDD.format( fecha );
	}
	
	/** Devuelve la hora de la fecha en segundos
	 * @param fecha
	 * @return	Hora de esa fecha, en segundos respecto a su día (0=00:00, 3600=01:00, 3600*24-1 sería el último segundo del día)
	 */
	public static int getSegundosDelDia( Date fecha ) {
		String hhmmss = FORMATEADOR_FECHA_HMS.format( fecha );
		int segundos = Integer.parseInt( hhmmss.substring(0,2) ) * 3600 + 
			Integer.parseInt( hhmmss.substring(2,4) ) * 60 + Integer.parseInt( hhmmss.substring(4) );
		return segundos;
	}
	
	/** Convierte string a fecha
	 * @param fechaEnString	String representando a la fecha dd/MM/yyyy HH:mm
	 * @return	Fecha correspondiente
	 * @throws ParseException	Error si el formato de la fecha no es el correcto
	 */
	public static Date getFechaFromString( String fechaEnString ) throws ParseException {
		Date fecha =  Utils.FORMATEADOR_FECHA_DMA_HM.parse( fechaEnString );
		return fecha;
	}
	
	/** Proyecta un valor en un rango diferente
	 * @param valor	Valor de partida
	 * @param refIni	Inicio del rango 1
	 * @param refFin	Final del rango 1 (debe cumplirse que refFin > refIni)
	 * @param nuevaRefIni	Inicio del rango 2
	 * @param nuevaRefFin	Final del rango 2
	 * @param truncar	true para truncar el valor al rango 1, false sin truncado
	 * @return	Devuelve la conversión del valor proyectado del rango 1 al rango 2. Si truncar es true, limita el valor al extremo del rango
	 */
	public static double proyectar( double valor, double refIni, double refFin, double nuevaRefIni, double nuevaRefFin, boolean truncar ) {
		if (truncar) {
			if (valor < refIni) {
				valor = refIni;
			}
			if (valor > refFin) {
				valor = refFin;
			}
		}
		double porcPartida = (valor - refIni) / (refFin - refIni); // Porcentaje de 0.0 a 1.0 del valor sobre el rango 1  (<0 o >1 si está fuera del rango y truncar es false)
		return nuevaRefIni + (nuevaRefFin-nuevaRefIni)*porcPartida;
	}

	/** Lee por teclado una fecha-hora en formato "dd/MM/yyyy HH:mm". Si se introduce con formato incorrecto, se solicita de nuevo hasta que sea correcta o se pulse Escape
	 * Operación bloqueante (no devuelve el control hasta que el usuario introduzca una fecha correcta o pulse Escape))
	 * @param fechaHoraPorDefecto	Fecha que aparece inicialmente (null para fecha de hoy)
	 * @return	Fecha introducida por el usuario, null si se escapa
	 */
	public static Date leerFechaHoraDeTeclado( Date fechaHoraPorDefecto ) {
		Date ret = fechaHoraPorDefecto;
		if (ret==null) {
			ret = new Date();  // Fecha actual
		}
		String mens = "Introduce fecha:";
		do {
			String ini = FORMATEADOR_FECHA_DMA_HM.format( ret );
			ini = JOptionPane.showInputDialog( null, mens, ini );
			if (ini==null) {  // Al pulsar escape o cerrar el diálogo se devuelve null
				return null;
			}
			try {
				ret = FORMATEADOR_FECHA_DMA_HM.parse( ini );
				return ret;
			} catch (ParseException e) {
				mens = "Fecha incorrecta. Revisa formato (dd/mm/aaaa hh:mm) y vuelve a intentarlo:";
			}
		} while (true); // Se repite hasta que se meta fecha correcta o escape
	}

	/** Lee por teclado un valor real. Si se introduce con formato incorrecto, se solicita de nuevo hasta que sea correcto o se pulse Escape
	 * Operación bloqueante (no devuelve el control hasta que el usuario introduzca un valor correcto o pulse Escape))
	 * @param mensajeValor	Mensaje que explica el valor pedido que aparecerá en la ventana para que el usuario entienda qué se pide
	 * @param valorPorDefecto	Valor que aparece inicialmente
	 * @param mayorQueCero	true si se quiere obligar a que el usuario introduzca un número positivo no cero, false cualquier double válido
	 * @return	Valor introducido por el usuario, Double.MAX_VALUE si se escapa
	 */
	public static double leerDouble( String mensajeValor, double valorPorDefecto, boolean mayorQueCero ) {
		double ret = valorPorDefecto;
		String mens = mensajeValor;
		do {
			String valTecleado = JOptionPane.showInputDialog( null, mens, ret+"" );
			if (valTecleado==null) {  // Al pulsar escape o cerrar el diálogo se devuelve código de error
				return Double.MAX_VALUE;
			}
			try {
				valTecleado = valTecleado.replaceAll( ",", "." ); // +Permite la coma decimal española
				ret = Double.parseDouble( valTecleado );
				if (ret <= 0 && mayorQueCero) {
					mens = "Valor incorrecto, se requiere positivo. Vuelve a intentarlo. " + mensajeValor;
					continue;
				}
				return ret;
			} catch (NumberFormatException e) {
				mens = "Valor incorrecto. Revisa formato y vuelve a intentarlo. " + mensajeValor;
			}
		} while (true); // Se repite hasta que se meta valor correcto o escape
	}

	/** Lee por teclado un valor entero. Si se introduce con formato incorrecto, se solicita de nuevo hasta que sea correcto o se pulse Escape
	 * Operación bloqueante (no devuelve el control hasta que el usuario introduzca un valor correcto o pulse Escape))
	 * @param mensajeValor	Mensaje que explica el valor pedido que aparecerá en la ventana para que el usuario entienda qué se pide
	 * @param valorPorDefecto	Valor que aparece inicialmente
	 * @param mayorQueCero	true si se quiere obligar a que el usuario introduzca un número positivo no cero, false cualquier int válido
	 * @return	Valor introducido por el usuario, Integer.MAX_VALUE si se escapa
	 */
	public static int leerInt( String mensajeValor, int valorPorDefecto, boolean mayorQueCero ) {
		int ret = valorPorDefecto;
		String mens = mensajeValor;
		do {
			String valTecleado = JOptionPane.showInputDialog( null, mens, ret+"" );
			if (valTecleado==null) {  // Al pulsar escape o cerrar el diálogo se devuelve código de error
				return Integer.MAX_VALUE;
			}
			try {
				ret = Integer.parseInt( valTecleado );
				if (ret <= 0 && mayorQueCero) {
					mens = "Valor incorrecto, se requiere positivo. Vuelve a intentarlo. " + mensajeValor;
					continue;
				}
				return ret;
			} catch (NumberFormatException e) {
				mens = "Valor incorrecto. Revisa formato y vuelve a intentarlo. " + mensajeValor;
			}
		} while (true); // Se repite hasta que se meta valor correcto o escape
	}
	
	/** Lee por teclado un valor entero. Si se introduce con formato incorrecto, se solicita de nuevo hasta que sea correcto o se pulse Escape
	 * Operación bloqueante (no devuelve el control hasta que el usuario introduzca un valor correcto o pulse Escape))
	 * @param mensajeValor	Mensaje que explica el valor pedido que aparecerá en la ventana para que el usuario entienda qué se pide
	 * @param valorPorDefecto	Valor que aparece inicialmente
	 * @param menorValorAceptable	Valor mínimo válido
	 * @param mayorValorAceptable	Valor máximo válido
	 * @return	Valor introducido por el usuario, Integer.MAX_VALUE si se escapa
	 */
	public static int leerInt( String mensajeValor, int valorPorDefecto, int menorValorAceptable, int mayorValorAceptable ) {
		int ret = valorPorDefecto;
		String mens = mensajeValor;
		do {
			String valTecleado = JOptionPane.showInputDialog( null, mens, ret+"" );
			if (valTecleado==null) {  // Al pulsar escape o cerrar el diálogo se devuelve código de error
				return Integer.MAX_VALUE;
			}
			try {
				ret = Integer.parseInt( valTecleado );
				if (ret < menorValorAceptable || ret > mayorValorAceptable) {
					mens = "Valor incorrecto, se requiere en el rango (" + menorValorAceptable + "," + mayorValorAceptable + "). Vuelve a intentarlo. " + mensajeValor;
					continue;
				}
				return ret;
			} catch (NumberFormatException e) {
				mens = "Valor incorrecto. Revisa formato y vuelve a intentarlo. " + mensajeValor;
			}
		} while (true); // Se repite hasta que se meta valor correcto o escape
	}
	
	/** Lee por teclado un valor string.
	 * Operación bloqueante (no devuelve el control hasta que el usuario introduzca un valor no vacío o pulse Escape))
	 * @param mensajeValor	Mensaje que explica el valor pedido que aparecerá en la ventana para que el usuario entienda qué se pide
	 * @param valorPorDefecto	Valor que aparece inicialmente
	 * @return	Valor introducido por el usuario, null si se escapa
	 */
	public static String leerString( String mensajeValor, String valorPorDefecto ) {
		String ret = valorPorDefecto;
		String mens = mensajeValor;
		do {
			String valTecleado = JOptionPane.showInputDialog( null, mens, ret+"" );
			if (valTecleado==null) {  // Al pulsar escape o cerrar el diálogo se devuelve null
				return null;
			}
			ret = valTecleado;
			if (ret.isEmpty()) {
				mens = "Valor incorrecto, se requiere string no vacío. Vuelve a intentarlo. " + mensajeValor;
				continue;
			}
			return ret;
		} while (true); // Se repite hasta que se meta valor correcto o escape
	}
	
	/** Permite seleccionar por teclado un valor string de una lista de posibles valores.
	 * Operación bloqueante (no devuelve el control hasta que el usuario seleccione un valor o pulse Escape))
	 * @param mensajeValor	Mensaje que explica el valor pedido que aparecerá en la ventana para que el usuario entienda qué se pide
	 * @param valorPorDefecto	Valor que aparece inicialmente
	 * @param valoresPosibles	Valores entre los que elegir, de cualquier tipo que se convertirá a string (valorPorDefecto debe estar entre ellos)
	 * @return	Valor introducido por el usuario, null si se escapa
	 */
	public static String leerStringOpciones( String mensajeValor, String valorPorDefecto, Object[] valoresPosibles ) {
		String[] valoresString = new String[ valoresPosibles.length ];
		for (int i=0; i<valoresPosibles.length; i++) {
			valoresString[i] = valoresPosibles[i].toString();
		}
		String valTecleado = (String) JOptionPane.showInputDialog( null, mensajeValor, null, JOptionPane.QUESTION_MESSAGE, null, valoresString, valorPorDefecto );
		if (valTecleado==null || valTecleado.isEmpty()) {  // Al pulsar escape o cerrar el diálogo se devuelve null
			return null;
		}
		return valTecleado;
	}

}
