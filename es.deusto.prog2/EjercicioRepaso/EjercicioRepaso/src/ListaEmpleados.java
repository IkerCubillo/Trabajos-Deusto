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
import java.util.ArrayList;

public class ListaEmpleados {
	
	private ArrayList<Empleado> empleados = new ArrayList<>();

	public ListaEmpleados(ArrayList<Empleado> empleados) {
		super();
		this.empleados = empleados;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public double calculoSalarioMedio(ArrayList<Empleado> empleados) {
		double salarioMedio = 0;
		for (Empleado e : empleados) {
			salarioMedio += e.getSalario();
		}
		return salarioMedio / empleados.size();
	}
	
	public void guardarBinario (String ruta) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(rutaBinaria);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(empleados);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	String rutaBinaria = "fichero.dat";
	String rutaTexto = "fichero.txt";
	
	public void guardarTexto(String ruta, ArrayList<Empleado> empleados) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(rutaTexto));
			
			for (Empleado e : empleados) {
				String line = e.getNombre() + ";" + e.getEdad() +  ";" + e.getSalario() + e.getDepartamento();
				if (e instanceof Repartidor) {
					
					line += ";" +  ((Repartidor) e).getZona();
				}
				else {
					line += ";" + ((Comercial) e).getComision();
				}
				bw.write(line);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarBinario(String ruta) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(rutaBinaria);
			ObjectInputStream in = new ObjectInputStream(fis);
			this.empleados = (ArrayList<Empleado>) in.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}}
	
	public void cargarTexto(String ruta) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(rutaTexto));
			String line;
			while ((line = br.readLine()) != null) {
				String[] campos = line.split(";");
				String nombre = campos[0];
				int edad = Integer.parseInt(campos[1]);
				double salario = Integer.parseInt(campos[2]);
				String departamento = campos[3];
				if (recorrerCampo(campos[4])) {
					// es comercial
					double comision = Integer.parseInt(campos[4]); 
					Comercial e = new Comercial(nombre, edad, salario, departamento, comision);
				} else {
					// es repartidor
					String zona = campos[4];
					Repartidor e = new Repartidor(nombre, edad, salario, departamento, zona);
				}
			} br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean recorrerCampo(String campo) {
		for (int i = 0; i < campo.length(); i ++) {
			if(Character.isDigit(campo.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
}
