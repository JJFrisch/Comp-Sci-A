public class Node {
	Object date;
	Node next;
	Node pre;
	
	public Node(Object d){
		date = d;
	}
	public Node(Object date, Node next, Node pre) {
		super();
		this.date = date;
		this.next = next;
		this.pre = pre;
	}
	public Object getDate() {
		return date;
	}
	public void setDate(Object date) {
		this.date = date;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPre() {
		return pre;
	}
	public void setPre(Node pre) {
		this.pre = pre;
	}
	@Override
	public String toString() {
		return "Node [date=" + date + ", next=" + next + ", pre=" + pre + "]";
	}

}