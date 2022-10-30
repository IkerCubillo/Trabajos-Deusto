package es.deusto.progii.multimedia.main;

import java.util.ArrayList;

import es.deusto.progii.multimedia.*;

public class Main2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Png p = new Png("amsnd",123);
		Jpg j = new Jpg("Ruta1",100,0);
		
		ArrayList<Png> aPNG = new ArrayList<Png>(); // Tambien funciona estableciendo la clase madre <Imagen>
		aPNG.add(p);
		aPNG.add(p);
		aPNG.add(p);
		aPNG.add(p);
		aPNG.add(p);
		aPNG.add(p);
		aPNG.remove(p);
		aPNG.size();
		aPNG.get(0);
		(aPNG.get(0)).getCanalAlfa();
	}

}
