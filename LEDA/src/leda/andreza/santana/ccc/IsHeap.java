package leda.andreza.santana.ccc;

import java.util.Arrays;
import java.util.Scanner;

class IsHeap {
	private int[] heap;
	
	// index do último elemento
	private int tail;
	
	public IsHeap(int capacity) {
		this.heap = new int[capacity];
		this.tail = -1;
	}
	
	public IsHeap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }
	
	public boolean isEmpty() {
		return this.tail == -1;
	}
	
	public int left(int indexNo) {
		return indexNo * 2 + 1;
	}
	
	public int right(int indexNo) {
		return 2 * (indexNo + 1);
	}
	
	public int parent(int indexNo) {
		return (indexNo-1)/2;
	}
	
	public void heapify(int index) {
		
		// verifica se o index é folha ou se é válido
		if (isLeaf(index) || !isValidIndex(index)) {
            return;}
		
		// compara o index com left e right pra determinar o maior deles
		int index_max = max_index(index, left(index), right(index));
	
		// se o maxIndex for o próprio index o algoritmo para
		// se o caso anterior não se aplica, ocorre uma troca entre o index e o indexMax
		if (index_max != index) {
            swap(index, index_max);
            heapify(index_max);
		}
		
	}
	
	 private int max_index(int index, int left, int right) {
	        if (this.heap[index] > this.heap[left]) {
	            if (isValidIndex(right)) {
	                if (this.heap[index] < this.heap[right]) {
	                    return right;}
	            }
	           
	            return index;
	        
	        } else {
	            if (isValidIndex(right)) {
	                if (this.heap[left] < this.heap[right]) {
	                    return right;}
	            } 
	            
	            return left;
	        }
	    }

	    private boolean isValidIndex(int index) {
	        return index >= 0 && index <= tail;
	    }
	    
	    private boolean isLeaf(int index) {
	        return index > parent(tail) && index <= tail;
	    } 
	    
	    private void swap(int i, int j) {
	        int aux = this.heap[i];
	        this.heap[i] = this.heap[j];
	        this.heap[j] = aux;
	    }
	    
	    private void buildHeap() {
	        for (int i = parent(this.tail); i >= 0; i--) {
	            heapify(i); }
	    }
	    
	    public String imprime() {
	    	String result = "";
	    	for(int i =0; i < this.heap.length; i++) {
	    		result += Integer.toString(heap[i]);
	    	}
	    	return result.trim();
	    }
	    
	    
	    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	
	    	String[] entrada = sc.nextLine().split(" ");
	    	IsHeap heapVerificador = new IsHeap(converteStrEmInt(entrada));
	    	System.out.println(verificaIsHeap(converteStrEmInt(entrada), heapVerificador.imprime()));
	    
	    }
	    
	    public static int[] converteStrEmInt(String[] sequencia) {
			int[] heap = new int[sequencia.length];
			for(int i =0; i < sequencia.length; i++) {
				heap[i] = Integer.parseInt(sequencia[i]);
			}
			return heap;
		}
	    
	    public static boolean verificaIsHeap(int[] entrada, String buildHeap) {
	    	String input = "";
	    	for(int i = 0; i < entrada.length; i++) {
	    		input += Integer.toString(entrada[i]);
	    	}
	    	return input.trim().equals(buildHeap);
	    }

}
