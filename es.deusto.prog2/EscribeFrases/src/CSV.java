import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSV {
	public static void main(String[] args) {
		Persona p1 = new Persona(327638246, "sdhfjik", 234);
		Persona p2 = new Persona(327638246, "sdhfjik", 234);
		Persona p3 = new Persona(327638246, "sdhfjik", 234);
		
		List<List<String>> rows = Arrays.asList(
			    Arrays.asList("" + p1.getDni(), p2.getNombre(), "" + p2.getEdad()),
			    Arrays.asList("" + p2.getDni(), p2.getNombre(), "" + p2.getEdad()),
			    Arrays.asList("" + p3.getDni(), p3.getNombre(), "" + p3.getEdad())
			);
		
		
		// Escritura Fichero
		FileWriter fw;
		try {
			fw = new FileWriter("frases.csv");

				FileWriter csvWriter = new FileWriter("new.csv");
				csvWriter.append("DNI");
				csvWriter.append(",");
				csvWriter.append("NOMBRE");
				csvWriter.append(",");
				csvWriter.append("EDAD");
				csvWriter.append("n");

				for (List<String> rowData : rows) {
				    csvWriter.append(String.join(",", rowData));
				    csvWriter.append("n");
				}

				csvWriter.flush();
				csvWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
}