package examen202205;

public class UsuarioValoracion {
	private String nombreYValoracion;

	public UsuarioValoracion(String nombre, int valoracion) {
		super();
		this.nombreYValoracion = nombre + valoracion;
	}

	public String getNombreYValoracion() {
		return nombreYValoracion;
	}

	public void setNombreYValoracion(String nombreYValoracion) {
		this.nombreYValoracion = nombreYValoracion;
	}
	
	

}
