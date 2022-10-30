package concesionario;

public abstract class Vehiculo {
	private String modelo;
	private String color;
	private String llanta;
	private String interior;
	private int precio;

	public Vehiculo(String modelo, String color, String llanta, String interior) {
		setModelo(modelo);
		setColor(color);
		setLlanta(llanta);
		setInterior(interior);
		this.precio = getPrecio();
	}

	public String getModelo() {
		return modelo;
	}

	public String getColor() {
		return color;
	}

	public String getLlanta() {
		return llanta;
	}

	public String getInterior() {
		return interior;
	}

	public void setModelo(String modelo) {
		if (modelo.equals("3")) {
			this.modelo = "Tesla Model 3";
		} else {
			this.modelo = modelo;
		}
	}

	public void setColor(String color) {
		if (color.equals("B")) {
			this.color = "blanco";
		} else if (color.equals("N")) {
			this.color = "negro";
		} else if (color.equals("G")) {
			this.color = "gris";
		} else if (color.equals("A")) {
			this.color = "azul";
		} else if (color.equals("R")) {
			this.color = "rojo";
		} else {
			this.color = color;
		}
	}

	public void setLlanta(String llanta) {
		if (llanta.equals("A")) {
			this.llanta = "Aero";
		} else if (llanta.equals("S")) {
			this.llanta = "Sport";
		} else {
			this.llanta = llanta;
		}
	}

	public void setInterior(String interior) {
		if (interior.equals("B")) {
			this.interior = "blanco";
		} else if (interior.equals("N")) {
			this.interior = "negro";
		} else {
			this.interior = interior;
		}
	}

	abstract int getPrecio();

	public String getNombreCoche() {
		return modelo.substring(12, 13) + color.substring(0, 1).toUpperCase() + llanta.substring(0, 1)
				+ interior.substring(0, 1).toUpperCase();
	}

	@Override
	public String toString() {
		return modelo + " de color " + color + ", llantas " + llanta + " e interior " + interior;
	}
}
