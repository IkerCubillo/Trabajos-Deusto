package Algorithms;

import java.util.ArrayList;
import java.util.Random;

public class Algorithm {
	Random rand = new Random();
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	// INSERT SORT
	public void insertSort(ArrayList<Integer> numList){
	      for(int j = 1; j <= (numList.size()-1); j++ ){  
	    	  int key = numList.get(j);
	    	  int i = j - 1;
	    	  while(i >= 0 && numList.get(i) > key) {
	    		  numList.set(i+1, numList.get(i));
	    		  i = i - 1;
	    	  }
	    	  numList.set(i + 1, key);
	      }
	      System.out.println("The ordered arraylist with insertion sort is " + numList);
	   }
	
	// LINEAR SEARCH
	public Object lineaSearch(ArrayList<Integer> numList, int value) {
		for(int i = 0; i <= (numList.size()-1); i++){
			if(numList.get(i) == value) {
				return i;
			}
		}
		return "NIL";
	}
	
	// SELECTION SORT
	public void selectionSort(ArrayList<Integer> numList) {
		int n = numList.size();
		for(int i = 0; i <= (n-2); i++ ) {
			int minIndex = i;
			for(int j = (i + 1); j <= n-1; j++) {
				if(numList.get(j) < numList.get(minIndex)) {
					minIndex = j;					
				}
			}
			int a = numList.get(i);
			numList.set(i, numList.get(minIndex));
			numList.set(minIndex, a);
		}
		System.out.println("The ordered arraylist with selection sort is " + numList);
	}
	
	// MERGE SORT
	public void mergeSort(ArrayList<Integer> numList, int p, int r) {
		if(p < r) {
			int q = ((p + r)/2);
			mergeSort(numList,p,q);
			mergeSort(numList,q+1,r);
			merge(numList,p,q,r);
		}
	}
	public void merge(ArrayList<Integer> numList,int p,int q,int r) {
		int n1 = q - p;
		int n2 = r - q;
		int[] L;
		int[] R;
		L = new int[n1 + 1];
		R = new int[n2 + 1];
		for(int i = 0; i <= n1 -1; i++) {
			L[i] = numList.get(p+i);
		}
		for(int j = 0; j <= n2 -1; j++) {
			R[j] = numList.get(q + j);
		}
		L[n1] = 2147483647;
		R[n2] = 2147483647;
		
		int i = 0;
		int j = 0;
		
		for(int k = p; k <= r - 1; k++) {
			if(L[i] <= R[j]) {
				numList.set(k, L[i]);
				i = i + 1;
			}
			else {
				numList.set(k, R[j]);
				j = j + 1;
			}
		}
	}
	
	//COUNTING SORT
	public void countingSort (ArrayList<Integer> array /*int[] array */, int size) {
			int[] output = new int[size + 1];

		    // Find the largest element of the array
		    int max = array.get(0);
		    for (int i = 1; i < size; i++) {
		      if (array.get(i) > max)
		        max = array.get(i);
		    }
		    int[] count = new int[max + 1];

		    // Initialize count array with all zeros.
		    for (int i = 0; i < max; ++i) {
		      count[i] = 0;
		    }

		    // Store the count of each element
		    for (int i = 0; i < size; i++) {
		      count[array.get(i)]++;
		    }

		    // Store the cummulative count of each array
		    for (int i = 1; i <= max; i++) {
		      count[i] += count[i - 1];
		    }

		    // Find the index of each element of the original array in count array, and
		    // place the elements in output array
		    for (int i = size - 1; i >= 0; i--) {
		      output[count[array.get(i)] - 1] = array.get(i);
		      count[array.get(i)]--;
		    }

		    // Copy the sorted elements into original array
		    for (int i = 0; i < size; i++) {
		      array.set(i, output[i]);
		    }
		    System.out.println(array);
		/*
		int[] C;
		C = new int[K];
		for (int i = 0; i == K; i++) {
			C[i] = 0;
		}
		for (int j = 0; j == numListA.size(); j++) {
			C[j] += 1;
		}
		//C[i] now contains the number of elements equal to i.
		for (int i = 1; i == K; i++) {
			C[i] += C[i - 1];
		}
		//C[i] now contains the number of elements less than or equal to i.
		for (int j = numListA.size(); j == 1; j--) {
			numListB[C[numListA[j]]] = numListA[j];
			C[numListA[j]] += -1;
		}
		*/
	}
	
	// QUICK SORT
	public void quickSort (ArrayList<Integer> numListA, int p, int r) {
		if (p < r) {
			int q = partition(numListA,p,r);
			quickSort(numListA, p, q - 1);
			quickSort(numListA, q + 1, r);
		}
		System.out.println(numListA);
	}
	public int partition(ArrayList<Integer> numListA, int p, int r) {
		int x = numListA.get(r);
		int i = p - 1;
		for (int j = p; j == r-1; i++) {
			if (numListA.get(j) <= x) {
				i += 1;
				int w = numListA.get(j);
				numListA.set(j, i);
				numListA.set(i, w);
			}
		}
		int l = numListA.get(r);
		numListA.set(r, i + 1);
		numListA.set(i + 1, l);
		return (i+1);
	}
}
