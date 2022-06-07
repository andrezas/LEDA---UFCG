package leda.andreza.santana.ccc;

import java.util.Arrays;
import java.util.Scanner;

class RadixSortDoisD {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		int d = sc.nextInt();
		
		radixSort(converteStrParaInt(sequencia), d);
	}

	public static int[] CoutingSort(int[] array, int quantDig) {
		//array de contagem
		int[] cont = new int[99];
		
		// calculando a frequencia dos d�gitos
		for (int i = 0; i < array.length; i++) {
			int digitos = (int) (array[i] % Math.pow(100, quantDig));
			digitos = (int) (digitos / Math.pow(100, quantDig - 1));
			cont[digitos - 1] += 1;
		}
		
		// realizando a cumulativa 
		for (int i = 1; i < cont.length; i++)
			cont[i] += cont[i-1];
		
		int[] arrayOrd = new int[array.length]; // array auxiliar para ordenar os valores do array original
		for (int i = array.length - 1; i >=0; i--) {
			int dig = (int) (array[i] % Math.pow(100, quantDig));
			dig = (int) (dig / Math.pow(100, quantDig - 1));
					arrayOrd[cont[dig - 1] - 1] = array[i];
			cont[dig - 1] -= 1;
			
		}
		
		return arrayOrd;
		
	}
	
	public static int[] radixSort(int[] array, int d) {
		/**
		 * O d (quantidade de d�gitos dos n�meros) ser� dividido por 2, porque os digitos est�o sendo ordenados 2 a 2.
		 * Caso n�o ocorresse essa divis�o o Radix seria executado d vezes, mas como a ordena��o � feita por par d�gitos
		 * e considerando que d sempre ser� par, ent�o o Radix ser� executado (d/2) vezes.
		 */
		for (int i = 1; i <= (d/2); i++) { 
			array = CoutingSort(array, i);
			System.out.println(Arrays.toString(array));
		}
		return array;
		
	}
	
	public static int[] converteStrParaInt(String[] sequencia) {
		int[] seqInteiros = new int[sequencia.length];
		for(int i =0; i < sequencia.length; i++) {
			seqInteiros[i] = Integer.parseInt(sequencia[i]);
		}
		return seqInteiros;
	}
	
}
