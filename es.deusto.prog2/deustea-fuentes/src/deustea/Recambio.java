package deustea;

public class Recambio extends Producto implements Pagable{
	
	protected Mueble productoRecambio;
	protected int nUnidades;
	
	public Recambio() {
		super();
		this.productoRecambio.categoria = Categoria.COCINA;
		this.productoRecambio.setPrecio(0);
		this.nUnidades = 0;
		
	}
	public Recambio(int id, String nombre, Mueble productoRecambio, int nUnidades) {
		super(id, nombre);
		this.productoRecambio = productoRecambio;
		this.nUnidades = nUnidades;
	}
	
	@Override
	public double getPrecio() {
		// TODO Auto-generated method stub
		return (productoRecambio.getPrecio() * 0.1) ;
	}
	
	@Override
	public String toString() {
		return "Recambio del mueble " + productoRecambio.getNombre() + ", " + nUnidades + " unidades";
	}

	
}
