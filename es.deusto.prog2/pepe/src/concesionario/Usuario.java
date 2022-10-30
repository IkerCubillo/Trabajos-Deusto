package concesionario;

import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {
	private int usuarioHash = 0;
	private int contrase�aHash = 0;
	private Coche cocheActual = new Coche("3", "B", "A", "N", false, false);
	private ArrayList<Object> userData = new ArrayList<>();
	
	public Usuario(int usuarioHash, int contrase�aHash, Coche cocheActual) {
		super();
		this.usuarioHash = usuarioHash;
		this.contrase�aHash = contrase�aHash;
		this.cocheActual = cocheActual;
		setUserData(userData, contrase�aHash, cocheActual );
	}

	public int getUsuarioHash() {
		return usuarioHash;
	}
	public int getContrase�aHash() {
		return contrase�aHash;
	}
	public Coche getCocheActual() {
		return cocheActual;
	}
	public ArrayList<Object> getUserData() {
		return userData;
	}
	
	public void anyadirCoche() {
		
	}
	
	public void setUserData(ArrayList<Object> userData, int contrase�aHash, Coche cocheActual) {
		userData.add(contrase�aHash);
		this.cocheActual = cocheActual;
	}
	
	public void setCocheActual(Coche cocheActual) {
		this.cocheActual = cocheActual;
	}

	
	

	

}
