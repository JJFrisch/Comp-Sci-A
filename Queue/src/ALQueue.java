import java.util.ArrayList;

public class ALQueue implements Queue{

	private ArrayList<Object> vals = new ArrayList<Object>();  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enqueue(Object x) {
		// TODO Auto-generated method stub
		vals.add(x);
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		return vals.remove(vals.size()-1);
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return vals.size()<1;
	}

}
