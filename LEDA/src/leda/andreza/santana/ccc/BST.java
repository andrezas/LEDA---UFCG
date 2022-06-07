package leda.andreza.santana.ccc;

class BST {

	// nó raiz
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
	
	public Node search(int element) {
		Node aux = this.root;
		
		while(aux != null) {
			if(aux.value == element) {return aux;}
			if(aux.value > element) {aux = aux.left; }
			if(aux.value < element) {aux = aux.right; }
		}
		
		return null;
	}
	
	public Node min() {
	    if (isEmpty()) { return null; }
	    return min(this.root);
	}
	    
	private Node min(Node no) {
	    if (no.left == null) { return no; }
	    else { return min(no.left); }
	}
	
	
	
	public Node max() {
	    if (isEmpty()) { return null; }
	    return max(this.root);
	}
	
	private Node max(Node no) {
		if(no.right == null) { return no; }
		else { return max(no.right); }
	}
	
	public Node sucessor(Node no) {
		if(no == null) {return null; }
		
		if (no.right != null) {
			return min(no.right);
		}else {
			Node aux = no.parent;
			
			while(aux != null && aux.value < no.value) {
				aux = aux.parent;
			}
			
			return aux;
		}
	}
	
	public Node predecessor(Node no) {
		if(no == null) { return null; }
		
		if(no.left != null) { return max(no.left); }
		
		else {
			Node aux = no.parent;
			
			while(aux != null && aux.value > no.value) {
				aux = aux.parent;
			}
			
			return aux;
		}
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
}
