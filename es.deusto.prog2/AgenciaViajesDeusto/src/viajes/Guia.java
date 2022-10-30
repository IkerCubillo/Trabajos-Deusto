package viajes;

public class Guia implements Cobrable{
	
	private String nombre = "";
	private double precio = 0.0;
	private int nPersonas = 0;
	private boolean pagada = false;
	
	public Guia(String nombre, double precio, int nPersonas, boolean pagada) {
		this.nombre = nombre;
		setPrecio(precio);
		setNPersonas(nPersonas);
		this.pagada = pagada;
	}

	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public int getnPersonas() {
		return nPersonas;
	}
	public boolean isPagada() {
		return pagada;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		if(precio >= 0) {
			this.precio = precio;
		}
	}
	public void setNPersonas(int nPersonas) {
		if (nPersonas >= 0){
		this.nPersonas = nPersonas;
		}
	}

	@Override
	public double calcularCoste() {
		// TODO Auto-generated method stub
		return (this.precio * this.nPersonas);
	}

	@Override
	public boolean cobrar() {
		// TODO Auto-generated method stub
		if (this.pagada == false) {
		this.pagada = true;
		}
		return true;
	}
	
	
	
}
