package empleados;
import java.io.Serializable;

public class ClassA implements Serializable{
	
	private int A = 0;
	private int B = 0;
	/**
	 * @param a
	 * @param b
	 */
	public ClassA(int a, int b) {
		super();
		A = a;
		B = b;
	}
	/**
	 * @return the a
	 */
	public int getA() {
		return A;
	}
	/**
	 * @param a the a to set
	 */
	public void setA(int a) {
		A = a;
	}
	/**
	 * @return the b
	 */
	public int getB() {
		return B;
	}
	/**
	 * @param b the b to set
	 */
	public void setB(int b) {
		B = b;
	}
	@Override
	public String toString() {
		return "ClassA [A=" + A + ", B=" + B + "]";
	}


	
	

}
