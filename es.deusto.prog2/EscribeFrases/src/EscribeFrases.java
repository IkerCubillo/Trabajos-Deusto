import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscribeFrases {
	
	public static void main(String[] args) {
		ArrayList<String> aFrases = new ArrayList<String>();
		String ruta = null;
		
		aFrases.add("Hola Patito");
		aFrases.add("Hola Patito");
		aFrases.add("Hola Patito");
		aFrases.add("Hola Patito");
		aFrases.add("Hola Patito");
		aFrases.add("Hola Patito");
		aFrases.add("Hola Patito");
		
		
		// Escritura Fichero
		FileWriter fw;
		try {
			fw = new FileWriter("frases.txt");
			for(String frase : aFrases) {
				fw.write(frase);
			}
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		
		// Lectura fichero
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> aFrasesLeidas = new ArrayList<String>();
		
		try {
			fr = new FileReader(ruta + "frases.txt");
			br = new BufferedReader(fr);
			while(fr.read() != -1) {
				aFrasesLeidas.add(br.readLine());
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}