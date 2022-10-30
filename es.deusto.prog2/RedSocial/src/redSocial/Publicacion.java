package redSocial;

import java.util.ArrayList;

public class Publicacion {
	private String usuario = "";
	private int fechaPublicacion = 0;
	private int likes = 0;
	private ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
	
	public Publicacion() {
	}
	
	public Publicacion(String usuario, int fechaPublicacion, int likes) {
		this.usuario = usuario;
		this.fechaPublicacion = fechaPublicacion;
		this.likes = likes;
	}
	
	public void getUsuario() {
		
	}
	
	

}
