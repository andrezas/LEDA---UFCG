package leda.andreza.santana.ccc;

import java.util.HashMap;
import java.util.Scanner;

class WordCloud {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, Integer> mapaWords = new HashMap<String, Integer>();
		
		String[] entrada = sc.nextLine().split(" ");
		
		for(String palavra : entrada) {
			if(mapaWords.containsKey(palavra)) {
				mapaWords.put(palavra, mapaWords.get(palavra)+1);
			}else {
				mapaWords.put(palavra, 1);
			}
		}
		
		String operacao = sc.next();
		while(true) {
			if(operacao.equals("fim")) {
				break;
			}
			System.out.println(mapaWords.get(operacao));
			operacao = sc.next();
		}
	}

}
