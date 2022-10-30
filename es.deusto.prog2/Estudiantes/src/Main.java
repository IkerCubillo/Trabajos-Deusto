
public class Main {
	public static void main(String[] args) {
		// Constructor vacio
		Estudiantes e1 = new Estudiantes();
		e1.setNombre("Bruce");
		System.out.println(e1.getNombre());
		
		//Constructor no vacio
		Estudiantes e2 = new Estudiantes("Bruce","Wayne",0,"48007");
		e2.setNombre("Alfred");
		System.out.println(e2);
		
		int[] notas = new int[10];
		
		// for i in range(10):
		for(int i = 0; i<10 ;i++) {
			notas[i] = 0;
			
		}
		
		notas[2] = 5;
		notas[5] = 8;
		
		for(int i = 0; i < notas.length; i++) {
			System.out.println(notas[i]);
		}
		
		for(int i = notas.length-1; i >= 0; i--) {
			System.out.println(notas[i]);
		}
		
	}
}
