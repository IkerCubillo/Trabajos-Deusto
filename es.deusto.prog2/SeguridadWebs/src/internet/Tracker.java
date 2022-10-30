package internet;

import java.util.ArrayList;

public abstract class Tracker {
	//PROPIEDADES
	private String nombre = "";
	private ArrayList<Web> webs = new ArrayList<Web>();
	
	// CONSTRUCTORES
	public Tracker() {
	}

	public Tracker(String nombre, ArrayList<Web> webs) {
		this.nombre = nombre;
		this.webs = new ArrayList<Web>(webs);
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Web> getWebs() {
		return webs;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setWebs(ArrayList<Web> webs) {
		this.webs = new ArrayList<Web>(webs);
	}
	// METODOS
	
	public abstract double getPuntuacionTotal();
	
	// TO STRING
	@Override
	public String toString() {
		return "Tracker [nombre=" + nombre + ", webs=" + webs + "]";
	}
}
