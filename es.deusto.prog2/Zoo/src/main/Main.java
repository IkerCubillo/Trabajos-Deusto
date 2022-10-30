package main;

import animales.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ave a = new Ave("Angel","pato",18,65,178,28,"amarillo");
		System.out.println(a);
		
		Pez p = new Pez("a","a",23,43,125,2240,false);
		p.hablar();

	}

}
