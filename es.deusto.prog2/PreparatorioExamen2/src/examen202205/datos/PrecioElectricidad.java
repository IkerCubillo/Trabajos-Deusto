package examen202205.datos;

import java.util.Date;
import examen202205.Utils;
import examen202205.gui.VentanaVisualizacionRegistros;

/** Registro de precio de electricidad
 */
public class PrecioElectricidad extends Registro implements ConPrecio {

	/** Crea una nuevo precio de electricidad partiendo de una línea de texto con todos los datos en orden, separados por tabulador
	 * Ejemplo de línea: "PrecioElectricidad	18/03/2022 16:00	0.310"
	 * @param linea	Línea de texto de la que extraer los datos
	 * @return	nuevo objeto con esos datos, null si hay algún error
	 * @throws Exception	Si hay cualquier error de datos o formato en la línea recibida
	 */
	public static PrecioElectricidad crearDeLinea( String linea ) throws Exception {
		if (!linea.startsWith("PrecioElectricidad\t")) {
			return null;
		}
		String[] partes = linea.split( "\t" );
		Date fecha =  Utils.getFechaFromString( partes[1] );
		double precio = Double.parseDouble( partes[2] );
		PrecioElectricidad nueva = new PrecioElectricidad( fecha, precio );
		return nueva;
	}
	
	protected double precioKwH;
	public PrecioElectricidad(Date fecha, double precioKwH) {
		super(fecha);
		this.precioKwH = precioKwH;
	}
	public double getPrecioKwH() {
		return precioKwH;
	}
	public void setPrecioKwH(double precioKwH) {
		this.precioKwH = precioKwH;
	}
	
	@Override
	public String toString() {
		return "{" + super.toString() + " " + precioKwH + "/KwH}";
	}

	@Override
	public double getPrecio() {
		return precioKwH;
	}

	@Override
	public boolean estaPrecioEnRango(double precioInferior, double precioSuperior) {
		return (precioKwH>=precioInferior && precioKwH<=precioSuperior);
	}

	@Override
	public void dibuja( VentanaVisualizacionRegistros ventana, double x, double y ) {
		double zoom = Utils.proyectar( precioKwH, 0.1, 0.5, 0.05, 0.15, true );  // Convierte el valor (0.1 a 0.5 euros/Kwh) en un rango de zoom de la imagen del 5% al 15%
		ventana.dibujaImagen( "../gui/img/elec.png", x, y, zoom, 0, 1.0f );
	}

	@Override
	public boolean leerDatosDeTeclado() {
		boolean ret = super.leerDatosDeTeclado();  // Lee la fecha (padre)
		if (ret) { // Leer el resto de datos
			double nuevoPrecio = Utils.leerDouble( "Introduce precio Kw/h:", precioKwH, true );
			if (nuevoPrecio == Double.MAX_VALUE) {  // Se ha escapado sin meter valor correcto
				return false;
			}
			precioKwH = nuevoPrecio;
			return true;
		} else {
			return false;
		}		
	}
	
}
