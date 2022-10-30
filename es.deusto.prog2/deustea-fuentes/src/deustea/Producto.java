package deustea;

public abstract class Producto {
	protected int id;
	protected String nombre;
	
	/**Constructor con argumentos
	 * 
	 * @param id identificativo único
	 * @param nombre del producto 
	 */
	public Producto(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	/**Constructor por defecto, crea un producto con id -1 y "Sin nombre" 
	 */
	public Producto() {
		super();
		this.id = -1;
		this.nombre = "Sin nombre";
	}

	/**
	 * @return id identificativo único
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id identificativo único
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return nombre del producto 
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre del producto 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** Convierte un Producto a String 
	 */
	@Override
	public String toString() {
		return "Producto " + nombre + " (id: " + id+ ")";
	}
	
}
