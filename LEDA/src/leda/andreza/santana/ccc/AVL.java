package leda.andreza.santana.ccc;

import java.util.Arrays;
import java.util.Scanner;


class AVL {
	
	private Node root;
	private int size;
	
	class Node{
		
		Node left;
		Node right;
		Node parent;
		int h;
		int value;
		
		public Node(int value) { this.value = value; }
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public int getRoot() {
		return this.root.value;
	}
	
	public int size() {
		return this.size;
	}
	
	public String preOrder() {
	    return preOrder(this.root);
	}

	private String preOrder(Node node) {
	    if (node != null) {
	    	return node.value +  " " + preOrder(node.left) + preOrder(node.right);
	    }
	    return "";
	}
	
	public boolean isLeftPending(Node no) {
		return altura(no.left) - altura(no.right) == 1;
	}
	
	public boolean isRightPending(Node no) {
		return altura(no.left) - altura(no.right) == -1;
	}
	public boolean isBalanced(Node no) {
		return altura(no.left) - altura(no.right) == 0;
	}

	
	private int balance(Node no) {
	    if (no != null) { return altura(no.left) - altura(no.right); }
	    return 0;
	}
	
	public int altura(Node no) {
		if(no == null) { return -1; }
		else {return 1 + Math.max(altura(no.left), altura(no.right)); }
	}
	
	public void rotateRight(Node x) {
		Node pivot = x.left;

		if(x.value == root.value) {root = pivot;}
		
		x.left = pivot.right; 
		pivot.right = x;

		pivot.parent = x.parent;
		x.parent = pivot; 

		if(x.left != null) {x.left.parent = x;}
		
		if(pivot.parent != null) {
			if (pivot.parent.left == x) { pivot.parent.left = pivot; }
			else { pivot.parent.right = pivot; }
		}
		System.out.println("rot_dir(" + x.value + ")" + "\n" + Arrays.toString(preOrder().split(" ")));
         
	}
	
	public void rotateLeft(Node x) {
		Node pivot = x.right;
		
		if(x.value == root.value) {root = pivot;}
	
		x.right = pivot.left; 
		pivot.left = x;

		pivot.parent = x.parent; 
		x.parent = pivot; 

		if(x.left != null) {x.right.parent = x;}
		
		if(pivot.parent != null) {
			if ( pivot.parent.right == x) { pivot.parent.right = pivot; }
			else { pivot.parent.left = pivot; }
		}
		System.out.println("rot_esq(" + x.value + ")" + "\n" + Arrays.toString(preOrder().split(" ")));
	}
	
	public void insertRecursive(int newElement) {
		if (this.isEmpty()) {
			this.root = new Node(newElement);
		} else {
			this.insertRecursive(this.root, newElement);
		}
		
		this.size += 1;
	}
	
	private void insertRecursive(Node node, int newElement) {
		if (newElement < node.value) {
			if (node.left == null) {
				Node newNode = new Node(newElement);
				node.left = newNode;
				newNode.parent = node;
				return;
			}
			this.insertRecursive(node.left, newElement);
		} else {
			if (node.right == null) {
				Node newNode = new Node(newElement);
				node.right = newNode;
				newNode.parent = node;
				return;
			}
			this.insertRecursive(node.right, newElement);
		}
		
		this.rebalance(node, newElement);
	}
         
	
	private void rebalance(Node no, int value) {
		if(no == null) { return; }
		
		int balance = balance(no);
		
		if(balance < -1) {
			if(value > no.right.value) {
				rotateLeft(no);
			}else {
				rotateRight(no.right);
				rotateLeft(no);
			}
		}else if(balance > 1) {
			if(value < no.left.value) {
				rotateRight(no);
			}else {
				rotateLeft(no.left);
				rotateRight(no);
			}
		}
		
	}
	
	public boolean ehBalanceada(int value) {
		return value == getRoot();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AVL avl = new AVL();
		
		String[] entrada = sc.nextLine().split(" ");
		
		converteEAddNos(entrada, avl);
		
		if(avl.ehBalanceada(Integer.parseInt(entrada[0])) == true) { System.out.println("balanceada");}
		
	}
	
	public static void converteEAddNos(String[] sequencia, AVL arvore) {
		for(int i =0; i < sequencia.length; i++) {
			arvore.insertRecursive(Integer.parseInt(sequencia[i]));
		}
	}
}
