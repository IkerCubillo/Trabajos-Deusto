package viajes;

import java.util.ArrayList;

public class Excursion implements Cobrable{
	
	private String nombre = "";
	private Guia guia;
	private ArrayList<Trayecto> trayectos = new ArrayList<Trayecto>();
	private boolean pagada = false;
	
	public Excursion(String nombre, ArrayList<Trayecto> trayectos, boolean pagada,Guia guia) {
		this.guia = guia;
		this.nombre = nombre;
		this.trayectos = new ArrayList<Trayecto>(trayectos); // CUIDADO!!!
		this.pagada = pagada;
	}
	
	

	public String getNombre() {
		return nombre;
	}
	public ArrayList<Trayecto> getTrayectos() {
		return trayectos;
	}
	public boolean isPagada() {
		return pagada;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTrayectos(ArrayList<Trayecto> trayectos) {
		this.trayectos = new ArrayList<Trayecto>(trayectos);
	}
	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	

	public double calcularCoste() {
		double total = 0.0;
		for (Trayecto p: trayectos) {
			total += p.getDistancia()*p.getTransporte().getPrecioPorKm();
			}
		total += this.guia.getPrecio()*this.guia.getnPersonas();
		return total;
	}
	
	public boolean cobrar() {
		// TODO Auto-generated method stub
		if (this.pagada == false) {
		this.pagada = true;
		}
		return true;
	}
	public static Excursion getExcursionMasCara(ArrayList<Excursion> aExcursiones) {
		Excursion excursionMasCara= aExcursiones.get(0);
		for(Excursion e: aExcursiones) {
			if(e.calcularCoste() > excursionMasCara.calcularCoste() ) {
				excursionMasCara = e;
			}
		}
		return excursionMasCara;
	}



	@Override
	public String toString() {
		return "Excursion [nombre=" + nombre + ", guia=" + guia + ", trayectos=" + trayectos + ", pagada=" + pagada
				+ "]";
	}
	
}
