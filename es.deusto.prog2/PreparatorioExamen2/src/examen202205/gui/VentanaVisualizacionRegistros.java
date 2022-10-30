package examen202205.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.GregorianCalendar;
import examen202205.GrupoRegistros;
import examen202205.Utils;
import examen202205.datos.Registro;

/** Ventana gráfica de visualización de registros
 * Incluye los mecanismos de interacción visual con el usuario para lectura de datos
 */
public class VentanaVisualizacionRegistros extends VentanaGrafica {
	private static final int MARGEN_IZQ = 70;  // Píxeles de margen izquierdo para los textos de las horas a la izquierda del gráfico
	private static final int MARGEN_INF = 20;  // Píxeles de margen inferior para los textos de las fechas debajo del gráfico
	private static final int OTROS_MARGENES = 25;  // Píxeles de margen para la visualización en los límites superior y derecho de la ventana
	private static final int MARGEN_HORAS = 20;  // Píxeles de margen vertical para empezar el concepto visual de hora de cada día
	private static final Font FONT_TEXTO_ROTULOS = new Font( "Arial", Font.PLAIN, 18 );  // Tipo de letra de rótulo de fechas y horas
	
	GrupoRegistros grupoRegistros;  // Grupo de registros visualizado en la ventana
	
	// Datos para la visualización
	int xInicial = MARGEN_IZQ;  // x de la fecha inicial del gráfico
	Date fechaInicial; // Fecha inicial del gráfico
	Date fechaFinal; // Fecha final del gráfico
	int numDias;   // Número de días en las fechas del grupo (entre la inicial y la final)
	int pixelesDia;   // Número de píxeles entre cada día y el siguiente (en horizontal)
	int yInicial = OTROS_MARGENES;  // y inicial del gráfico
	int yFinal;      // y de la línea de base
	int y0; // y de la hora inicial del día (00:00)
	int y24; // y de la hora final del día (24:00)
	double pixelesPorSg;  // Pixels por cada segundo del día
	
	/** Crea una ventana de visualización de registros
	 * @param anchura	Anchura en píxels
	 * @param altura	Altura en píxels
	 * @param titulo	Título de la ventana
	 */
	public VentanaVisualizacionRegistros(int anchura, int altura, String titulo) {
		super(anchura, altura, titulo, Color.WHITE);
	}

	/** Define el grupo de registros al que se asocia la ventana de visualización
	 * @param grupo	Nuevo grupo de registros, null si no se quiere asociar a ninguno
	 */
	public void setGrupoRegistros( GrupoRegistros grupo ) {
		grupoRegistros = grupo;
	}
	
	public void visualizarGraficoFechas() {
		if (grupoRegistros==null || grupoRegistros.size()==0) {
			return; // No hay registros, nada que visualizar
		}		
		calculayDibujaLimites();
		for (Registro registro : grupoRegistros.getListaRegistros()) {
			registro.dibuja( this, getXDia(registro.getFecha()), getYDia(registro.getFecha()) );
		}
	}
	
	// Calcula los datos para los ejes del gráfico y dibuja los límites y rótulos
	private void calculayDibujaLimites() {
		borra();
		// Calcula fechas extremas
		fechaInicial = new Date(Long.MAX_VALUE);  // Muy grande (cualquiera será menor que esta)
		fechaFinal = new Date(0);  // Muy pequeña (cualquiera será mayor que esta)
		for (Registro r : grupoRegistros.getListaRegistros()) {
			if (r.getFecha().compareTo(fechaInicial) < 0) {
				fechaInicial = r.getFecha();
			}
			if (r.getFecha().compareTo(fechaFinal) > 0) {
				fechaFinal = r.getFecha();
			}
		}
		// Pone las dos fechas a la misma hora, media del día (para calcular sin errores los días de diferencia)
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime( fechaInicial );
		gc.set( GregorianCalendar.HOUR_OF_DAY, 12 );
		fechaInicial = new Date( gc.getTimeInMillis() );
		gc.setTime( fechaFinal );
		gc.set( GregorianCalendar.HOUR_OF_DAY, 12 );
		fechaFinal = new Date( gc.getTimeInMillis() );
		// Calcula el resto de variables de dibujado dependiendo de los días que hay y del tamaño de la ventana
		numDias = (int) Math.round( (fechaFinal.getTime() - fechaInicial.getTime()) / (24*3600000.0) ) + 1;
		pixelesDia = (getAnchura() - MARGEN_IZQ - OTROS_MARGENES) / (numDias-1);
		yFinal = (getAltura() - OTROS_MARGENES - MARGEN_INF);
		y0 = yInicial + MARGEN_HORAS;
		y24 = yFinal - MARGEN_HORAS;
		pixelesPorSg = (y24 - y0) / (24*3600.0);
		// Dibuja los ejes horizontales
		dibujaLinea( 0, yInicial, getAnchura(), yInicial, 2.0f, Color.BLACK );  // Barra superior
		dibujaLinea( xInicial, y0, xInicial+pixelesDia*(numDias-1), y0, 1.0f, Color.LIGHT_GRAY );  // Marca de las 0 horas
		dibujaLinea( xInicial, (y0+y24)/2, xInicial+pixelesDia*(numDias-1), (y0+y24)/2, 1.0f, Color.LIGHT_GRAY );  // Marca de las 12 horas
		dibujaLinea( xInicial, y24, xInicial+pixelesDia*(numDias-1), y24, 1.0f, Color.LIGHT_GRAY );  // Marca de las 24
		dibujaLinea( 0, yFinal, getAnchura(), yFinal, 2.0f, Color.BLACK );  // Barra inferior
		// Rotula las fechas y las horas
		int xDia = xInicial;
		Date fechaDia = new Date( fechaInicial.getTime() );
		for (int i = 0; i < numDias; i++) {
			dibujaTextoCentrado( xDia-pixelesDia/2, yFinal, pixelesDia, MARGEN_INF, 
					Utils.FORMATEADOR_FECHA_DM.format( fechaDia ), FONT_TEXTO_ROTULOS, Color.BLACK, true );
			xDia += pixelesDia;
			fechaDia.setTime( fechaDia.getTime() + 3600000L*24L );
		}
		dibujaTextoCentrado( 0, y0-30, xInicial, 60, "00:00", FONT_TEXTO_ROTULOS, Color.BLACK, true );
		dibujaTextoCentrado( 0, (y0+y24)/2-30, xInicial, 60, "12:00", FONT_TEXTO_ROTULOS, Color.BLACK, true );
		dibujaTextoCentrado( 0, y24-30, xInicial, 60, "24:00", FONT_TEXTO_ROTULOS, Color.BLACK, true );
	}

	// Devuelve la coordenada X de un día-hora dado, ya calculadas las variables de pantalla
	private double getXDia( Date fecha ) {
		int numDiasDesdeInicio = (int) Math.round( (fecha.getTime() - fechaInicial.getTime()) / (24*3600000.0) );
		return xInicial + numDiasDesdeInicio * pixelesDia;
	}
	
	// Devuelve la coordenada Y de un día-hora dado, ya calculadas las variables de pantalla
	private double getYDia( Date fecha ) {
		int segs = Utils.getSegundosDelDia(fecha);
		return y0 + segs * pixelesPorSg;
	}
	
}
