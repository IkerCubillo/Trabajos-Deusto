package empleados;

import excepciones.SalarioNegativoException;

public class Comercial extends Empleado {
	private double comision = 0.0;

	public Comercial(String nombre, int edad, int salario, String departamento, double comision) throws SalarioNegativoException {
		super(nombre, edad, salario, departamento);
		this.comision = comision;
		// TODO Auto-generated constructor stub
	}
	
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}

	@Override
	public String toString() {
		return "Comercial [comision=" + comision + ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad()
				+ ", getSalario()=" + getSalario() + ", getDepartamento()=" + getDepartamento() + "]";
	}

	@Override
	public void plus() {
		if(this.getEdad() > 30 && this.comision > 200) {
			salario += plus;
		}
	}

}
