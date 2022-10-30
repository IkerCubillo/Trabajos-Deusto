import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import deustea.Categoria;
import deustea.Mueble;

public class Main {

	public static void main(String[] args) {
		
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
		
		// Guardar ficheros binarios
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(binaryFilePath);

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(aClass);
			fos.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// Leer ficheros binarios
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
		
		// Guardar fichero de Texto
		
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(textFilePath));
			for(ClassA a: aClass) {
				String linea = a.getA() + ";" + a.getB();
				bw.write(linea);
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
		    
		    BufferedWriter bw2 = new BufferedWriter(new FileWriter("document.csv"));

		    for (ClassA a : aClass) {
		    	String line = a.getA() + ";" + a.getB() ;
		    	bw2.write(line);
		    	bw2.newLine();
		    }
		    bw2.close();

		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
		ArrayList<String> pepe = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File("document.csv"));
						
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				
				System.out.println(campos[1]);
			}
			
			sc.close();
			
		} catch (IOException e) {
			System.err.println("Error cargando productos");
		}
		
		// Leer ficheros de texto
		
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
			}
			br.close();
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
		/*
		try {
		    // Creamos el lector
		    BufferedReader br = new BufferedReader(new FileReader(textFilePath));

		    // Leemos hasta el final del fichero.
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] campos = line.split(";");
		        int A = Integer.parseInt(campos[0]);
		        int B = Integer.parseInt(campos[1]);
		        ClassA tmp = new ClassA(A,B);
		        bClass.add(tmp);
		    }

		    // close the reader
		    br.close();

		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		*/
		
		

	}

}
