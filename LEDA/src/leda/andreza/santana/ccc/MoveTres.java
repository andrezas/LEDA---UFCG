package leda.andreza.santana.ccc;

import java.util.Arrays;
import java.util.Scanner;

class MoveTres {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		String[] sequencia = sc.nextLine().split(" ");
		
		int indexInicio = 0;
		
		for (int i =0; i < sequencia.length; i++) {
			if(Integer.parseInt(sequencia[i]) > Integer.parseInt(sequencia[i+1])) {
				indexInicio = i+1;
				break;
			}
		}
		
		algoritmoInsertionSort(sequencia, indexInicio);
		
	}
	
	private static void algoritmoInsertionSort(String[] sequencia, int inicio) {
		for (int i = inicio; i < sequencia.length; i++) { 
			
			int j = i;
		
			while (j > 0 && Integer.parseInt(sequencia[j]) < Integer.parseInt(sequencia[j-1])) {
				int aux = Integer.parseInt(sequencia[j]);
				sequencia[j] = sequencia[j - 1];
				sequencia[j - 1] = Integer.toString(aux);
				j -= 1;
				System.out.println(Arrays.toString(sequencia));
			}
		
		}	
	}
}
