

public class Lanzallamas {
	
	//Propiedades
	private String usuario = "";
	private String color = "";
	private int nserie = 0;
	
	//Constructores
	public Lanzallamas(String usuario, String color, int nserie) {
		this.usuario = usuario;
		this.color = color;
		this.nserie = nserie;
	}
	
	//Getters
	public String getUsuario() {
		return this.usuario;
	}
	public String getColor() {
		return this.color;
	}
	public int nserie() {
		return this.nserie;
	}
	
	//Setters
	public void setUsuario() {
		this.usuario = usuario;
	}
	public void setColor() {
		this.color = color;
	}
	public void setNserie() {
		this.nserie = nserie;
	}
}