package main;

import deustoTrain.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tren t1 = new Tren(20000, "AVE76FG");
		Tren t2 = new Tren(1000, "CIT64B");
		Tren t3 = new Tren(40000, "ME345");
		Tren t4 = new Tren(5000, "TR34H56");
		Tren t5 = new Tren(10000, "MB347A");
		
		Pasajero p1 = new Pasajero("Iker",	79116088,644111116);
		Pasajero p2 = new Pasajero("Inigo",	45673489,658583869);
		Pasajero p3 = new Pasajero("Josu",	12674398,819972835);
		Pasajero p4 = new Pasajero("Gorka",	34685394,189654573);
		Pasajero p5 = new Pasajero("Leire",	23864679,756981324);
		Pasajero p6 = new Pasajero("Ane",	23208563,645753915);
		
		Estacion e1 = new Estacion("Norte", 	78, 123, true);
		Estacion e2 = new Estacion("Sur", 		63, -54, true);
		Estacion e3 = new Estacion("Este", 		34, 12, false);
		Estacion e4 = new Estacion("Oeste", 	-87, 137, true);
		Estacion e5 = new Estacion("Margarita", 45, -126, false);
		Estacion e6 = new Estacion("Ingurubeitia", -46, 123, true);
		Estacion e7 = new Estacion("Laprats", 	63, 98, false);
		Estacion e8 = new Estacion("Arkatupe", 	45, 78, false);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		
	}

}
