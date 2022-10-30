package internet;

public class Web implements Imprimible {
	// PROPIEDADES
	private static int codigoDisponible = 1;
	
	private String dominio = "deusto";
	private String dominioSuperior = "es";
	private int fecha = 20220323;
	private int identificador = 0;
	private TipoWebs tipoWeb = TipoWebs.texto;
	
	// CONSTRUCTORES
	public Web() {
	}
	
	public Web(String dominio, String dominioSuperior, int fecha, TipoWebs tipoWeb) {
		this.dominio = dominio;
		this.dominioSuperior = dominioSuperior;
		this.fecha = fecha;
		this.identificador = codigoDisponible;
		Web.codigoDisponible++;
		this.tipoWeb = tipoWeb;
	}

	// GETTERS Y SETTERS
	public String getDominio() {
		return dominio;
	}
	public String getDominioSuperior() {
		return dominioSuperior;
	}
	public int getFecha() {
		return fecha;
	}
	public int getIdentificador() {
		return identificador;
	}
	public TipoWebs getTipoWeb() {
		return tipoWeb;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public void setDominioSuperior(String dominioSuperior) {
		this.dominioSuperior = dominioSuperior;
	}
	public void setTipoWeb(TipoWebs tipoWeb) {
		this.tipoWeb = tipoWeb;
	}

	// METODOS
	public String imprimir() {
		return (getURL() + " " + getFecha());
	}
	
	public String getURL(){
		return ("https//www." + dominio + "."+dominioSuperior);
		
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "Web [dominio=" + dominio + ", dominioSuperior=" + dominioSuperior + ", fecha=" + fecha
			+ ", identificador=" + identificador + ", tipoWeb=" + tipoWeb + "]";
	}	
}
