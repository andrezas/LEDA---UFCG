package leda.andreza.santana.ccc;

import java.util.Scanner;

class TopN {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		String[] sequencia = sc.nextLine().split(" ");
		int n = sc.nextInt();
		
		String maiores = "";
		int cont = 0;
		
		for (int i = 1; i < sequencia.length; i++) { 
			
			int j = i;
		
			while (j > 0 && Integer.parseInt(sequencia[j]) < Integer.parseInt(sequencia[j-1])){
				int aux = Integer.parseInt(sequencia[j]);
				sequencia[j] = sequencia[j - 1];
				sequencia[j - 1] = Integer.toString(aux);
				j -= 1;
			}
		}
		
		int x = sequencia.length-1;
		while(cont < n) {
			maiores += sequencia[x] + " "; 
			x -= 1;
			cont += 1;
				
			}
		
		System.out.println(maiores.trim());
		
	}
}
