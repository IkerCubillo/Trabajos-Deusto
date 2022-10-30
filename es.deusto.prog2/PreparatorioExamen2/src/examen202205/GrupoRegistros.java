package examen202205;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import examen202205.datos.Registro;

/** Clase contenedora de registros
 */
public class GrupoRegistros {
	
	protected ArrayList<Registro> listaRegistros;  // Lista de registros
	protected Date ultFecha; // Info de fecha mayor de todos los registros del grupo
	
	/** Crea un nuevo grupo de registros vacío
	 */
	public GrupoRegistros() {
		listaRegistros = new ArrayList<>();
	}
	
	/** Crea un nuevo grupo de registros, cargando sus datos desde un fichero
	 * @param nomFichero	Nombre del fichero del que cargar los datos
	 */
	public GrupoRegistros( String nomFichero ) {
		listaRegistros = new ArrayList<>();
		cargarRegistros(nomFichero);
	}
	
	public void cargarRegistros( String nomFichero ) {
		Scanner lector = new Scanner( GrupoRegistros.class.getResourceAsStream( nomFichero ) );
		int contLineas = 0;
		while (lector.hasNextLine()) {
			contLineas++;
			String linea = lector.nextLine();
			try {
				Registro registro = Registro.crearDeLinea( linea );
				if (registro!=null) {
					anyadeRegistro( registro );
				}
			} catch (Exception e) {
				System.out.println( "Datos de registro se han perdido. Error en línea: " + contLineas + " --> " + linea );
				e.printStackTrace();
			}
		}
		lector.close();
	}

	/** Devuelve el número de registros actualmente en el grupo
	 * @return	Número de registros (0 si no hay ninguno)
	 */
	public int size() {
		return listaRegistros.size();
	}
	
	/** Devuelve la última fecha del grupo
	 * @return	Última fecha-hora cronológica del grupo de registros, null si no hay ningún registro
	 */
	public Date getUltimaFecha() {
		return ultFecha;
	}
	
	/** Añade registro al grupo
	 * @param registro	Nuevo registro a incluir
	 */
	public void anyadeRegistro( Registro registro ) {
		listaRegistros.add( registro );
		if (ultFecha==null || registro.getFecha().compareTo( ultFecha ) > 0) {
			ultFecha = registro.getFecha();
		}
	}
	
	/** Devuelve los registros
	 * @return	Lista de todos los registros, en el orden en el que hayan ido entrando en el grupo
	 */
	public ArrayList<Registro> getListaRegistros() {
		return listaRegistros;
	}

	@Override
	public String toString() {
		return "Grupo de " + listaRegistros.size() + " registros" + (ultFecha==null ? "" : (" con fecha final " + Utils.FORMATEADOR_FECHA_DMA_HM.format(ultFecha)));
	}

}