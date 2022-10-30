package internet;

import java.util.ArrayList;

public class TrackerTexto extends Tracker {
	//PROPIEDADES
	private int numClicks = 0;
	private int distanciaRecorrida = 0;

	// CONSTRUCTORES
	public TrackerTexto() {
	}

	public TrackerTexto(String nombre, ArrayList<Web> webs,int numClicks, int distanciaRecorrida) {
		super(nombre, webs);
		if(numClicks > 0 && numClicks <= 25) {
			this.numClicks = numClicks;
			}
			if(distanciaRecorrida > 0) {
			this.distanciaRecorrida = distanciaRecorrida;
			}
	}



	// GETTERS Y SETTERS
	public int getNumClicks() {
		return numClicks;
	}
	public int getDistanciaRecorrida() {
		return distanciaRecorrida;
	}

	// METODOS
	@Override
	public double getPuntuacionTotal() {  
		return (getNumClicks()*0.8 + getDistanciaRecorrida()*0.2);
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "TrackerTexto [numClicks=" + numClicks + ", distanciaRecorrida=" + distanciaRecorrida + ", toString()="
				+ super.toString() + "]";
	}	
}
