package deustoTrain;

import java.util.ArrayList;

public class Mercancias extends Rutas {
	private double cargaMaxima = 0;

	public Mercancias(Tren tren, ArrayList<Trayecto> trayectos, double cargaMaxima) {
		super(tren, trayectos);
		this.cargaMaxima = cargaMaxima;
	}
	
	public double getCargaMaxima() {
		return cargaMaxima;
	}
	public void setCargaMaxima(double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}
	
	public double getBeneficioPorKm(){
		return (cargaMaxima/getTren().getCv());
	}
}
