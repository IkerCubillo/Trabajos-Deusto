package flotaTransporte;

public class Taxi extends Transporte {
	
	private int nLicencia = 0;
	
	public Taxi() {
		
	}

	public Taxi(String matricula, int añoCompra, int cv, String modelo, int nLicencia) {
		super(matricula, añoCompra, cv, modelo);
		this.nLicencia = nLicencia;
	}
	
	public int getNLicencia() {
		return this.nLicencia;
	}
}
