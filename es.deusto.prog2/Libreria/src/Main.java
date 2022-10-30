
public class Main {
	public static void main(String[] args) {
		// Constructor vacio
		Libro libro1 = new Libro("Rebelión en la granja","George Orwell",1945,"9788499890951");
		System.out.println(libro1);
		
		Libro l1 = new Libro("Titulo1","Autor1",1900,"ISBN1");
		Libro l2 = new Libro("Titulo2","Autor2",1900,"ISBN2");
		Libro l3 = new Libro("Titulo3","Autor3",1900,"ISBN3");
		
		System.out.println(l1.getPropiedadEstatica());
		System.out.println(l1.getTitulo());
		System.out.println(l2.getPropiedadEstatica());
		l2.setPropiedadEstatica(10);
		System.out.println(l2.getTitulo());
		System.out.println(l3.getPropiedadEstatica());
		System.out.println(l3.getTitulo());
		

		Libro[] estanteria = new Libro[50];
		
		// for i in range(10):
		for(int i = 0; i<30 ;i++) {
			Libro l = new Libro("Titulo-" + i,
					"Autor-" + i, 
					1900 + i,
					"ISBN-" + i);
			
			estanteria[i] = l;
		}
		
		for(int i = 0; i < estanteria.length; i++) {
			if(estanteria[i] != null) {
				System.out.println(estanteria[i]);
			}
		}
	}
}