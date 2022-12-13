
public class TreeMapRunner {
	
	
	public static void main(String args[]) {
		Node n1 = new Node(new KeyValue("hello", "123"),null,null);
		Node n2 = new Node(new KeyValue("hello1", "345"),null,null);
		n1.setRight(n2);
		System.out.println(get("hello1", n1));
	}
	
	public static String get(String key, Node t) {
		KeyValue pair = t.getVal();
		if (pair.getKey().equals(key)) {
			return pair.getValue();
		}
		if (key.compareTo(pair.getKey()) < 0 && t.getLeft() != null) {
			return get(key, t.getLeft());
		}
		if (key.compareTo(pair.getKey()) > 0 && t.getRight() != null) {
			return get(key, t.getRight());
		}
		else {
			return null;
		}
	}
}
