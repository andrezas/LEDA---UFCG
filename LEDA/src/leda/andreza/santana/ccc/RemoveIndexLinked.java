package leda.andreza.santana.ccc;

import java.util.NoSuchElementException;
import java.util.Scanner;

class RemoveIndexLinked {
	
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

	  public RemoveIndexLinked() {
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

	  public int removeFirst() {

			if (isEmpty()) {
				throw new NoSuchElementException();
			}

			int aluno = this.head.value;

			if (this.head.next == null) { 
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.next;
				this.head.prev = null;
			}

			size -= 1;
			return aluno;
		}

		public int removeLast() {

			if (isEmpty()) {
				throw new NoSuchElementException();
			}

			int aluno = this.tail.value;

			if (this.head.next == null) { 
				this.head = null;
				this.tail = null;
			} else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}

			size -= 1;
			return aluno;

		}

		public int remove(int index) {
			if (index < 0 || index >= size) {
				throw new IndexOutOfBoundsException();
			}
			if (index == 0) {
				return removeFirst();
			}
			if (index == size - 1) {
				return removeLast();
			}

			Node aux = this.head;
			for (int i = 0; i < index; i++) {
				aux = aux.next;
			}

			aux.prev.next = aux.next;
			aux.next.prev = aux.prev;
			size -= 1;
			return aux.value;
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

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] seq = sc.nextLine().split(" ");
		int index = sc.nextInt();
		int[] seqInt = converteStrParaInt(seq);
		
		RemoveIndexLinked linkedList = new RemoveIndexLinked();
		
		for(int i =0; i < seqInt.length; i++) {
			linkedList.addLast(seqInt[i]);
		}
		
		linkedList.remove(index);
		System.out.println(linkedList.imprime().trim());
		
	}
	
	public static int[] converteStrParaInt(String[] sequencia) {
		int[] seqInteiros = new int[sequencia.length];
		for(int i =0; i < sequencia.length; i++) {
			seqInteiros[i] = Integer.parseInt(sequencia[i]);
		}
		return seqInteiros;
	}
}
