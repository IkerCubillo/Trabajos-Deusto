import java.util.ArrayList;
import java.util.Random;

public class Algorithm {
	Random rand = new Random();
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	//QuickSort(we asign the values to then call the actual function)
	public void quickSort(ArrayList<Integer> numList) {
		int p=0;
		int r=numList.size()-1;
		qS(numList, p, r);
	}
	
	//QuickSort
	public void qS(ArrayList<Integer> numList, int p, int r) {
		int q;
		if(p<r) {
			 q=partition(numList, p, r);
			 qS(numList, p, q-1);
			 qS(numList, q+1, r);
		}
	}
	
	
	//Partition
	public int partition(ArrayList<Integer> numList, int p, int r) {
		int x=numList.get(r);
		int i=p-1;
		
		for(int j=p;j<=r-1;j++) {
			if(numList.get(j)<=x) {
				i=i+1;
				int aux=numList.get(i);
				numList.set(i, numList.get(j));
				numList.set(j, aux);
			}	
		}
		int aux=numList.get(i+1);
		numList.set(i+1, numList.get(r));
		numList.set(r, aux);
		return i+1;
	}

}
