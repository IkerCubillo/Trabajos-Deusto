package es.deusto.prog3.cap04.entregas;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(-5));
		System.out.println(factorial(0));
		System.out.println(factorial(1));
		System.out.println(factorial(5));
		System.out.println(factorial(10));
	}
	
	/**
	 * Returns the factorial of the number inserted
	 * @param number. It must be an integer and positive number. Else it will return -1
	 * @return It returns the factorial of the number inserted
	 */
	private static int factorial( int number ) {
		if (number < 0) { // Detect number is negative
			System.out.println(number + " is negative, so we can't calculate its factorial.");
			return -1; // If negative, stop and return -1
		}
		
		if (number == 0) { 
			return 1; // If number equals 0, stop recursion
		} else {
			return number * factorial(number - 1 ); 
		} // Else, return number * factorial of the number before it
	}
}
