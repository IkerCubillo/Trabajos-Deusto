package internet;

import java.util.ArrayList;

public class TrackerVideo extends Tracker {
	//PROPIEDADES
	private int numMinutos = 0;
	private int vecesAdelanta = 0;
	private int vecesPausa = 0;
	
	// CONSTRUCTORES
	public TrackerVideo() {
	}
	
	public TrackerVideo(String nombre, ArrayList<Web> webs,int numMinutos, int vecesAdelanta, int vecesPausa) {
		super(nombre, webs);
		if(numMinutos > 0) {
			this.numMinutos = numMinutos;
			}
			if(vecesAdelanta > 0) {
			this.vecesAdelanta = vecesAdelanta;
			}
			if(vecesPausa > 0) {
			this.vecesPausa = vecesPausa;
			}
	}

	// GETTERS Y SETTERS
	public int getNumMinutos() {
		return numMinutos;
	}
	public int getVecesAdelanta() {
		return vecesAdelanta;
	}
	public int getVecesPausa() {
		return vecesPausa;
	}
	
	
	// METODOS
	@Override
	public double getPuntuacionTotal() {
		return (getNumMinutos()*0.4+getVecesPausa()*0.2+getVecesAdelanta()*0.4);
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "TrackerVideo [numMinutos=" + numMinutos + ", vecesAdelanta=" + vecesAdelanta + ", vecesPausa="
				+ vecesPausa + ", toString()=" + super.toString() + "]";
	}
}
