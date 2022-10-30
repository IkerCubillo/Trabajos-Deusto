package excepciones;

public class SalarioNegativoException extends Exception {
		private int dinero;
		public SalarioNegativoException(int dinero) {
			this.dinero = dinero;
		}
		public int getDinero() {
			return dinero;
		}
		public String toString() {
			return "Error: '" + dinero +"' its negative.";
		}
}
