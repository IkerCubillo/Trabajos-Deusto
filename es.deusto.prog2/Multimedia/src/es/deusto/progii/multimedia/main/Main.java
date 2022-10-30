package es.deusto.progii.multimedia.main;

import es.deusto.progii.multimedia.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Png p = new Png("amsnd",123);
		Jpg j = new Jpg("Ruta1",100,0);
		
		System.out.println(p);
		System.out.println(j);
		
		if(p instanceof Png) {
			System.out.println("Soy un PNG");
		}
		else {
			System.out.println("No soy un PNG");
		}
		
	}

}
