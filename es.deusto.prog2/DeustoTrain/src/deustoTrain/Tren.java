package deustoTrain;

public class Tren {
	private static int contador = 0001;
	private int cv = 0;
	private String modelo = "";
	private int codigo = 0000;
	
	public Tren(int cv, String modelo) {
		this.cv = cv;
		this.modelo = modelo;
		this.codigo = contador;
		Tren.contador++;
	}

	public int getCv() {
		return cv;
	}
	public String getModelo() {
		return modelo;
	}
	public int getCodigo() {
		return codigo;
	}
	
	public void setCv(int cv) {
		this.cv = cv;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Tren [cv=" + cv + ", modelo=" + modelo + ", codigo=" + codigo + "]";
	}
	
}
