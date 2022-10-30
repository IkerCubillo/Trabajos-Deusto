package carreraCoches;

public class Main {
	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) {
			Coche c = new Coche("Coche" + i);
			c.start();
		}
	}
}
