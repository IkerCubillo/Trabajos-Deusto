
public class Repartidor extends Empleado {

	private String zona = "";

	public Repartidor(String nombre, int edad, double salario, String departamento, String zona) {
		super(nombre, edad, salario, departamento);
		this.zona = zona;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public void plus() {
		if (this.getEdad() < 25 && this.zona.equals("zona 3")) {
			super.plus();
		}
	}
}
