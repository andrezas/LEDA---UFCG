package leda.andreza.santana.ccc;

import java.util.Scanner;

class Parenteses {

	private String[] pilha;
    private int capacidade;
    private int topo;

    public Parenteses(int capacidade) {
        this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new String[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public void push(String valor) {
        this.topo += 1;
        this.pilha[topo] = valor;
    }
    
    public String pop() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        String valor_topo = this.pilha[topo];
        topo -= 1;
        return valor_topo; 
    }

    public String peek() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        return this.pilha[topo];
    }
    
    public static void main(String[]  args) {
    	Scanner sc = new Scanner(System.in);
    	String[] entrada = sc.nextLine().split("");
    	try {
    		System.out.println(verificaParenteses(entrada));
    	}catch(Exception e) {
    		System.out.println("N");
    	}
    	
    }
    
    public static String verificaParenteses(String[] entrada ) {
    	Parenteses pilha = new Parenteses(entrada.length);
    	int cont = 0;
    	
    	
    	for(int i=0; i<entrada.length; i++) {
    		if(entrada[i].equals("(")) {
    			pilha.push(entrada[i]);
    		}else if(entrada[i].equals(")")) {
    			pilha.pop();
    		}
    	}
    	return "S";
    }
}
