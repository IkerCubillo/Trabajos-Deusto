import java.util.ArrayList;

import transporte.Avioneta;
import transporte.Barco;
import viajes.Excursion;
import viajes.Guia;
import viajes.Trayecto;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Barco b1 = new Barco(30, 50, true);
		Barco b2 = new Barco(20, 60, true);
		Barco b3 = new Barco(10, 70, true);
		
		Avioneta a1 = new Avioneta(5, 200, 1);
		Avioneta a2 = new Avioneta(15, 400, 10);
		Avioneta a3 = new Avioneta(50, 500, 100);
		
		Guia g1 = new Guia("Bruce", 20, 20, false);
		Guia g2 = new Guia("Batman", 80, 10, false);
		Guia g3 = new Guia("Robin", 30, 20, false);
		
		Trayecto t1 = new Trayecto(0, 0, 0, 0, 100, a1);
		Trayecto t2 = new Trayecto(0, 0, 0, 0, 100, a2);
		Trayecto t3 = new Trayecto(0, 0, 0, 0, 100, a3);
		Trayecto t4 = new Trayecto(0, 0, 0, 0, 100, b1);
		Trayecto t5 = new Trayecto(0, 0, 0, 0, 100, b2);
		Trayecto t6 = new Trayecto(0, 0, 0, 0, 100, b3);
		
		ArrayList<Trayecto> aTrayectos1 = new ArrayList<Trayecto>();
		aTrayectos1.add(t1);
		aTrayectos1.add(t3);
		aTrayectos1.add(t5);
		
		ArrayList<Trayecto> aTrayectos2 = new ArrayList<Trayecto>();
		aTrayectos2.add(t4);
		aTrayectos2.add(t2);
		aTrayectos2.add(t6);
		
		
		Excursion e1 = new Excursion("Exc1", aTrayectos1, false, g1);
		Excursion e2 = new Excursion("Exc2", aTrayectos2, false, g2);
		
		ArrayList<Excursion> aExcursiones = new ArrayList<Excursion>();
		aExcursiones.add(e1);
		aExcursiones.add(e2);

		Excursion eMasCara = Excursion.getExcursionMasCara(aExcursiones);
		System.out.println(eMasCara.cobrar());
		System.out.println(eMasCara);
	}

}