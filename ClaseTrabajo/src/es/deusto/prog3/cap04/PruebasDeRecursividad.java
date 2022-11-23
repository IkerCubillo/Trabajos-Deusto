package es.deusto.prog3.cap04;

public class PruebasDeRecursividad {
	
	private static int numLlamadas;
	
	public static void main(String[] args) {
//		numLlamadas = 0;
//		int varPrueba = 7;
//		// f( varPrueba );
//		conteo( 1 );
		System.out.println(factorial(35));
	}
	
	// n! = 1 * 2 * 3 * 4 * 5 * ... * (n-2) * (n-1) * n
	// si n > 1 --> n! = n * (n-1)! [factorial(n) returns n * factorial(n-1)]
	//	 n == 0 --> n! = 1
	private static long factorial(long n) {		
		if (n == 0) { // Caso base
			return 1;
		} else { // Caso recursivo
			return n * factorial(n - 1 ); 
		}
	}
	
	// Contar (sacar a consola) de i a 4000:
	//    - Caso recursivo:
	//      - sacar a consola i
	//      - Contar de i+1 a 4000
	//    - Caso base: si i==4000
	//      - sacar a consola 4000
	private static void conteo( int i ) {
		if (i==4000) {
			System.out.println( 4000 );
		} else {
			conteo( i+1 );
			System.out.println( i );
		}
	}
	
	private static void f( int param ) {
		param = param + numLlamadas;
		numLlamadas++;
		System.out.println( "soy f en la llamada " + numLlamadas + " cálculo " + param );
		f( param );
	}
}
