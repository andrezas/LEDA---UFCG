package leda.andreza.santana.ccc;

import java.util.Scanner;

class Pilha {
	
	private int[] pilha;
    private int capacidade;
    private int topo;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
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


    public static void main(String [] args) {
    	Scanner sc = new Scanner(System.in);
	
    	int capacidade = sc.nextInt();
    	Pilha pilha = new Pilha(capacidade);
    	
    	for(int n = 0; n < capacidade; n++) {
    		int e = sc.nextInt();
    		pilha.push(e);	
    	}
    	
    	invertePilha(pilha, capacidade);
    }
    
    public static void invertePilha(Pilha pilha, int capacidade) {
    	Pilha aux = new Pilha(capacidade);
    	while(!pilha.isEmpty()) {
    		aux.push(pilha.pop());
    	}
    	
    	while(!aux.isEmpty()) {
    		System.out.println(aux.pop());
    	}
    }
}


