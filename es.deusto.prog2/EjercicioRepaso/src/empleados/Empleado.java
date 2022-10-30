package empleados;

import excepciones.SalarioNegativoException;

public abstract class Empleado{
	private String nombre = "";
	private int edad = 0;
	protected int salario = 0;
	private String departamento = "";
	protected static final int plus = 300;
	
	public Empleado(String nombre, int edad, int salario, String departamento) throws SalarioNegativoException {
		super();
		this.nombre = nombre;
		this.edad = edad;
		setSalario(salario);
		this.departamento = departamento;
		plus();
	}

	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public int getSalario() {
		return salario;
	}
	public String getDepartamento() {
		return departamento;
	}
	public static int getPlus() {
		return plus;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setSalario(int salario) throws SalarioNegativoException {
		if(salario < 0) {
			throw new SalarioNegativoException(salario);
		}
		else {
			this.salario = salario;
		}
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + ", departamento="
				+ departamento + "]";
	}

	public abstract void plus();
}
