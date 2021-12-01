package leda.andreza.santana.ccc;

import java.util.Scanner;

class StopWords {
	
	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Entrada
		String[] texto = sc.nextLine().split(" ");
		String[] stopWords = sc.nextLine().split(" ");
	
		String resultado = "";
		
		for (String palavra : texto) {
			if (verificaEhStopWord(palavra, stopWords) == false) {
				resultado += palavra + " ";
			}
		}
		
		System.out.println(resultado.trim());
	}
	
	/**
	 * Método auxiliar que verifica se uma palavra é uma stopWord.
	 * 
	 * @param palavra: a palavra que será verificada.
	 * @param palavras: a lista de stopWords que serão comparadas à palavra.
	 * @return true caso a palavra seja uma stopWord e, caso contrário, false.
	 */
	private static boolean verificaEhStopWord(String palavra, String[] palavras) {
		for(String stopWord : palavras) {
			if(palavra.equals(stopWord)) {
				return true;
			}
		}
		return false;
	}
}
