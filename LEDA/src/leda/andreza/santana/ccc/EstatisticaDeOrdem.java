package leda.andreza.santana.ccc;

import java.util.Scanner;

class EstatisticaDeOrdem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		System.out.println(partition(sequencia, 0, sequencia.length-1));
	}
	
	
	public static int partition(String[] values, int left, int right) {
        
        int pivot = Integer.parseInt(values[left]);
        int i = left;

		// coloca os elementos < pivot à sua direita.
        for (int j = left + 1; j <= right; j++) {
            if (Integer.parseInt(values[j]) <= pivot) {
                i+=1;
                swap(values, i, j);
            }
        }

        // troca pivot (values[left]) com i.
        swap(values, left, i);
        
        return i+1; 
    }
    
    // troca a posição entre dois elementos em um array.
    public static void swap(String[] values, int x, int y){
      int aux = Integer.parseInt(values[x]);
      values[x] = values[y];
      values[y] = Integer.toString(aux);
    }
}
