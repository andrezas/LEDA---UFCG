package leda.andreza.santana.ccc;

import java.util.NoSuchElementException;
import java.util.Scanner;

class TrocaVizinhosLinked {
	class Node {

		int value;
		Node next;
		Node prev;

		public Node(int value) {
			this.value = value;
			this.prev = null;
			this.next = null;
		}
		
	}

  private Node head;
  private Node tail;
  private int size;

  public TrocaVizinhosLinked() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

  public boolean isEmpty() {
		return this.head == null;
	}

  public void addLast(int value) {
		Node newNode = new Node(value);

		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			newNode.prev = tail;
			this.tail = newNode;
		}

		this.size += 1;
	}

  public int remove() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int valor = this.head.value;

		if (this.head.next == null) { 
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
			this.head.prev = null;
		}

		size -= 1;
		return valor;
	}

  public String element() {
		if (this.isEmpty()) {
			return "empty";
		}

		return Integer.toString(this.head.value);
	}
  	
	public int busca(int value) {
		Node aux = this.head;
		int index = 0;
		while (aux != null) {
			if (aux.value == value) {
				return index;
			}
			aux = aux.next;
			index += 1;
		}

		return -1;
	}

  public String imprime(){
    if (this.isEmpty()) {
			return "empty";
		}
    String toString = "";

    Node aux = this.head;

		while (aux != null) {
      toString += Integer.toString(aux.value) + " ";
			aux = aux.next;

		}
    return toString;
  }
  
  public void trocaVizinhos(int index) {
	  
	  Node troca = getNode(index-1); // 13
	  Node vizinho = getNode(index); // 3
	  
	  if (index < 0 || index > size)
	        throw new IndexOutOfBoundsException();
	  if(index == 0) {
		  
		// 1 13 3 4 5
		  troca.next = vizinho.next;
		  troca.next.prev = troca;
		  troca.prev = vizinho;
		  vizinho.next = troca;
		  
		  this.head = vizinho;
	  }
	  else if(index == size-2) {
		  
		// 1 13 3 4 5
		  troca.next = vizinho.next;
		  vizinho.prev = troca.prev;
		  vizinho.prev.next = vizinho;
		  troca.prev = vizinho;
		  vizinho.next = troca;
		  
		  this.tail = vizinho;
	  } else {
	 
	  // 1 13 3 4 5
	  vizinho.next.prev = troca; // 13 <-prev 4
	  troca.prev.next = vizinho; // 1 next-> 3
	  troca.next = vizinho.next; // 13 next-> 4
	  vizinho.next = troca; // 3 next-> 13
	  vizinho.prev = troca.prev; // 1 <- prev 3
	  troca.prev = vizinho; // 3 <- prev 13
	  }
  }
  
  public Node getNode(int index) {
	  Node no = this.head;
	  for (int i = 0; i <= index; i++) {
			 no = no.next;
	  }
	  return no;
  }

  public static void main(String [] args) {
	Scanner sc = new Scanner(System.in);
	
	String[] seq = sc.nextLine().split(" ");
	int index = sc.nextInt();
	TrocaVizinhosLinked linkedList = new TrocaVizinhosLinked();
	
	for(int i=0; i < seq.length; i++) {
		linkedList.addLast(Integer.parseInt(seq[i]));
	}
	
	linkedList.trocaVizinhos(index);
	System.out.println(linkedList.imprime().trim());
  }
}

