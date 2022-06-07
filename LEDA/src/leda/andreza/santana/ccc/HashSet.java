package leda.andreza.santana.ccc;

import java.util.Arrays;
import java.util.Scanner;

class HashSet {
	
	public static final int CAPACIDADE_DEFAULT = 20;
	private String[] tabela;
	private int size;
	
	public HashSet() {
		this.tabela = new String[CAPACIDADE_DEFAULT];
	}
	
	public HashSet(int tamanho) {
		this.tabela = new String[tamanho];
		this.size = 0;
	}
	
	private int funcHash(int valor) {
		return valor % this.tabela.length;
	}
	
	public int size() {
		return size;
	}
	
	public void put(int valor) {
		int sondagem = 0;
	    int hash;
	    while (sondagem < tabela.length) {
	        
	        hash = (funcHash(valor) + sondagem) % tabela.length;
	        
	        if(contains(valor) == true) {
				return;
			}
	            
	        if (tabela[hash] == null ||
	        	tabela[hash].equals(Integer.toString(valor))) {
	                tabela[hash] = Integer.toString(valor);
	                size += 1;
	                return;
	        }   
	        sondagem += 1;
	        
	    }

	}
	
	public void remove(int valor) {
		int sondagem = 0;
		int hash;
		while (sondagem < tabela.length) {
			hash = (funcHash(valor) + sondagem) % tabela.length;

			if (tabela[hash] != null &&
		        tabela[hash].equals(Integer.toString(valor))) {
				tabela[hash] = null;
				this.size -= 1;
				return;
			}

			sondagem += 1;

		}

		return;
	}
	
	public boolean contains(int valor) {
		for(int i=0; i < tabela.length; i++) {
			if(tabela[i] != null && Integer.toString(valor).equals(tabela[i])) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = sc.nextInt();
		HashSet hash = new HashSet(tamanho);
		
		String[] entrada = sc.nextLine().split(" ");
		while (true) {
			if(entrada[0].equals("end")) {
				break;
			}
			switch(entrada[0]) {
				case "put":
					hash.put(Integer.parseInt(entrada[1]));
					System.out.println(Arrays.toString(hash.tabela));
					break;
				case "remove":
					hash.remove(Integer.parseInt(entrada[1]));
					System.out.println(Arrays.toString(hash.tabela));
					break;
				case "contains":
					System.out.println(hash.contains(Integer.parseInt(entrada[1])));
					break;
			}
			
			entrada = sc.nextLine().split(" ");
		}
		
	}
}
