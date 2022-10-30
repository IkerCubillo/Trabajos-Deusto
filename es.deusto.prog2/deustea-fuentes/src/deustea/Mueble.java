package deustea;

import java.io.Serializable;

public class Mueble extends Producto implements Pagable, Serializable {
	protected Categoria categoria;
	protected double precio;
	
	/** Constructor con argumentos
	 * @param id identificativo único
	 * @param nombre del producto 
	 * @param categoria del mueble
	 * @param precio del mueble
	 */
	public Mueble(int id, String nombre, Categoria categoria, double precio) {
		super(id, nombre);
		this.categoria = categoria;
		this.setPrecio(precio);
	}
	
	/** Constructor por defecto, crea un mueble con id -1, "Sin nombre" de categoría COCINA y precio 0 
	 */
	public Mueble() {
		super();
		this.categoria = Categoria.COCINA;
		this.setPrecio(0);
	}

	/**
	 * @return categoria del mueble
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria del mueble
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return precio del mueble
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio del mueble
	 */
	public void setPrecio(double precio) {
		if (precio >= 0) {
			this.precio = precio;
		}
	}

	/** Convierte un Mueble a String
	 */
	@Override
	public String toString() {
		return nombre + "(" + categoria + "), " + precio + " eur";
	}
	
	
}
