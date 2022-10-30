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
import java.util.ArrayList;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isDouble("hol"));
		
		ClassA a1 = new ClassA(1,1);
		ClassA a2 = new ClassA(2,2);
		ClassA a3 = new ClassA(3,3);
		
		ArrayList<ClassA> aClass = new ArrayList<ClassA>();
		
		aClass.add(a1);
		aClass.add(a2);
		aClass.add(a3);
		
		String binaryFilePath = "fichero.dat";
		String textFilePath = "fichero.txt";
		
		ArrayList<ClassA> bClass = new ArrayList<ClassA>();
		
		// Guardar Binario
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(binaryFilePath);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(aClass);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Cargar binario
		FileInputStream fis;
		
			try {
				fis = new FileInputStream(binaryFilePath);
				ObjectInputStream ois = new ObjectInputStream(fis);
				bClass = (ArrayList<ClassA>) ois.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			System.out.println(bClass);
			
			bClass = new ArrayList<ClassA>();
			
		// Guardar Texto
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(textFilePath));
				for(ClassA a: aClass) {
					String line = a.getA() + ";" + a.getB();
					bw.write(line);
					bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		// Leer Texto
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(textFilePath));

				String line;
				while((line = br.readLine()) != null) {
					String[] campos = line.split(";");
					int A = Integer.parseInt(campos[0]);
					int B = Integer.parseInt(campos[1]);
					ClassA tmp = new ClassA(A, B);
					bClass.add(tmp);
				} br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(bClass);		
		}
	
	
	public static boolean isDouble(String cadena) {
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
