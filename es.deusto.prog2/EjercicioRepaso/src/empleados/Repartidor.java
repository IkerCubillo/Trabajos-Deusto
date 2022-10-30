package empleados;

import excepciones.SalarioNegativoException;

public class Repartidor extends Empleado {
	private String zona = "";

	public Repartidor(String nombre, int edad, int salario, String departamento, String zona) throws SalarioNegativoException {
		super(nombre, edad, salario, departamento);
		this.zona = zona;
		// TODO Auto-generated constructor stub
	}

	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	
	

	@Override
	public String toString() {
		return "Repartidor [zona=" + zona + ", getNombre()=" + getNombre() + ", getSalario()=" + getSalario()
				+ ", getDepartamento()=" + getDepartamento() + "]";
	}

	@Override
	public void plus() {
		if(this.getEdad() < 25 && this.getZona() == "zona 3") {
			salario += plus;
		}
	}

}
