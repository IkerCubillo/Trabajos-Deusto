package viajes;

import transporte.Transporte;

public class Trayecto {
	private double latitudOrigen = 0.0;
	private double longitudOrigen = 0.0;
	private double latitudDestino = 0.0;
	private double longitudDestino = 0.0;
	private double distancia = 0.0;
	private Transporte transporte;
	
	public Trayecto(double latitudOrigen, double longitudOrigen, double latitudDestino, double longitudDestino,
			double distancia, Transporte transporte) {
		if (esLatitudCorrecta(latitudOrigen)) { 								// Forma comprobacion 1
			this.latitudOrigen = latitudOrigen;
		}
		if (esLongitudCorrecta(longitudOrigen)) {
		this.longitudOrigen = longitudOrigen;
		}
		if (esLatitudCorrecta(latitudDestino)) {
			this.latitudDestino = latitudDestino;
		}
		if (esLongitudCorrecta(longitudDestino)) {
		this.longitudDestino = longitudDestino;
		}
		this.distancia = distancia;
		this.transporte = transporte;
	}
	
	private boolean esLatitudCorrecta(double latitud) {
		if(latitud >= -90 && latitud <= 90) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean esLongitudCorrecta(double longitud) {
		if(longitud >= -180 && longitud <= 180) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double getLatitudOrigen() {
		return latitudOrigen;
	}
	public double getLongitudOrigen() {
		return longitudOrigen;
	}
	public double getLatitudDestino() {
		return latitudDestino;
	}
	public double getLongitudDestino() {
		return longitudDestino;
	}
	public double getDistancia() {
		return distancia;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	
	public void setLatitudOrigen(double latitudOrigen) {
		if (esLatitudCorrecta(latitudOrigen)) {									// Forma comprobacion 2
			this.latitudOrigen = latitudOrigen;
		}
	}
	public void setLongitudOrigen(double longitudOrigen) {
		this.longitudOrigen = longitudOrigen;
	}
	public void setLatitudDestino(double latitudDestino) {
		this.latitudDestino = latitudDestino;
	}
	public void setLongitudDestino(double longitudDestino) {
		this.longitudDestino = longitudDestino;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}	
}
