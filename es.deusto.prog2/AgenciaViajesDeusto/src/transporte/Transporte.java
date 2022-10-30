package transporte;

public abstract class Transporte {
	public static int contador = 1;
	
	private int nPersonas = 0;
	private int codigo = 0000;
	
	public Transporte(int nPersonas) {
		this.nPersonas = nPersonas;
		this.codigo = contador;
		Transporte.contador++;
	}

	public int getnPersonas() {
		return nPersonas;
	}
	public int getCodigo() {
		return codigo;
	}

	public void setnPersonas(int nPersonas) {
		this.nPersonas = nPersonas;
	}

	public abstract double getPrecioPorKm();
}
