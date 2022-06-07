package leda.andreza.santana.ccc;

import java.util.Scanner;

class BuscaBinariaRecursiva {

public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		
		int numBuscado = sc.nextInt();
		
		int inicioSeq = 0;
		int fimSeq = sequencia.length-1;
		
		System.out.println(buscaBinaria(sequencia, numBuscado, inicioSeq, fimSeq));
		

	}

	public static int buscaBinaria(String[] seq, int n, int inicio, int fim) {
		if(inicio <= fim) {
			int meio = (inicio+fim)/2;
			
			if(Integer.parseInt(seq[meio]) == n) {
				return meio;
			}
			
			System.out.println(meio);
			
			if(n < Integer.parseInt(seq[meio])){
				return buscaBinaria(seq, n, inicio, meio-1);
			}
			
			else {
				return buscaBinaria(seq, n, meio+1, fim);
			}
		}
		else {
			return -1;
		}
	}
}
