package concesionario;

public class Coche extends Vehiculo {
	private boolean pilotoAutomatico = false;
	private boolean repuestoGratuito = false;

	public Coche(String modelo, String color, String llanta, String interior, boolean pilotoAutomatico,
			boolean repuestoGratuito) {
		super(modelo, color, llanta, interior);
		this.pilotoAutomatico = pilotoAutomatico;
		this.repuestoGratuito = repuestoGratuito;
	}

	public boolean isPilotoAutomatico() {
		return pilotoAutomatico;
	}

	public boolean isRepuestoGratuito() {
		return repuestoGratuito;
	}

	public void setPilotoAutomatico(boolean pilotoAutomatico) {
		this.pilotoAutomatico = pilotoAutomatico;
	}

	public void setRepuestoGratuito(boolean repuestoGratuito) {
		this.repuestoGratuito = repuestoGratuito;
	}

	@Override
	int getPrecio() {
		int precio = 0;
		if (getModelo().equals("Tesla Model 3")) {
			precio = 51990;
		} else {
			precio = 30000;
		}

		if (getColor().equals("blanco")) {
		} else if (getColor().equals("rojo")) {
			precio += 2100;
		} else {
			precio += 1050;
		}

		if (getLlanta().equals("Aero")) {
		} else if (getLlanta().equals("Sport")) {
			precio += 1600;
		} else {
			precio += 2100;
		}

		if (getInterior().equals("negro")) {
		} else if (getInterior().equals("blanco")) {
			precio += 1050;
		} else {
			precio += 2100;
		}

		return precio;
	}

}
