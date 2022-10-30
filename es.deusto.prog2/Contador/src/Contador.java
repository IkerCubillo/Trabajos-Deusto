
public class Contador {
	
	// Propiedades
	
	int[] array = new int[0];	
	
	// Constructores
	public Contador(int tam) {
		array = new int[tam];
	}
	
	// Métodos

	public void incrementarContador() {
		for(int i = 0; i <= array.length; i++) {
			if(array[i] == 9) {
				array[i] = 0;
				array[i+1] = 1;
			}
		}
	}
}