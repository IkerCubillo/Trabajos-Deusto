
public class Comercial extends Empleado {

	private double comision = 0;

	public Comercial(String nombre, int edad, double salario, String departamento, double comision) {
		super(nombre, edad, salario, departamento);
		this.comision = comision;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}
	
	public void plus() {
		if (this.getEdad() > 30 && this.comision > 200) {
			super.plus();
		}
	}
}
