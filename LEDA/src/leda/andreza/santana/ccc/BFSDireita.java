package leda.andreza.santana.ccc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class BFSDireita {

	// n? raiz
	private Node root;
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void addNo(int newElement) {
		if(isEmpty()) {
			this.root = new Node(newElement);
		}else {
			
			Node aux = this.root;
			
			while(aux != null) {
				if(newElement < aux.value) {
					if(aux.left == null) {
						Node newNode = new Node(newElement);
						aux.left = newNode;
						newNode.parent = aux;
						return;
					}
					
					aux = aux.left;
					
				}else {
					if(aux.right == null) {
						Node newNode = new Node(newElement);
						aux.right = newNode;
						newNode.parent = aux;
						return;
					}
					
					aux = aux.right;
				}
			}
		}
	}
	
	// busca os n?s em largura e retorna os valores em uma str
	public String searchInWidth() {
	    Deque<Node> queue = new LinkedList<Node>();
	    String result = "";
	        
	    if (!isEmpty()) {
	        queue.addLast(this.root);
	        while (!queue.isEmpty()) {
	            Node atual = queue.removeFirst();
	                
	            result += Integer.toString(atual.value) + " ";
	                
	            if(atual.right != null) 
	                queue.addLast(atual.right);
	            if(atual.left != null) 
	                queue.addLast(atual.left);   
	        }
	    }
	    
	    return result;
	}
	
	class Node{
		
		// valor do n?
		private int value;
		
		// n? a esquerda (predecessor)
		private Node left;
		
		// n? a direita (sucessor)
		private Node right;
		
		// n? pai
		private Node parent;
		
		public Node(int value) {
			this.value = value;		}
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		BFSDireita arvore = new BFSDireita();
		
		String[] entrada = sc.nextLine().split(" ");
		
		converteEAddNos(entrada, arvore);
		System.out.println(arvore.searchInWidth().trim());
		
	}
	
	/**
	 * converte os valores da entrada para int e adiciona n?s com tais valores na ?rvore
	 * 
	 * @param sequencia a sequencia de valores da entrada
	 * @param arvore a ?rvore que receber? os n?s
	 */
	public static void converteEAddNos(String[] sequencia, BFSDireita arvore) {
		for(int i =0; i < sequencia.length; i++) {
			arvore.addNo(Integer.parseInt(sequencia[i]));
		}
	}
	
}
