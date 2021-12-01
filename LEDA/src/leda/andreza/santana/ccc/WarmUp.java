package leda.andreza.santana.ccc;

import java.util.Scanner;

class WarmUp {
	 public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       
	       //Leitura do inteiro N que irá multiplicar os demais valores
	       int numero = Integer.parseInt(sc.nextLine());
	       
	       //Leitura da sequencia de valores que serão multiplicados
	       String[] sequencia = sc.nextLine().split(" ");
	       
	       //Declaração da variável que irá armazenar o valor final da multiplicação
	       String produto = "";
	       
	       for(int i = 0; i < sequencia.length; i++) {
	    	   produto += Integer.toString((Integer.parseInt(sequencia[i]) * numero)) + " ";
	       }
	       
	       System.out.println(produto.trim());
	    }

}
