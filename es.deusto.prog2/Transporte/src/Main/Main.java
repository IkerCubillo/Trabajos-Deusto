package Main;

import flotaTransporte.*;

public class Main {
	public static void main(String[] args) {
		Autobus a = new Autobus("0000", 2020, 200, "IRIzar", 200);
		Taxi t = new Taxi("0000",2020, 150, "Ford Mondeo",200);
		
		System.out.println(a);
		System.out.println(t);
	}

}
