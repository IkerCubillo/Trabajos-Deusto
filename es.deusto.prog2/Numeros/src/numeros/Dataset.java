package numeros;

public class Dataset implements Local, BD {
	private String nombre;
	private String propietario;
	private String datos;
	
	public Dataset(String nombre, String propietario, String datos) {
		this.nombre = nombre;
		this.propietario = propietario;
		this.datos = datos;
	}

	public String getNombre() {
		return nombre;
	}
	public String getPropietario() {
		return propietario;
	}
	public String getDatos() {
		return datos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public void setDatos(String datos) {
		this.datos = datos;
	}

	@Override
	public void guardarFichero() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leerFichero() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarBD() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leerBD() {
		// TODO Auto-generated method stub
		
	}
	
	
}
