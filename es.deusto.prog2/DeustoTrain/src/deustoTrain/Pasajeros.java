package deustoTrain;

import java.util.ArrayList;

public class Pasajeros extends Rutas implements Reservable {
	private int vagonesP = 0;
	private int vagonesS = 0;
	private int cocheCama = 0;
	private ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();

	public Pasajeros(Tren tren, ArrayList<Trayecto> trayectos, int vagonesP, int vagonesS, int cocheCama,
			ArrayList<Pasajero> pasajeros) {
		super(tren, trayectos);
		this.vagonesP = vagonesP;
		this.vagonesS = vagonesS;
		this.cocheCama = cocheCama;
		this.pasajeros = new ArrayList<Pasajero>(pasajeros);
	}
	
	public int getVagonesP() {
		return vagonesP;
	}
	public int getVagonesS() {
		return vagonesS;
	}
	public int getCocheCama() {
		return cocheCama;
	}
	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setVagonesP(int vagonesP) {
		this.vagonesP = vagonesP;
	}
	public void setVagonesS(int vagonesS) {
		this.vagonesS = vagonesS;
	}
	public void setCocheCama(int cocheCama) {
		this.cocheCama = cocheCama;
	}
	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = new ArrayList<Pasajero>(pasajeros);
	}
	
	public double getBeneficioPorKm(){
		return ((vagonesP+vagonesS+cocheCama)*50);
	}

	@Override
	public boolean reservar(Pasajero p) {
		if(pasajeros.add(p)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean anular(Pasajero p) {
		if(pasajeros.remove(p)) {
			return true;
		}
		return false;
	}

}
