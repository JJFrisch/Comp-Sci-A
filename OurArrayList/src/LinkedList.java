import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedList<E> implements Iterable<Object> {
	Node head;
	Node tail;//not implemented
	
	public Iterator<Object> iterator() {
		ArrayList<Object> x = new ArrayList<Object>();
		Node current = head;
		while(current.next != null){
			x.add(current.date);
			current = current.next;
		}
        return x.iterator();
    }
	
	public void push(E data){
		 Node new_Node = new Node(data);
		 
		 new_Node.next = head;
		 new_Node.pre = null;
		 
		 if (head != null){
		     head.pre = new_Node;
		 }
		 
		 head = new_Node;
	}
	
	public <E> Object peek() {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		return head.getDate();
	}
	
	public void InsertAfter(Node preNode, E data){
		if (preNode == null) {
	        System.out.println("The given previous node cannot be NULL ");
	        return;
	    }
		
		Node newNode = new Node(data);
		newNode.next = preNode.next;
		newNode.pre = preNode;
		preNode.next = newNode;
		
		if(newNode.next != null){
			newNode.next.pre = newNode;
		}
		
	}
	
	public void addAtEnd(E data){
		Node newNode = new Node(data);
		Node last = head;
		newNode.next = null;
		newNode.pre = head;
		if (head == null) {
	        newNode.pre = null;
	        head = newNode;
	        return;
	    }
		while (last.next != null){
	        last = last.next;
		}
	    last.next = newNode;
	    newNode.pre = last;
	}
	
	public void insertBefore(Node nextNode, E data){
		if (nextNode == null) {
			throw new EmptyStackException();
	    }
		
		Node newNode = new Node(data);
		newNode.next = nextNode;
		newNode.pre = nextNode.pre;
		nextNode.pre = newNode;
		
		if(newNode.pre == null){
			head = newNode;
		}
		else{
			newNode.pre.next = newNode;
		}
	}
	
	public void deleteAt(Node node){
		if (node == null) {
	        System.out.println("The given node cannot be NULL ");
	        return;
	    }
		
		if(head == node){
			node.next.pre = null;
			head = node.next;
			return;
		}
		node.pre.next = node.next;
		node.next.pre = node.pre;
		
	}
	
	public void deleteAt(int pos){
		Node node = head;
		for(int i=0;i<pos;i++){
			node = node.next;
		}
		this.deleteAt(node);
	}
	
	public void insertAt(int pos, E data){
		Node node = head;
		for(int i=0;i<pos;i++){
			node = node.next;
		}
		if(node == null){
			System.out.println("Position is to high");
			return;
		}
		this.insertBefore(node, data);
	}
	
	public void attachTo(LinkedList ll){ //fuses them together with ll in the lead
		Node node = ll.head;
		while(node.next!=null){
			node = node.next;
		}
		Node newNode = node;
		newNode.next = head;
		head.pre = newNode;
		
		while(head.pre != null){
			head = head.pre;
		}
	}
	
	public void printFrom(Node node){
		Node last = null;
		while(node != null){
			System.out.print(node.date + " ");
            last = node;
            node = node.next;
		}
		System.out.println();
	}
	
	public void print(){
		Node current = head;
		while(current.next != null){
			System.out.print(current.date + " ");
			current = current.next;
		}
		System.out.print(current.date + " ");
		System.out.println();
	}
	
	
	public ArrayList<Object> toArrayList(){
		ArrayList<Object> x = new ArrayList<Object>();
		Node current = head;
		while(current.next != null){
			x.add(current.date);
			current = current.next;
		}
        return x;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
}
