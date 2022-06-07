package leda.andreza.santana.ccc;

import java.util.Arrays;

import java.util.Scanner;

class MelhorPivot {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		String[] posicoesPivot = sc.nextLine().split(" ");
		int mediana = pickPivotIndex(sequencia, 0, sequencia.length-1);
		
		int i = Integer.parseInt(posicoesPivot[0]);
		int j = Integer.parseInt(posicoesPivot[1]);
		
		// calcula a diferença entre i e a mediana
		int diferencaIMediana = Integer.parseInt(sequencia[i]) - mediana;
		if(diferencaIMediana < 0) {
			diferencaIMediana = diferencaIMediana * -1;
		}
		// calcula a diferença entre j e a mediana
		int diferencaJMediana = Integer.parseInt(sequencia[j]) - mediana;
		if(diferencaJMediana < 0) {
			diferencaJMediana = diferencaJMediana * -1;
		}
		
		if(diferencaIMediana <= diferencaJMediana) {
			System.out.println(posicoesPivot[0]);
		}else {
			System.out.println(posicoesPivot[1]);
		}
	}
	// determina a mediana do array.
	public static int pickPivotIndex(String[] values, int left, int right) {
	    int mid = (left + right) / 2;
	    
	    int[] sorted = {Integer.parseInt(values[left]), Integer.parseInt(values[mid]), Integer.parseInt(values[right])};
	    Arrays.sort(sorted);
	    
	    if (sorted[1] == Integer.parseInt(values[left])){
	    	return Integer.parseInt(values[left]);
	    } else if (sorted[1] == Integer.parseInt(values[mid])) {
	    	return Integer.parseInt(values[mid]);
	    } else { 
	    	return Integer.parseInt(values[right]);
	    }
	}

}
