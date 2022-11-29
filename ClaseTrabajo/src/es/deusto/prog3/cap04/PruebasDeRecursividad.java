package es.deusto.prog3.cap04;

public class PruebasDeRecursividad {
	
	private static long numLlamadas;
	
	public static void main(String[] args) {
		numLlamadas = 0;
		// int varPrueba = 7;
		// f( varPrueba );
		// conteo( 1 );
		// System.out.println( factorial( 16 ) );
		// System.out.println( fib(45) );
		// System.out.println( numLlamadas );
		combinacionesAyB( "", 5 );
	}
	
	
	
	// Generar combinaciones de 5 letras de A y B:
	// Caso recursivo:
	//   Empezando en A concatenarla a la generación de combinaciones de 4 letras de A y B
	//   Empezando en B    "  "  " " " " " " 
	// Caso base: si longCombAConseguir es 0 --> sacar a consola la combinación actual
	private static void combinacionesAyB( String combEnCurso, int longCombAConseguir ) {
		if (longCombAConseguir==1) {
			System.out.println( combEnCurso + "A" );
			System.out.println( combEnCurso + "B" );
		} else {
			combinacionesAyB( combEnCurso + "A", longCombAConseguir-1 );
			combinacionesAyB( combEnCurso + "B", longCombAConseguir-1 );
		}
	}
	
	// 1,1,2,3,5,8,13,21...
	// si n > 1, fib (n) = fib(n-1) + fib(n-2)
	// si n = 1, fib(1) = 1
	public static long fib( int n ) {
		numLlamadas++;
		if (n==1) {
			return 1;
		} else if (n==2) {
			return 1;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	
	
	// n! = 1 * 2 * 3 * 4 * ... * (n-2) * (n-1) * n
	// si n > 1 --> n! = n * (n-1)!     [factorial(n) returns n * factorial(n-1)]
	//    n == 0 --> n! = 1
	/** Calcula el factorial de un número
	 * @param n	Número del que calcular el factorial, debe ser mayor o igual a cero
	 * @return	Factorial matemático de n
	 */
	public static long factorial( int n ) {
		if (n==0) {  // Caso base
			return 1;
		} else {  // Caso recursivo
			return n * factorial( n-1 );
		}
	} 

	
	
	
	// Contar (sacar a consola) de i a 4000:
	//    - Caso recursivo:
	//      - sacar a consola i
	//      - Contar de i+1 a 4000
	//    - Caso base: si i==4000
	//      - sacar a consola 4000
	private static void conteo( int i ) {
		if (i==5) {
			System.out.println( i );
		} else {
			System.out.println( i );
			conteo( i+1 );
			System.out.println( i );
		}
	}
	
	@SuppressWarnings("unused")
	private static void f( long param ) {
		param = param + numLlamadas;
		numLlamadas++;
		System.out.println( "soy f en la llamada " + numLlamadas + " cálculo " + param );
		f( param );
	}
}
