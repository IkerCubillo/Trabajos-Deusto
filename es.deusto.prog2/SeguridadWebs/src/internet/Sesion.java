package internet;

import java.util.ArrayList;

public class Sesion implements Imprimible{
	private int fechaInicio = 20220323;
	private int fechaFin = 20220323;
	private int horaInicio = 0000;
	private int horaFin = 0000;
	private String nick = "Anonimo";
	private ArrayList<Tracker> trackers = new ArrayList<Tracker>(); 
	
	public Sesion() {
	}

	public Sesion(int fechaInicio, int fechaFin, int horaInicio, int horaFin, String nick, ArrayList<Tracker> trackers) {
		this.fechaInicio = fechaInicio;
		if(fechaInicio <= fechaFin) {
			this.fechaFin = fechaFin;
		}
		this.fechaFin = fechaFin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.nick = nick;
		this.trackers = new ArrayList<Tracker>(trackers);
	}

	public int getFechaInicio() {
		return fechaInicio;
	}
	public int getFechaFin() {
		return fechaFin;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public int getHoraFin() {
		return horaFin;
	}
	public String getNick() {
		return nick;
	}
	public ArrayList<Tracker> getTrackers() {
		return trackers;
	}
	
	
	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String imprimir() {
		int numWebsVisitadas = 0;
		for(Tracker t: trackers) {
			numWebsVisitadas++;
		}
		return (""+numWebsVisitadas);
	}
	
	public double calcularPuntuacionTotal() {
		double puntuacionTotal = 0;
		for(Tracker t: trackers) {
			puntuacionTotal+=t.getPuntuacionTotal();
		}
		return puntuacionTotal;
	}

	@Override
	public String toString() {
		return "Sesion [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", horaInicio=" + horaInicio
				+ ", horaFin=" + horaFin + ", nick=" + nick + ", trackers=" + trackers + "]";
	}
}
