package concesionario;

import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {
	private int usuarioHash = 0;
	private int contraseñaHash = 0;
	private Coche cocheActual = new Coche("3", "B", "A", "N", false, false);
	private ArrayList<Object> userData = new ArrayList<>();
	
	public Usuario(int usuarioHash, int contraseñaHash, Coche cocheActual) {
		super();
		this.usuarioHash = usuarioHash;
		this.contraseñaHash = contraseñaHash;
		this.cocheActual = cocheActual;
		setUserData(userData, contraseñaHash, cocheActual );
	}

	public int getUsuarioHash() {
		return usuarioHash;
	}
	public int getContraseñaHash() {
		return contraseñaHash;
	}
	public Coche getCocheActual() {
		return cocheActual;
	}
	public ArrayList<Object> getUserData() {
		return userData;
	}
	
	public void anyadirCoche() {
		
	}
	
	public void setUserData(ArrayList<Object> userData, int contraseñaHash, Coche cocheActual) {
		userData.add(contraseñaHash);
		this.cocheActual = cocheActual;
	}
	
	public void setCocheActual(Coche cocheActual) {
		this.cocheActual = cocheActual;
	}

	
	

	

}
