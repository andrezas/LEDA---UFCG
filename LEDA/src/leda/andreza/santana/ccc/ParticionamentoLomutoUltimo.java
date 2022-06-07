package leda.andreza.santana.ccc;

import java.util.Arrays;
import java.util.Scanner;

class ParticionamentoLomutoUltimo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		partition(sequencia, 0, sequencia.length-1);
		System.out.println(Arrays.toString(sequencia));
	}
	
	public static void partition(String[] values, int left, int right) {
        
        int pivot = Integer.parseInt(values[right]);
        int i = right;

		// coloca os elementos > pivot à sua direita.
        for (int j = right - 1; j >= left; j--) {
            if (Integer.parseInt(values[j]) >= pivot) {
                i-=1;
                swap(values, i, j);
                System.out.println(Arrays.toString(values));
            }
        }

        // troca pivot (values[right]) com i.
        swap(values, right, i);
        System.out.println(Arrays.toString(values));
    }
    
    // troca a posição entre dois elementos em um array.
    public static void swap(String[] values, int x, int y){
      int aux = Integer.parseInt(values[x]);
      values[x] = values[y];
      values[y] = Integer.toString(aux);
    }

}
