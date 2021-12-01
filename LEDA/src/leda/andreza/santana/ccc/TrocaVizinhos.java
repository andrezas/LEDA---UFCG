package leda.andreza.santana.ccc;

import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] lista = sc.nextLine().split(" ");
		
		String mediadora = "";
		
		for(int i =0; i < lista.length - 1;) {
			mediadora = lista[i];
			lista[i] = lista[i+1];
			lista[i+1] = mediadora;
			i += 2;
		}
		
		System.out.println(Arrays.toString(lista));
	}
}
