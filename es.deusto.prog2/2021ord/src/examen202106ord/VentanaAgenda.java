package examen202106ord;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;

/** Ventana para la visualización e interacción con la agenda
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
@SuppressWarnings("serial")
public class VentanaAgenda extends JFrame {

	//================= Parte static
	private static final Color COLOR_CAB = Color.LIGHT_GRAY;  // Color de fondo de las cabeceras
	private static final Color COLOR_FEST = new Color( 230, 230, 230 ); // Color de fondo de los festivos  (gris muy clarito)
	private static final Color COLOR_TEXCAB = Color.BLACK;    // Color de texto de las cabeceras
	private static final Color COLOR_TABLA = Color.DARK_GRAY; // Color de las líneas de la tabla
	private static final int ANCHO_HORAS = 50;                // Anchura (en píxels) del lateral donde se marcan las horas
	private static final int ALTO_CABECERA = 30;              // Altura (en píxels) de la cabecera de cada columna (fecha)
	private static final int NUM_DIAS = 7;                    // Número de días que se ven en columnas en la ventana
	private static final int HORA_INICIO = 8;                 // Hora inicial diaria en la agenda
	private static final int HORA_FIN = 23;                   // Hora final diaria en la agenda
	private static final Font TIPO_TEXTO = new Font( "Arial", Font.PLAIN, 14 ); // Tipografía de los textos que se muestran en la agenda
	private static final Font TIPO_MENSAJE = new Font( "Arial", Font.BOLD, 14 ); // Tipografía de los mensajes
	
	
	private static final SimpleDateFormat dmy = new SimpleDateFormat( "dd/MM/yyyy" );
	
	//================= Parte no static
	
	private JButton bTrash;         // Botón papelera
	private JButton bIzq;           // Botón izquierda
	private JButton bDer;           // Botón derecha
	private JButton bUsuario;       // Botón de usuario
	private JPanel pAgenda;         // Panel de dibujo de agenda
	private JLabel lMensaje;        // Label de mensaje
	private int inicioXAgenda;      // Inicio horizontal del espacio visual de la tabla de la agenda
	private int inicioYAgenda;      // Inicio vertical del espacio visual de la tabla de la agenda
	private int anchoColumna;       // Píxels de ancho de cada columna (día)
	private int altoHora;           // Píxels de alto de cada hora
	private Date fechaInicial;      // Fecha inicial a visualizar en la ventana (fecha de la primera columna a las 0:00 de ese día)
	private GestorAgenda gestor;    // Gestor de agenda
	
	// Tarea 4 - atributos
	
	/** Crea una nueva ventana de agenda
	 * @param anchura	Anchura de la ventana en píxels
	 * @param altura	Altura de la ventana en píxels
	 * @param gestor	Gestor de agenda asociado a la ventana 
	 */
	public VentanaAgenda( int anchura, int altura, GestorAgenda gestor ) {
		this.gestor = gestor;
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Agenda Deusto" );
		setSize( anchura, altura );
		// Creación contenedores
		JPanel pIzquierda = new JPanel();
		pAgenda = new PanelGrafico();
		JPanel pSuperior = new JPanel();
		// Formato contenedores
		pIzquierda.setLayout( new BoxLayout( pIzquierda, BoxLayout.Y_AXIS ) );
		pAgenda.setLayout( null );
		// Creación componentes
		lMensaje = new JLabel( " " );
		try {  // Botones gráficos
			bIzq = new JButton( new ImageIcon( VentanaAgenda.class.getResource("img/flechaIzqda.png").toURI().toURL() ) );
			bDer = new JButton( new ImageIcon( VentanaAgenda.class.getResource("img/flechaDcha.png").toURI().toURL() ) );
			bUsuario = new JButton( new ImageIcon( VentanaAgenda.class.getResource("img/user.png").toURI().toURL() ) );
			bTrash = new JButton( new ImageIcon( VentanaAgenda.class.getResource("img/trash.png").toURI().toURL() ) );
		} catch (Exception e1) {  // Si hay error, botones texto
			bIzq = new JButton( "Antes" );
			bDer = new JButton( "Después" );
			bUsuario = new JButton( "Usuario" );
			bTrash = new JButton( "Borrar" );
		}
		// Formato componentes
		lMensaje.setFont( TIPO_MENSAJE );
		// Asignación componentes a contenedores
		pIzquierda.add( bIzq );
		pIzquierda.add( bDer );
		pIzquierda.add( bUsuario );
		pIzquierda.add( bTrash );
		getContentPane().add( pIzquierda, BorderLayout.WEST );
		pSuperior.add( lMensaje );
		getContentPane().add( pSuperior, BorderLayout.NORTH );
		getContentPane().add( pAgenda, BorderLayout.CENTER );
		// Eventos
		pAgenda.addComponentListener( new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// Inicialización de atributos de información visual - se actualizan cuando cambia el tamaño del panel
				inicioXAgenda = ANCHO_HORAS;
				inicioYAgenda = ALTO_CABECERA;
				anchoColumna = (pAgenda.getWidth() - inicioXAgenda) / NUM_DIAS;
				altoHora = (pAgenda.getHeight() - inicioYAgenda) / (HORA_FIN - HORA_INICIO);
				for (EspacioAgenda espacio : gestor.listaAgenda) {
					espacio.recalculaPosicion();
				}
			}
		});
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date fechaEnClick = getFechaDePunto( e.getX(), e.getY() );
				gestor.crearEspacioInteractivo( fechaEnClick );
			}
		};
		pAgenda.addMouseListener( ma );
		bDer.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mueveDias( +1 );
				recalculaPosiciones();
				repaint();
			}
		});
		bIzq.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mueveDias( -1 );
				recalculaPosiciones();
				repaint();
			}
		});
		bTrash.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.borrarAgendaActual( true );
			}
		});
		bUsuario.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestor.login();
			}
		});
		// Tarea 5 - opción B - hilo de visión de todas las citas
	}
	
	/** Añade el escuchador de ratón correspondiente al espacio de agenda
	 * @param espacio	Espacio al que añadir gestor de eventos de ratón
	 */
	public void anyadirGestorRaton( EspacioAgenda espacio ) {
		for (MouseListener ml : espacio.getMouseListeners()) { espacio.removeMouseListener( ml ); }  // Borra todos los escuchadores previos MouseListener
		for (MouseMotionListener mml : espacio.getMouseMotionListeners()) { espacio.removeMouseMotionListener( mml ); }  // Borra todos los escuchadores previos MouseMotionListener
		MouseAdapter ma = new MouseAdapter() {
			private EspacioAgenda miEspacio = espacio;
			private Point enDrag = null;
			@Override
			public void mouseClicked(MouseEvent e) {
				gestor.clickEnEspacio( espacio );
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				if (miEspacio instanceof Movible) {
					if (enDrag != null) {
						gestor.dragEnEspacio( espacio, e.getLocationOnScreen().x - enDrag.x, e.getLocationOnScreen().y - enDrag.y );
					}
					enDrag = e.getLocationOnScreen();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (enDrag != null) {
					gestor.finDragEnEspacio( espacio, e.getLocationOnScreen() );
				}
				enDrag = null;
			}
		};
		espacio.addMouseListener( ma );
		espacio.addMouseMotionListener( ma );
		// Tarea 4
	}
	
	/** Recalcula las posiciones de todos los espacios (llamar a este método si se cambian las fechas de visualización de la agenda)
	 */
	public void recalculaPosiciones() {
		for (EspacioAgenda sa : gestor.getListaAgenda()) {
			sa.recalculaPosicion();
		}
	}
	
	/** Devuelve la fecha inicial visualizada en la ventana
	 * @return	Fecha de la primera columna
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}
	
	/** Devuelve el panel principal de la agenda
	 * @return	Panel de visualización de espacios de la agenda
	 */
	public JPanel getPanel() {
		return pAgenda;
	}

	/** Devuelve el botón de papelera
	 * @return	Botón de papelera de la ventana
	 */
	public JButton getBotonTrash() {
		return bTrash;
	}
	
	/** Devuelve la fecha final visualizada en la ventana
	 * @return	Fecha de la última columna (a las 23:59)
	 */
	public Date getFechaFinal() {
		return new Date( fechaInicial.getTime() + 24*3600000L * NUM_DIAS - 60000L );
	}

	/** Modifica la fecha inicial visualizada en la ventana (no redibuja la ventana)
	 * @param fechaInicial	Nueva fecha inicial (primera columna)
	 */
	public void setFechaInicial(Date fechaInicial) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime( fechaInicial );
		gc.set( GregorianCalendar.HOUR_OF_DAY, 0 );
		gc.set( GregorianCalendar.MINUTE, 0 );
		gc.set( GregorianCalendar.SECOND, 0 );
		this.fechaInicial = gc.getTime();
	}
	
	/** Mueve los días de la agenda (no redibuja la ventana)
	 * @param diasDif	Número de días a mover - negativo hacia atrás, positivo hacia adelante
	 */
	public void mueveDias( int diasDif ) {
		setFechaInicial( new Date( fechaInicial.getTime() + diasDif * 24*3600000L ) );
	}
	
	/** Cambia el mensaje superior de la ventana
	 * @param mensaje	Texto del nuevo mensaje
	 */
	public void setMensajeSuperior( String mensaje ) {
		lMensaje.setText( mensaje );
	}
	
	/** Cierra la ventana
	 */
	public void cerrar() {
		dispose();
	}
	
	/** Devuelve la fecha-hora a la que corresponde un punto de pantalla en la agenda
	 * @param x	Coordenada horizontal del punto
	 * @param y	Coordenada vertical del punto
	 * @return	Fecha-hora a la que corresponde, null si está fuera del espacio visual válido de la agenda
	 */
	public Date getFechaDePunto( int x, int y ) {
		if (fechaInicial==null || x<inicioXAgenda || y<inicioYAgenda || x>=pAgenda.getWidth()-5 || y>pAgenda.getHeight()) {
			return null;
		} else {
			long fechaEnClick = fechaInicial.getTime();  // Fecha del primer día
			int diaClick = (x - inicioXAgenda) / anchoColumna;  // día de la coordenada (0-n)
			int minutosClick = (y - inicioYAgenda) * 60 / altoHora + HORA_INICIO * 60;
			fechaEnClick += (diaClick * 24*3600000L);  // Sumamos los días a la derecha
			fechaEnClick += (minutosClick * 60000L);  // Sumamos los minutos en vertical
			return new Date( fechaEnClick );
		}
	}

	/** Devuelve la coordenada x de una fecha-hora en la visualización de la agenda actual
	 * @param fecha	Fecha-hora a comprobar
	 * @return	coordenada x donde se inicia esa fecha-hora, negativa si no corresponde a la agenda visible actual
	 */
	public int getXFecha( Date fecha ) {
		if (fechaInicial==null) return -1;
		else if (fecha.before( fechaInicial )) return -1;
		else if (fecha.after( getFechaFinal() )) return -1;
		else {
			return inicioXAgenda + (int) ((fecha.getTime() - fechaInicial.getTime()) / 24/3600000L * anchoColumna);   // Horizontal dependiendo del número de día
		}
	}
	
	/** Devuelve la coordenada y de una fecha-hora en la visualización de la agenda actual
	 * @param fecha	Fecha-hora a comprobar
	 * @return	coordenada y donde se inicia esa fecha-hora, negativa si no corresponde a la agenda visible actual
	 */
	public int getYFecha( Date fecha ) {
		if (fechaInicial==null) return -1;
		else if (fecha.before( fechaInicial )) return -1;
		else if (fecha.after( getFechaFinal() )) return -1;
		else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime( fecha );
			int minutos = gc.get( GregorianCalendar.HOUR_OF_DAY ) * 60 + gc.get( GregorianCalendar.MINUTE );
			return inicioYAgenda + (minutos - HORA_INICIO * 60) * altoHora / 60;  // Convertimos de minutos a píxels
		}
	}
	
	/** Calcula la altura en píxels de una duración de agenda
	 * @param minutos	Duración a comprobar
	 * @return	Altura en píxels de esa duración de acuerdo a la configuración actual de la ventana
	 */
	public int getAlturaPixels( int minutos ) {
		return minutos * altoHora / 60;
	}
	
	/** Devuelve la anchura de la columna de cada día en la visualización de la agenda
	 * @return	Ancho de un día en píxels
	 */
	public int getAnchoColumna() {
		return anchoColumna;
	}

	// Clase interna para el panel que dibuja las fechas y horas de la agenda
	class PanelGrafico extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;  // Componente gráfico en el que pintar el fondo de la agenda
			// Borra todo
			g2.setColor( Color.WHITE );
			g2.fillRect( 0, 0, getWidth(), getHeight() );
			// Pinta sábados y domingos
			if (fechaInicial!=null) {
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime( fechaInicial );
				for (int dia=0; dia<NUM_DIAS; dia++) {
					if (gc.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY || gc.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SATURDAY) {
						g2.setColor( COLOR_FEST );
						g2.fillRect( inicioXAgenda + dia*anchoColumna, inicioYAgenda, anchoColumna, getHeight() );
					}
					gc.setTimeInMillis( gc.getTimeInMillis() + 24*3600000L );
				}
			}
			// Dibuja cabeceras
			g2.setColor( COLOR_CAB );
			g2.fillRect( inicioXAgenda, 1, anchoColumna * NUM_DIAS, inicioYAgenda-1 );
			g2.setColor( COLOR_TABLA );
			g2.drawRect( inicioXAgenda, 1, anchoColumna * NUM_DIAS, inicioYAgenda-1 );
			// Dibuja columnas
			for (int dia=0; dia<=NUM_DIAS; dia++) {
				g2.drawRect( inicioXAgenda + dia*anchoColumna, 0, anchoColumna, getHeight() );
			}
			// Dibuja línea de cierre
			g2.drawRect( inicioXAgenda, getHeight(), inicioXAgenda + anchoColumna * NUM_DIAS, getHeight() );
			// Rotula horas
			g2.setFont( TIPO_TEXTO );
			g2.setColor( COLOR_TEXCAB );
			for (int hora=HORA_INICIO; hora<HORA_FIN; hora++) {
				g2.drawString( hora + ":00", inicioXAgenda-ANCHO_HORAS + 5, inicioYAgenda + (hora-HORA_INICIO)*altoHora );
			}
			// Rotula días
			if (fechaInicial!=null) {
				Date dia = new Date( fechaInicial.getTime() );
				for (int numDia=0; numDia<NUM_DIAS; numDia++) {
					g2.drawString( dmy.format( dia ), inicioXAgenda + numDia*anchoColumna + 10, 20 );
					dia.setTime( dia.getTime() + 24*3600000L );  // Avanza un día
				}
			}
		}
	}
	
}
