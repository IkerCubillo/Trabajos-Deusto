package redSocial;

import java.util.ArrayList;

public class Usuario {
	private String nombre = "";
	private int fechaCreacion = 0;
	private ArrayList<Usuario> seguidores = new ArrayList<Usuario>();
	private ArrayList<Usuario> siguiendo = new ArrayList<Usuario>();
	private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
	private int totalSeguidores = 0;
	private int totalSiguiendo = 0;
	
	public Usuario() {
	}
	
	public Usuario(String nombre, int fechaCreacion, int totalSeguidores, int totalSiguiendo) {
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.totalSeguidores = totalSeguidores;
		this.totalSiguiendo = totalSiguiendo;
	}

	public String getNombre() {
		return this.nombre;
	}
	public int getFechaCreacion() {
		return this.fechaCreacion;
	}
	public ArrayList<Usuario> getSeguidores() {
		return this.seguidores;
	}
	public ArrayList<Usuario> getSiguiendo() {
		return this.siguiendo;
	}
	public ArrayList<Publicacion> getPublicaciones() {
		return this.publicaciones;
	}
	public int getTotalSeguidores() {
		return this.totalSeguidores;
	}
	public int getTotalSiguiendo() {
		return this.totalSiguiendo;
	}
	
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
