package leda.andreza.santana.ccc;

import java.util.Scanner;

public class BalanceBST {

	// nó raiz
		private Node root;
		private int size;
		
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
			this.size += 1;
		}
		
		public int height() {
			return height(this.root);	
		}
		
		public int height(Node no) {
			if(no == null) { return -1; }
			else {
				return 1 + Math.max(height(no.left), height(no.right));
			}
		}
		
		public int altura(Node no) {
			if(no == null) { return -1; }
			else {return 1 + Math.max(altura(no.left), altura(no.right)); }
		}
		
		private int balance(Node no) {
		    if (no != null) { return altura(no.left) - altura(no.right); }
		    return 0;
		}
		
		public String preOrder() {
		   return preOrder(this.root);
		}

		private String preOrder(Node node) {
		    if (node != null) {
		    	return node.value + "," + balance(node) + " " + preOrder(node.left) + preOrder(node.right);
		    }
		    return "";
		}
		
		class Node{
			
			// valor do nó
			private int value;
			
			// nó a esquerda (predecessor)
			private Node left;
			
			// nó a direita (sucessor)
			private Node right;
			
			// nó pai
			private Node parent;
			
			public Node(int value) {
				this.value = value;		}
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			BalanceBST bst = new BalanceBST();
			
			String[] entrada = sc.nextLine().split(" ");
			converteEAddNos(entrada, bst);
			System.out.println(bst.preOrder().trim());
		}
		
		public static void converteEAddNos(String[] sequencia, BalanceBST arvore) {
			for(int i =0; i < sequencia.length; i++) {
				arvore.addNo(Integer.parseInt(sequencia[i]));
			}
		}
	

}
