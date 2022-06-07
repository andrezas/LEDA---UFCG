package leda.andreza.santana.ccc;

import java.util.Scanner;

class OrdenaPilhaInv {

	private int[] pilha;
    private int capacidade;
    private int topo;

    public OrdenaPilhaInv(int capacity) {
        this.capacidade = capacity;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public void push(int n) {
        this.topo += 1; 
        this.pilha[topo] = n;
    }
    
    public int pop() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        int valor_topo = this.pilha[topo];
        topo -= 1;
        return valor_topo; 
    }
    
    public int pop(int index, int capacity) {
		
		if (isEmpty())
			throw new RuntimeException("EmptyStackException");

		if(topo == index) { 
			int valor_topo = pilha[topo];
			topo -= 1;
			return valor_topo;
		}
		
		OrdenaPilhaInv aux = new OrdenaPilhaInv(capacity);
		
		int cont = size() - 1;
		
		while (cont > index) {
			
			int valor_topo = pilha[topo];
			topo -= 1;
			int elem = valor_topo;
			
			aux.push(elem);
			
			cont --;
		}
		
		int valor_topo = this.pilha[topo];
		topo -= 1;
		
		
		while(!aux.isEmpty()) {
			push((int) aux.pop());
		}
		
		return valor_topo;
    }

    public int peek() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        return this.pilha[topo];
    }
    
    public int size() {
    	return topo+1;
    }
    
    public int getMax() {
       // if (isEmpty()) throw new EmptyStackException();

        Pilha aux = new Pilha(this.size());
        int maior = this.peek();
        int indexMaior = 0;
        int cont = size()-1;
        while (!isEmpty()) {
            int elemento = this.pop();
            if (elemento>maior) {
                maior = elemento;
                indexMaior = cont;
            }
            aux.push(elemento);
            cont--;
        }

        while(!aux.isEmpty()) {
            this.push(aux.pop());
        }
         
        this.pop(indexMaior, this.size());
        return maior;
        
    }
    
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	int capacidade = sc.nextInt();
    	OrdenaPilhaInv pilha = new OrdenaPilhaInv(capacidade);
    	
    	for(int i =0; i < capacidade; i++) {
    		int element = sc.nextInt();
    		pilha.push(element);
    	}
    
    	int[] aux = new int[capacidade];
    	int cont = 0;
    	while(!pilha.isEmpty()) {
    		aux[cont] = pilha.getMax();
    		//System.out.println(Arrays.toString(pilha.pilha));
    		cont++;
    	}
    	//System.out.println(Arrays.toString(aux));
    	
    	// [24, 8, 2, 1, -1]
    	// -1, 1, 2, 8, 24
    	
    	for(int i = 0; i < pilha.pilha.length; i++) {
    		pilha.push(aux[i]);
    	}
    	
    	System.out.println("-");
    	while(!pilha.isEmpty()) {
    		System.out.println(pilha.pop());
    	}
    }
    
    public static void invertePilhaIndex(OrdenaPilhaInv pilha, int capacidade, int index) {
    	int cont = 0;
    	int[] aux = new int[index+1];
  
    	while(cont < index) {
    		aux[cont] = pilha.pop(); 
    		cont++;
    	}
    	
    	for(int i = 0; i < aux.length; i++) {
    		pilha.push(aux[i]); 
    	}
    }
}