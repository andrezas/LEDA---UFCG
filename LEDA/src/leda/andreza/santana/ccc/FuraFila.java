package leda.andreza.santana.ccc;

import java.util.Arrays;
import java.util.Scanner;

class FuraFila {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] fila = sc.nextLine().split(" ");
		int index = sc.nextInt();
		
		int auxiliar = 0;
		int posicaoRef = 0;
		
		for (int i = 0; i < fila.length; i++) {
			if (i == index) {
				for (int n = i; n != posicaoRef; n--) {
					auxiliar = Integer.parseInt(fila[n]);
					fila[n] = fila[n-1];
					fila[n-1] = Integer.toString(auxiliar);
					
				}
				index += 1;
				posicaoRef += 1;
				System.out.println(Arrays.toString(fila));
			}
		}
		
	}
		
}


