import java.util.ArrayList;

public class OurHM {
	
	public ArrayList<KeyValue>[] map;
	private final int SIZE = 1001981;
	private int currentSize = 0;
	
	@SuppressWarnings("unchecked")
	public OurHM() {
		map = (ArrayList<KeyValue>[]) new ArrayList[SIZE]; // 1091 is prime
		for(int k=0;k<map.length;k++) {
			map[k] = new ArrayList<KeyValue>();
		}
		
	}
	
	public String put(String key, String value) {
		int ind = Math.abs( key.hashCode())  % SIZE;
		for(int k=0;k<map[ind].size();k++) {
			if(map[ind].get(k).getKey().equals(key)) {
				String ret  = map[ind].get(k).getValue();
				map[ind].remove(k);
				map[ind].add(new KeyValue(key,value));
				return ret;
			}
		}
		currentSize++;
		map[ind].add(new KeyValue(key,value));
		return null;
	}

	public String get(String key) {
		int ind = Math.abs( key.hashCode())  % SIZE;
		for(int k=0;k<map[ind].size();k++) {
			if(map[ind].get(k).getKey().equals(key)) {
				return map[ind].get(k).getValue();
			}
		}
		return null;
	}
	
	public int getSize() {
		return currentSize;
	}
	
	public int numberOfKeys() {
		int num = 0;
		for(int k=0;k<map.length;k++) {
			num += map[k].size();
		}
		return num;
	}
	
	public void empty() {
		map = (ArrayList<KeyValue>[]) new ArrayList[SIZE]; // 1091 is prime
		for(int k=0;k<map.length;k++) {
			map[k] = new ArrayList<KeyValue>();
		}
		currentSize = 0;
	}
	
	public String toString() {
		String ret = "";
		for(int k=0;k<map.length;k++) {
			ret += (k + ": ");
			for(int p=0;p<map[k].size();p++) {
				ret += map[k].get(p);
			}
			ret += "\n";
		}
		return ret;
	}
	
	
}
