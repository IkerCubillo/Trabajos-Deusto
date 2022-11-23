package es.deusto.prog3.cap04.entregas;

public class DoblecesPapel {

	public static void main(String[] args) {
		System.out.println(doblecesPapel(384400000, 0.0001, 0));
	}

	private static double doblecesPapel(long i, double d, int n) {
		if(i < d) {
			return n;
		} else {
			System.out.println(i + " " + d);
			return doblecesPapel(i, d*2, n + 1);
		}
	}
}