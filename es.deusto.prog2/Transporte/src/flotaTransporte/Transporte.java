package flotaTransporte;

public class Transporte {
	private String matricula = "";
	private int a�oCompra = 0;
	private int cv = 0;
	private String modelo = "";
	
	public Transporte() {
	}
	
	public Transporte(String matricula, int a�oCompra, int cv, String modelo) {
		this.matricula = matricula;
		this.a�oCompra = a�oCompra;
		this.cv = cv;
		this.modelo = modelo;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public int getA�oCompra() {
		return this.a�oCompra;
	}

	public int getCv() {
		return this.cv;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Transporte [matricula=" + matricula + ", a�oCompra=" + a�oCompra + ", cv=" + cv + ", modelo=" + modelo
				+ "]";
	}
	
	
}