package leda.andreza.santana.ccc;

import java.util.Scanner;

class VetorCircular {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		
		int numero = sc.nextInt();
		
		int cont = 0;
		int contAuxiliar = 0;
		
		String elementos = "";
		
		while(contAuxiliar < numero) {
			if(cont == sequencia.length) {
				cont = 0;
			}
			elementos += sequencia[cont] + " ";
			cont++;
			contAuxiliar++;
		}
		
		System.out.println(elementos.trim());
	}

}
