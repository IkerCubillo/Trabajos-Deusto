package transporte;

public class Avioneta extends Transporte {
	private double peso = 0.0;
	private double coePlaneo = 0.0;
	
	public Avioneta(int nPersonas, double peso, double coePlaneo) {
		super(nPersonas);
		this.peso = peso;
		this.coePlaneo = coePlaneo;
		// TODO Auto-generated constructor stub
	}
	
	public double getPeso() {
		return peso;
	}
	public double getCoePlaneo() {
		return coePlaneo;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setCoePlaneo(double coePlaneo) {
		this.coePlaneo = coePlaneo;
	}


	@Override
	public double getPrecioPorKm() {
		// TODO Auto-generated method stub
		return (peso/coePlaneo);
	}
}