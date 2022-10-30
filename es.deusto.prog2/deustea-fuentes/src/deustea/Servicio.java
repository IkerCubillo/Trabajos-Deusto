package deustea;

import java.io.Serializable;

public class Servicio implements Pagable, Serializable {
	protected TipoServicio tipo; 
	protected int nivel;
	
	/** Constructor con argumentos
	 * @param tipo de servicio (TRANSPORTE, MONTAJE, SEGURO)
	 * @param nivel del servicio (0: el más básico)
	 */
	public Servicio(TipoServicio tipo, int nivel) {
		super();
		this.tipo = tipo;
		this.setNivel(nivel);
	}
	
	/** Constructor por defecto, crea un servicio de TRANSPORTE de nivel 0
	 */
	public Servicio() {
		super();
		this.tipo = TipoServicio.TRANSPORTE;
		this.setNivel(0);
	}

	/**
	 * @return tipo de servicio (TRANSPORTE, MONTAJE, SEGURO)
	 */
	public TipoServicio getTipo() {
		return tipo;
	}

	/**
	 * @param tipo de servicio (TRANSPORTE, MONTAJE, SEGURO)
	 */
	public void setTipo(TipoServicio tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return nivel del servicio (0: el más básico)
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * @param nivel del servicio (0: el más básico)
	 */
	public void setNivel(int nivel) {
		if (nivel >= 0) {
			this.nivel = nivel;
		}
	}

	/** Convierte un Servicio a String
	 */
	@Override
	public String toString() {
		return "Servicio de " + tipo + " (nivel: " + nivel + ")";
	}

	/**
	 * @return precio del servicio en función del tipo y el nivel
	 */
	@Override
	public double getPrecio() {
		if (tipo.equals(TipoServicio.TRANSPORTE)) {
			return 50 + nivel * 10;
		} else if (tipo.equals(TipoServicio.MONTAJE)) {
			return 50 + nivel * 20;
		} else {
			return 50 + nivel * 30;
		}
	}
	
	
}
