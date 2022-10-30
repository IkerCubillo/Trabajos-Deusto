package flotaTransporte;

public class Autobus extends Transporte {
	
	private int plazas = 0;
	
	public Autobus() {
		
	}
	
	public Autobus(String matricula, int a�oCompra, int cv, String modelo, int plazas) {
		super(matricula, a�oCompra, cv, modelo);
		this.plazas = plazas;
	}
	
	public int getPlazas() {
		return this.plazas;
	}

}
