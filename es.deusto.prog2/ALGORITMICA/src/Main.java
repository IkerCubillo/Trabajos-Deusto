import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String args[]){
		Random rand=new Random();
		
		ArrayList<Integer> lista1=new ArrayList<Integer>();
		ArrayList<Integer> lista2=new ArrayList<Integer>();
		ArrayList<Integer> lista3=new ArrayList<Integer>();
		
		for(int i=0;i<10;i++) {
			int randomInt = rand.nextInt(10); 
			lista1.add(randomInt);	
		}
		
		for(int i=0;i<1000;i++) {
			int randomInt = rand.nextInt(1000); 
			lista2.add(randomInt);	
		}
		
		for(int i=0;i<100000;i++) {
			int randomInt = rand.nextInt(100000); 
			lista3.add(randomInt);
		}
		
		Algorithm obj = new Algorithm(); 	
		long start1 = System.nanoTime(); 	
	    obj.quickSort(lista1); 		
	    long end1 = System.nanoTime();		
	    System.out.println("The Insert Sort algorithm with an array of 10 elements took " + (end1-start1) + " nanoseconds to execute, or " + ((end1-start1)*0.000001) + " miliseconds" );
	    
	    Algorithm obj1 = new Algorithm(); 	
		long start2 = System.nanoTime(); 	
	    obj.quickSort(lista2); 		
	    long end2 = System.nanoTime();		
	    System.out.println("The Insert Sort algorithm with an array of 1000 elements took " + (end2-start2) + " nanoseconds to execute, or " + ((end2-start2)*0.000001) + " miliseconds" );
	    
	    Algorithm obj2 = new Algorithm(); 	
		long start3 = System.nanoTime(); 	
	    obj.quickSort(lista3); 		
	    long end3 = System.nanoTime();		
	    System.out.println("The Insert Sort algorithm with an array of 100000 elements took " + (end3-start3) + " nanoseconds to execute, or " + ((end3-start3)*0.000001) + " miliseconds" );
	    
	}
}