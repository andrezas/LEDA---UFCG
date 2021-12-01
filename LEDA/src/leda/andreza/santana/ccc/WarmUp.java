package leda.andreza.santana.ccc;

import java.util.Scanner;

class WarmUp {
	 public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       
	       //Leitura do inteiro N que ir� multiplicar os demais valores
	       int numero = Integer.parseInt(sc.nextLine());
	       
	       //Leitura da sequencia de valores que ser�o multiplicados
	       String[] sequencia = sc.nextLine().split(" ");
	       
	       //Declara��o da vari�vel que ir� armazenar o valor final da multiplica��o
	       String produto = "";
	       
	       for(int i = 0; i < sequencia.length; i++) {
	    	   produto += Integer.toString((Integer.parseInt(sequencia[i]) * numero)) + " ";
	       }
	       
	       System.out.println(produto.trim());
	    }

}
