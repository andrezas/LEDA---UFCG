package leda.andreza.santana.ccc;

import java.util.Scanner;

class DoisSomam {
	public static void main (String[]  args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		int num = sc.nextInt();
		int conversao;
		int soma = 0;
		String resultado = "";
		boolean encontrouPar = false;
		
		for(String valor : sequencia) {
			conversao = Integer.parseInt(valor);
			if(encontrouPar == true) {
				break;
			}
			if(conversao < num) {
				for(String n : sequencia) {
					int auxiliar = Integer.parseInt(n);
					if(auxiliar != conversao) {
						soma = auxiliar + conversao;
						if (soma == num) {
							resultado += valor + " " + n;
							encontrouPar = true;
							break;
						}
					}
				}
			}
		}
		
		if(resultado.length() < 2) {
			System.out.println(-1);
		}else {
			System.out.println(resultado);
		}
	}
}
