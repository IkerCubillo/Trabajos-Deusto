package flotaTransporte;

public class Transporte {
	private String matricula = "";
	private int aņoCompra = 0;
	private int cv = 0;
	private String modelo = "";
	
	public Transporte() {
	}
	
	public Transporte(String matricula, int aņoCompra, int cv, String modelo) {
		this.matricula = matricula;
		this.aņoCompra = aņoCompra;
		this.cv = cv;
		this.modelo = modelo;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public int getAņoCompra() {
		return this.aņoCompra;
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
		return "Transporte [matricula=" + matricula + ", aņoCompra=" + aņoCompra + ", cv=" + cv + ", modelo=" + modelo
				+ "]";
	}
	
	
}
