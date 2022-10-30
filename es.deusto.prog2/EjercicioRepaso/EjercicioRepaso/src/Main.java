import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		Repartidor r1 = new Repartidor("Cubo", 40, 30, "derecho", "zona 3");
		Repartidor r2 = new Repartidor("Sans", 30, 440, "derecho", "Zona 6");
		Repartidor r3 = new Repartidor("Nombre", 340, 340, "ingenieria", "zona 4");
		ArrayList<Empleado> empleados = new ArrayList<>();
		
		empleados.add(r1);
		empleados.add(r2);
		empleados.add(r3);
		
		
		
		HashMap<String , ArrayList<Empleado>> mapa = new HashMap<>();
		
		for(Empleado e : empleados) {
			if (mapa.containsKey(e.getDepartamento())) {
				mapa.get(e.getDepartamento()).add(e);
			} else {
				ArrayList<Empleado> tmp = new ArrayList<Empleado>();
				tmp.add(e);
				mapa.put(e.getDepartamento(), tmp);
			} 
		} 
		
		
		
		
	}
}
