package empleados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import excepciones.SalarioNegativoException;

public class ListaEmpleados implements Serializable {
	private ArrayList<Empleado> empleados = new ArrayList<>();

	public ListaEmpleados(ArrayList<Empleado> empleados) {
		super();
		this.empleados = empleados;
	}
	
	public double salarioMedio() {
		double salarioTotal = 0;
		for(Empleado e: empleados) {
			salarioTotal += e.getSalario();
		}
		return (salarioTotal/empleados.size());
	}
	
	public void guardarBinario(String binaryFileRuta) throws IOException {
		FileOutputStream fos;
			fos = new FileOutputStream(binaryFileRuta);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(empleados);
			fos.close();
	}
	
	public void guardarTexto(String TextFileRuta) {
		try {
		    
		    BufferedWriter bw = new BufferedWriter(new FileWriter(TextFileRuta));

		    for (Empleado a : empleados) {
		    	String line = a.getDepartamento() + ";" + a.getEdad() + ";" + a.getNombre() + ";" + a.getSalario();
		    	
		    	if(a instanceof Repartidor) {
		    		line += ";" + ((Repartidor)a).getZona();
		    	} else {
		    		line += ";" + ((Comercial)a).getComision();
		    	}
		    	
		    	bw.write(line);
		    	bw.newLine();
		    }
		    bw.close();

		} catch (IOException ex) {
		    ex.printStackTrace();
		}		
	}
	
	public void cargarBinario(String binaryFileRuta) throws IOException, ClassNotFoundException{
		empleados.clear();
		FileInputStream fis;
			fis = new FileInputStream(binaryFileRuta);
			ObjectInputStream in = new ObjectInputStream(fis);
			ArrayList<Empleado> aEmpelados = (ArrayList<Empleado>) in.readObject();	
			for(Empleado e: aEmpelados) {
				empleados.add(e);
			}
	}
	
	public void cargarTexto(String TextFileRuta) throws SalarioNegativoException {
		empleados.clear();
		try {
		 BufferedReader br = new BufferedReader(new FileReader(TextFileRuta));
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] campos = line.split(";");
		        String nombre = campos[0];
		        int edad = Integer.parseInt(campos[1]);
		        int salario = Integer.parseInt(campos[2]);
		        String departamento = campos[3];
		        if (isDouble(campos[4])) {
						// es comercial
					double comision = Integer.parseInt(campos[4]); 
					Comercial e = new Comercial(nombre, edad, salario, departamento, comision);
					empleados.add(e);
				} else {
					// es repartidor
					String zona = campos[4];
					Repartidor e = new Repartidor(nombre, edad, salario, departamento, zona);
					empleados.add(e);
						}
				} br.close();
				
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		for(Empleado ep: empleados) {
			System.out.println(ep);
		}
	}
	
	public boolean isDouble(String cadena) {
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (Exception e) {
			System.out.println("Its not double");
			return false;
			// TODO: handle exception
		}
		
	}
}
