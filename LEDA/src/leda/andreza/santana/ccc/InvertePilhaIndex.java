package leda.andreza.santana.ccc;

import java.util.Scanner;

class InvertePilhaIndex {
	private int[] pilha;
    private int capacidade;
    private int topo;

    public InvertePilhaIndex(int capacity) {
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

    public int peek() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        return this.pilha[topo];
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int capacidade = sc.nextInt();
    	InvertePilhaIndex pilha = new InvertePilhaIndex(capacidade);
    	
    	for(int i =0; i < capacidade; i++) {
    		int element = sc.nextInt();
    		pilha.push(element);
    	}
    	int index = sc.nextInt();
    	invertePilhaIndex(pilha, capacidade, index);
    }
    
    public static void invertePilhaIndex(InvertePilhaIndex pilha, int capacidade, int index) {
    	System.out.println("-");
    	int cont = 0;
    	int[] aux = new int[index+1];
  
    	while(cont <= index) {
    		aux[cont] = pilha.pop();
    		cont++;
    	}
    	
    	for(int i = 0; i < aux.length; i++) {
    		pilha.push(aux[i]);
    	}
    	
    	while(!pilha.isEmpty()) {
    		System.out.println(pilha.pop());
    	}
    }

}
