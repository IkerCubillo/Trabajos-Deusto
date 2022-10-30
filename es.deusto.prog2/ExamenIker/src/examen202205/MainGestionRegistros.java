package examen202205;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import examen202205.datos.Consulta;
import examen202205.datos.PrecioCarburante;
import examen202205.datos.PrecioElectricidad;
import examen202205.datos.Registro;
import examen202205.datos.SesionUsuario;
import examen202205.datos.TipoCarburante;
import examen202205.gui.VentanaVisualizacionRegistros;

/** Prueba de grupo de registros
 */
public class MainGestionRegistros {
	private static VentanaVisualizacionRegistros vent;  // Ventana con la que trabajar
	private static GrupoRegistros grupo;  // Grupo de registros con el que trabajar
	
	/** Método principal. Saca una ventana de visualización y el menú de opciones
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		// T1
		String dat = "registros.dat";
		String txt = "datos-registro.txt";
		if(datExist("registros.dat")) {
			grupo = new GrupoRegistros( txt ); //dat
		} else {
			grupo = new GrupoRegistros( txt );
		}
		
		vent = new VentanaVisualizacionRegistros( 800, 600, "Visualización registros" );
		vent.setGrupoRegistros(grupo);
		vent.visualizarGraficoFechas();
		menu();
		vent.acaba();
		grupo.guardarFicheroBinario(dat);
		
		// T1
		// T6
	}
	
	public static boolean datExist(String nomFichero) {
		try {
			FileInputStream fis;
			fis = new FileInputStream(nomFichero);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No existe registros.dat");
			return false;
		}
		
	}
	
	private static void menu() {
		String[] opcionesMenu = {
			"1. Nuevo precio electricidad"
			, "2. Nuevo precio carburante"
			, "3. Nueva sesión de usuario"
			, "4. Nueva consulta"
			// T3 - Añadido para la tarea
			, "5. Consulta usuarios con valoraciones diferentes"
			// T4 - Añadido para la tarea
			, "6. Visualización de precios"
			, "Fin"
		};
		String resp = null;
		Date fechaEnCurso = grupo.getUltimaFecha();
		do {
			resp = (String) JOptionPane.showInputDialog( vent.getJFrame(), "Elige acción a realizar (carácter inicial selecciona):", "Menú de acciones", JOptionPane.QUESTION_MESSAGE, null, opcionesMenu, opcionesMenu[0] );
			if (resp!=null && !resp.isEmpty() && "1234".contains(resp.substring(0,1))) {  // Si es cualquiera de las 4 primeras opciones
				Registro nuevoReg = null;
				if (opcionesMenu[0].equals(resp)) {
					nuevoReg = new PrecioElectricidad( fechaEnCurso, 0 );
				} else if (opcionesMenu[1].equals(resp)) {
					nuevoReg = new PrecioCarburante( fechaEnCurso, "", TipoCarburante.GASOLEO_A, 0 );
				} else if (opcionesMenu[2].equals(resp)) {
					nuevoReg = new SesionUsuario( fechaEnCurso, "", 0 );
				} else if (opcionesMenu[3].equals(resp)) {
					nuevoReg = new Consulta( fechaEnCurso, "", "", 0, 0 );
				}
				boolean lecturaOk = nuevoReg.leerDatosDeTeclado();
				if (lecturaOk) {
					fechaEnCurso = nuevoReg.getFecha();
					grupo.anyadeRegistro( nuevoReg );
					vent.visualizarGraficoFechas();
				}
			// T3 - Añadido para la tarea
			} else if (opcionesMenu[4].equals(resp)) {
				muestraUsuariosConValoracionesDiferentes();
			// T4 - Añadido para la tarea
			} else if (opcionesMenu[5].equals(resp)) {
				vent.sacaEstadisticaDePrecios();
			}
		} while (!"Fin".equals(resp));  // Final de menú
	}

	// T3 - Añadido para la tarea
	private static void muestraUsuariosConValoracionesDiferentes() {
		// T3
		HashSet<Registro> hs = new HashSet<>();
		for(Registro r: grupo.getListaRegistros()) { 
			if(r.typeof(Consulta)) {
				UsuarioValoracion u1 = new UsuarioValoracion(r.getUsuario(), r.getGradoSatisfaccion());
				hs.add(r); // los Hash set solo a�aden si el dato u objeto no existe ya en el
			}
		}
		for(Registro s: hs) {
			System.out.println(s);
		}
	}
	
}
