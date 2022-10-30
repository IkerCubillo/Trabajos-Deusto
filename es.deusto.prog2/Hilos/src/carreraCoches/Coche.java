package carreraCoches;

public class Coche extends Thread {	
	private String nombre;
	private final int NUMERO_VUELTAS = 10;
	
	public Coche(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < NUMERO_VUELTAS; i++) {
			System.out.println("Vuelta numero " + i + "de " + nombre);
		}
		System.out.println(nombre + " ha terminado la carrera");
	}
}