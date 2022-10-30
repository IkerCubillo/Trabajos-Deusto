package transporte;

public class Barco extends Transporte {
	private double calado = 0.0;
	private boolean esDiesel = true;
	
	

	public Barco(int nPersonas, double calado, boolean esDiesel) {
		super(nPersonas);
		// TODO Auto-generated constructor stub
		this.calado = calado;
		this.esDiesel = esDiesel;
	}
	
	public double getCalado() {
		return calado;
	}
	public boolean isEsDiesel() {
		return esDiesel;
	}
	public void setCalado(double calado) {
		this.calado = calado;
	}
	public void setEsDiesel(boolean esDiesel) {
		this.esDiesel = esDiesel;
	}

	@Override
	public double getPrecioPorKm() {
		// TODO Auto-generated method stub
		if(isEsDiesel()) {
			return (calado*0.8);
		}
		else {
			return (calado*1.5);
		}
	}
}