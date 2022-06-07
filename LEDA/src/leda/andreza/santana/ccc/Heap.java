package leda.andreza.santana.ccc;

import java.awt.image.RescaleOp;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import com.sun.net.httpserver.Authenticator.Result;

class Heap {
	
	private int[] heap;
	
	// index do último elemento
	private int tail;
	
	public Heap(int capacity) {
		this.heap = new int[capacity];
		this.tail = -1;
	}
	
	public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }
	
	public boolean isEmpty() {
		return this.tail == -1;
	}

	// nó a esquerda do nó passado
	public int left(int indexNo) {
		return indexNo * 2 + 1;
	}
	
	// nó a direita do nó passado
	public int right(int indexNo) {
		return 2 * (indexNo + 1);
	}
	
	// nó pai do nó passado
	public int parent(int indexNo) {
		return (indexNo-1)/2;
	}
	
	public void addNo(int value) {
		if (tail >= this.heap.length -1)
			resize();
		
		this.tail += 1;
		this.heap[tail] = value;
		
		int i = this.tail;
	    while (i > 0 && this.heap[parent(i)] < this.heap[i]) {
	        int aux = this.heap[i];
	        this.heap[i] = this.heap[parent(i)];
	        this.heap[parent(i)] = aux;
	        i = parent(i);
	    }
	}
	
	public int remove() {
		if(isEmpty()) throw new RuntimeException("Heap vazia!");
		
		int elementRemovido = this.heap[0];
		this.heap[0] = this.heap[tail];
		this.tail -= 1;
		
		heapify(0);
		
		return elementRemovido;
	}
	
	public void heapify(int index) {
		
		// verifica se o index é folha ou se é válido
		if (isLeaf(index) || !isValidIndex(index)) 
            return;
		
		// compara o index com left e right pra determinar o maior deles
		int index_max = max_index(index, left(index), right(index));
	
		// se o maxIndex for o próprio index o algoritmo para
		// se o caso anterior não se aplica, ocorre uma troca entre o index e o indexMax
		if (index_max != index) 
            swap(index, index_max);
            heapify(index_max);
		
	}
	
	 private int max_index(int index, int left, int right) {
	        if (this.heap[index] > this.heap[left]) {
	            if (isValidIndex(right)) {
	                if (this.heap[index] < this.heap[right])
	                    return right;
	            }
	           
	            return index;
	        
	        } else {
	            if (isValidIndex(right)) {
	                if (this.heap[left] < this.heap[right])
	                    return right;
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
	        for (int i = parent(this.tail); i >= 0; i--)
	            heapify(i); 
	    }
	
	public void resize() {
		// igual ao de arrayList
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tamanho = sc.nextInt();
		Heap heap = new Heap(tamanho);
		
		for(int i = 0; i < tamanho; i++) {
			int valor = sc.nextInt();
			heap.addNo(valor);
		}
		
		String resultado = "";
		for(int j=0; j < heap.heap.length; j++) {
			resultado += Integer.toString(heap.heap[j]) + " ";
		}
		
		System.out.println(resultado.trim());
	}
}
