package deustoTrain;

import java.util.ArrayList;

public abstract class Rutas {
	private Tren tren;
	private ArrayList<Trayecto> trayectos =  new ArrayList<Trayecto>();

	public Rutas(Tren tren, ArrayList<Trayecto> trayectos) {
		this.tren = tren;
		this.trayectos = new ArrayList<Trayecto>(trayectos);
	}
	
	public Tren getTren() {
		return tren;
	}
	public ArrayList<Trayecto> getTrayectos() {
		return trayectos;
	}
	
	public void setTren(Tren tren) {
		this.tren = tren;
	}
	public void setTrayectos(ArrayList<Trayecto> trayectos) {
		this.trayectos = new ArrayList<Trayecto>(trayectos);
	}
	
	abstract double getBeneficioPorKm();
	
	public static Rutas getRutaMasCara(ArrayList<Rutas> aRutas) {
		Rutas rutaMasCara= aRutas.get(0);
		for(Rutas e: aRutas) {
			if(e.getBeneficioPorKm() > rutaMasCara.getBeneficioPorKm() ) {
				rutaMasCara = e;
			}
		}
		return rutaMasCara;
	}
}
