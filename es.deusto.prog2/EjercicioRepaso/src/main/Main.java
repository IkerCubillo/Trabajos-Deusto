package main;

import java.util.ArrayList;
import java.util.HashMap;

import empleados.*;
import excepciones.SalarioNegativoException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Empleado> e1 = new ArrayList<>();
		ListaEmpleados le = new ListaEmpleados(e1);
		try {
			for(int i = 1; i <= 10; i++) {
				Comercial c = new Comercial("C" + i, 42, 150*i, "Ventas",200);
				e1.add(c);
			}
			for(int i = 1; i <= 10; i++) {
				Repartidor r = new Repartidor("R" + i, 42,175*i, "Ventas", "Zona 1");
				e1.add(r);
			}
			
		} catch (SalarioNegativoException e) {
			
		}
		
		System.out.println(le.salarioMedio());
		HashMap<String , ArrayList<Empleado>> mapa = new HashMap<>();
				
		for(Empleado e: e1) {
			if(!mapa.containsKey(e.getDepartamento())) {
				mapa.put(e.getDepartamento(), new ArrayList<Empleado>());
			}
			ArrayList<Empleado> tmp = mapa.get(e.getDepartamento());
			tmp.add(e);
			mapa.put(e.getDepartamento(), tmp);
		}

		System.out.println(mapa);
	}

}
