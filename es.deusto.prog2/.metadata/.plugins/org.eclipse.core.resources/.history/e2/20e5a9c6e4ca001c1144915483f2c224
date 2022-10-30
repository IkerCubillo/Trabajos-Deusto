package examen202205.datos;

import java.util.Date;
import examen202205.Utils;
import examen202205.gui.VentanaVisualizacionRegistros;

/** Registro de precio de carburante
 */
public class PrecioCarburante extends Registro implements ConPrecio 
{
	
	/** Crea un nuevo precio de carburante partiendo de una línea de texto con todos los datos en orden, separados por tabulador
	 * Ejemplo de línea: "PrecioCarburante	18/03/2022 12:00	Repsol	GASOLEO_A	1.733"
	 * @param linea	Línea de texto de la que extraer los datos
	 * @return	nuevo objeto con esos datos, null si hay algún error
	 * @throws Exception	Si hay cualquier error de datos o formato en la línea recibida
	 */
	public static PrecioCarburante crearDeLinea( String linea ) throws Exception {
		if (!linea.startsWith("PrecioCarburante\t")) {
			return null;
		}
		String[] partes = linea.split( "\t" );
		Date fecha =  Utils.getFechaFromString( partes[1] );
		TipoCarburante tipo = TipoCarburante.valueOf( partes[3] );
		double precio = Double.parseDouble( partes[4] );
		PrecioCarburante nueva = new PrecioCarburante( fecha, partes[2], tipo, precio );
		return nueva;
	}
	
	protected String companyia;
	protected TipoCarburante tipo; 
	protected double precioPorLitro;
	public PrecioCarburante(Date fecha, String companyia, TipoCarburante tipo, double precioPorLitro) {
		super(fecha);
		this.companyia = companyia;
		this.tipo = tipo;
		this.precioPorLitro = precioPorLitro;
	}
	public String getCompanyia() {
		return companyia;
	}
	public void setCompanyia(String companyia) {
		this.companyia = companyia;
	}
	public TipoCarburante getTipo() {
		return tipo;
	}
	public void setTipo(TipoCarburante tipo) {
		this.tipo = tipo;
	}
	public double getPrecioPorLitro() {
		return precioPorLitro;
	}
	public void setPrecioPorLitro(double precioPorLitro) {
		this.precioPorLitro = precioPorLitro;
	}

	@Override
	public String toString() {
		return "{" + super.toString() + " " + tipo + " en " + companyia + " - " + precioPorLitro + "/litro}";
	}
	@Override
	public double getPrecio() {
		return precioPorLitro;
	}
	
	@Override
	public boolean estaPrecioEnRango(double precioInferior, double precioSuperior) {
		return (getPrecio()>=precioInferior && getPrecio()<=precioSuperior);
	}
	
	@Override
	public void dibuja( VentanaVisualizacionRegistros ventana, double x, double y ) {
		double zoom = Utils.proyectar( precioPorLitro, 1.5, 1.9, 0.05, 0.15, true );  // Convierte el valor (1.5 a 1.9 euros/litro) en un rango de zoom de la imagen del 5% al 15%
		ventana.dibujaImagen( "../gui/img/carb.png", x, y, zoom, 0, 1.0f );
	}

	@Override
	public boolean leerDatosDeTeclado() {
		boolean ret = super.leerDatosDeTeclado();  // Lee la fecha (padre)
		if (ret) { // Leer el resto de datos
			String companyia = Utils.leerString( "Introduce nombre de compañía:", this.companyia );
			if (companyia==null) {
				return false;
			}
			String tipoCarb = Utils.leerStringOpciones( "Selecciona tipo de carburante:", tipo.toString(), TipoCarburante.values() );
			if (tipoCarb == null) {
				return false;
			}
			double nuevoPrecio = Utils.leerDouble( "Introduce precio por litro:", precioPorLitro, true );
			if (nuevoPrecio == Double.MAX_VALUE) {
				return false;
			}
			try {
				this.tipo = TipoCarburante.valueOf( tipoCarb );
			} catch (Exception e) {
				return false;
			}
			this.companyia = companyia;
			this.precioPorLitro = nuevoPrecio;
			return true;
		} else {
			return false;
		}		
	}
	
}
