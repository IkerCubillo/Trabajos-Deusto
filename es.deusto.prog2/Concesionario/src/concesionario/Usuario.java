package concesionario;

import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {
	private int usuarioHash = 0;
	private int contrasenaHash = 0;
	private Coche cocheActual = new Coche("3", "B", "A", "N", false, false);
	private ArrayList<Object> userData = new ArrayList<>();

	public Usuario(int usuarioHash, int contrasenaHash, Coche cocheActual) {
		super();
		this.usuarioHash = usuarioHash;
		this.contrasenaHash = contrasenaHash;
		this.cocheActual = cocheActual;
		setData(userData, contrasenaHash, cocheActual);
	}

	public int getUsuarioHash() {
		return usuarioHash;
	}

	public int getContrasenaHash() {
		return contrasenaHash;
	}

	public Coche getCocheActual() {
		return cocheActual;
	}

	public ArrayList<Object> getUserData() {
		return userData;
	}

	public void anyadirCoche() {

	}

	public void setData(ArrayList<Object> userData, int contrasenaHash, Coche cocheActual) {
		userData.add(contrasenaHash);
		userData.add("null");
		this.cocheActual = cocheActual;
	}

	public void setUserData(ArrayList<Object> userData) {
		this.userData = userData;
	}

	public void setCocheActual(Coche cocheActual) {
		this.cocheActual = cocheActual;
	}

	@Override
	public String toString() {
		return "Usuario [usuarioHash=" + usuarioHash + ", contrase�aHash=" + contrasenaHash + ", cocheActual="
				+ cocheActual + ", userData=" + userData + "]";
	}

}
