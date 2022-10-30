package deustoTrain;

import java.util.ArrayList;

public class Estacion implements Reservable {
	private String nombre = "";
	private double latitud = 0;
	private double longitud = 0;
	private boolean cafeteria = false;
	private ArrayList<Pasajero> reservados = new ArrayList<Pasajero>();
	
	public Estacion(String nombre, double latitud, double longitud, boolean cafeteria) {
		super();
		this.nombre = nombre;
		if (esLatitudCorrecta(latitud)){
			this.latitud = latitud;
		}
		if (esLongitudCorrecta(latitud)){
			this.longitud = longitud;
		}
		
		this.cafeteria = cafeteria;
	}
	
	public String getNombre() {
		return nombre;
	}
	public double getLatitud() {
		return latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public boolean isCafeteria() {
		return cafeteria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCafeteria(boolean cafeteria) {
		this.cafeteria = cafeteria;
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

	@Override
	public boolean reservar(Pasajero p) {
		if(reservados.add(p) && cafeteria == true) {
				return true;
			}
		else
			return false;
		}

	@Override
	public boolean anular(Pasajero p) {
		if(reservados.remove(p) && cafeteria == true) {
			return true;
		}
		else
		return false;
	}
}
