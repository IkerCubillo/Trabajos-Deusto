package deustoTrain;

public class Trayecto {
	private Estacion estacionOrigen;
	private Estacion estacionDestino;
	private double kmRecorridos = 0.0;
	
	public Trayecto(Estacion estacionOrigen, Estacion estacionDestino, double kmRecorridos) {
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
		this.kmRecorridos = kmRecorridos;
	}

	public Estacion getEstacionOrigen() {
		return estacionOrigen;
	}
	public Estacion getEstacionDestino() {
		return estacionDestino;
	}
	public double getKmRecorridos() {
		return kmRecorridos;
	}

	public void setEstacionOrigen(Estacion estacionOrigen) {
		this.estacionOrigen = estacionOrigen;
	}
	public void setEstacionDestino(Estacion estacionDestino) {
		this.estacionDestino = estacionDestino;
	}
	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	
	
	
	
	
}
