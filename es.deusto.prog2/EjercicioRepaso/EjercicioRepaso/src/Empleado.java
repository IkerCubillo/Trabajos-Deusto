
public abstract class Empleado {

	private String nombre = "";
	private int edad;
	private double salario;
	private String departamento = "";
	static int PLUS = 300;
	
	public Empleado(String nombre, int edad, double salario, String departamento) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		salarioValido(this.salario);
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public double getSalario() {
		return salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public static int getPLUS() {
		return PLUS;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setSalario(double salario) {
		salarioValido(this.salario);
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public static void setPLUS(int pLUS) {
		PLUS = pLUS;
	}
	
	public void plus() {
		this.setSalario(this.getSalario() + PLUS);
	}
	
	public void salarioValido(double salario) {
		try {
			if (this.salario < 0) {
				throw new SalarioNegativoException();
				
			}
			else {
				this.salario = salario;}}
		catch (SalarioNegativoException e) {
				e.toString();
		}
	}
}
