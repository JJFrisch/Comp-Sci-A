import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AL implements Iterable<Object>{
	private Object[] vals;
	private int pos;
	
	public Iterator<Object> iterator() {
		ArrayList<Object> x = new ArrayList<Object>();
		for(int i=0;i<pos;i++){
			x.add(vals[i]);
		}
        return x.iterator();
    }

	
	public AL() {
		vals = new Object[10];
		pos = 0;
	}
	
	public AL(int num) {
		if(num<0){
			throw new IllegalArgumentException();
		}
		vals = new Object[num];
		pos = 0;
	}
	
	public AL(Object[] x) {
		if(x==null){
			throw new NullPointerException();
		}
		vals = new Object[x.length];
		for(int i=0;i<x.length;i++){
			add(i, (Object)x[i]);
		}
	}
	
	public int size(){
		return pos;
	}
	
	public boolean add(Object x){
		if(pos > vals.length-1){
			increaseSize();
		}
		vals[pos] = x;
		pos++;
		return true;
	}
	
	public void add(int index, Object x){
		if(index < 0 || index > pos){
			throw new IndexOutOfBoundsException();
		}
		if(pos >= vals.length-1){
			increaseSize();
		}
		pos++;
		for(int i=pos;i>index;i--){
			vals[i] = vals[i-1];
		}
		vals[index] = x;
	}
	
	public Object remove(int index){
		if(index < 0 || index >= pos){
			throw new IndexOutOfBoundsException();
		}
		Object toReturn = vals[index];
		for(int i=index;i<pos;i++){
			vals[i] = vals[i+1];
		}
		vals[pos] = null;
		pos--;
		return toReturn;
	}
	
	public boolean removeObj(Object x){
		for(int i=0;i<pos;i++){
			if(x == vals[i]){
				remove(i);
				return true;
			}
		}
		return false;
		
	}
	
	public Object get(int index){
		if(index < 0 || index >= pos){
			throw new IndexOutOfBoundsException();
		}
		return vals[index];
	}
	
	public Object set(int index, Object x){
		if(index < 0 || index >= pos){
			throw new IndexOutOfBoundsException();
		}
		Object old = vals[index];
		vals[index] = x;
		return old;
	}
	
	private void increaseSize(){
//		System.out.println("Size Up");
		Object[] arr = new Object[vals.length*2];
		for(int i=0;i<pos;i++){
			arr[i] = vals[i];
		}
		vals = arr;
	}
	
	public void fitSize(){
		Object[] arr = new Object[pos];
		for(int i=0;i<pos;i++){
			arr[i] = vals[i];
		}
		vals = arr;
	}
	
	public Object[] toArray(){
		Object[] arr = new Object[pos];
		for(int i=0;i<pos;i++){
			arr[i] = vals[i];
		}
		return arr;
	}
	
	public boolean contains(Object o){
		for(int i=0;i<pos;i++){
			if(o == vals[i]){
				return true;
			}
		}
		return false;
	}
	
	public void addAll(Object[] o){
		if(o==null){
			throw new NullPointerException();
		}
		for(int i=0;i<o.length;i++){
			add(o[i]);
		}
	}
	
	public String toString(){
		String arr = "[";
		for(int i=0;i<pos-1;i++){
			arr += (String)vals[i] + ", ";
		}
		arr += (String)vals[pos-1] + "]";
		return arr;
	}
	
	public void addAll(int index, Object[] o){
		if(index < 0 || index >= pos){
			throw new IndexOutOfBoundsException();
		}
		if(o==null){
			throw new NullPointerException();
		}
		for(int i=0;i<o.length;i++){
			add(index+i, o[i]);
		}
	}
	
	public void removeRange(int fromIndex, int toIndex){
		if(fromIndex < 0 || fromIndex >= pos){
			throw new IndexOutOfBoundsException();
		}
		if(toIndex < 0 || toIndex >= pos){
			throw new IndexOutOfBoundsException();
		}
		for(int i=fromIndex;i<=toIndex;i++){
			remove(fromIndex);
			
		}
	}
	
	public boolean removeAll(Object[] o){
		if(o==null){
			throw new NullPointerException();
		}
		boolean changed = false;
		for(int i=0;i<o.length;i++){
			if(removeObj(o[i])){
				changed = true;
				i--;
			}
		}
		return changed;
	}
	
	public boolean retainAll(Object[] o){
		if(o==null){
			throw new NullPointerException();
		}
		boolean changed = false;
		for(int i=0;i<pos;i++){
			boolean found = false;
			for(int k=0;k<o.length;k++){
				if(vals[i] == o[k]){
					found = true;
				}
			}
			if(!found){
				remove(i);
				changed = true;
			}
		}
		return changed;
	}
		
	
	
	public boolean isEmpty(){
		return pos==0;
	}
	
	public void print(){
		System.out.print("[");
		if(pos>0){
		for(int i=0;i<pos-1;i++){
			System.out.print(vals[i] + " ");
		}
		System.out.println(vals[pos-1] + "]");
		}
		else{
			System.out.println("]");
		}
	}
	
	public void clear(){
		vals = new Object[10];
		pos = 0;
	}
	
	@SuppressWarnings("null")
	public int indexOf(Object o){
		for(int i=0;i<pos;i++){
			if(o == vals[i]){
				return i;
			}
		}
		return (Integer) null;
	}
	
	@SuppressWarnings("null")
	public int lastIndexOf(Object o){
		for(int i=pos;i>=0;i--){
			if(o == vals[i]){
				return i;
			}
		}
		return (Integer) null;
	}
	
	public void replaceAll(Object find, Object replaceWith){
		for(int i=0;i<pos;i++){
			if(find == vals[i]){
				vals[i] = replaceWith;
			}
		}
	}
	
	public void sortInt(){
		int[] arr = new int[pos];
		for(int i=0;i<pos;i++){
			arr[i] = (int) vals[i];
		}
		int[] vals1 = sorting(arr,0,pos-1);
		for(int i=0;i<pos;i++){
			vals[i] = (Object) vals1[i];
		}
	}
	
	public int[] sorting(int[] arr, int s, int f){
		if (s < f){
			int m = (s+f)/2;
			
			sorting(arr, s, m);
			sorting(arr, m+1, f);
			
			int[] sortedArr = merge(arr, s, m, f);
			
			for (int i=0; i<sortedArr.length; i++) {
				arr[i+s] = sortedArr[i];
			}
			
		}
		return arr;
	}
	
	private int[] merge(int[] arr, int s, int m, int e){
		
		int length1 = m - s + 1;
        int length2 = e - m;
 
        int arr1[] = new int [length1];
        int arr2[] = new int [length2];
 
        for (int i = 0; i < length1; i++) {
        	arr1[i] = arr[s + i];
        }
        for (int i = 0; i < length2; i++) {
        	arr2[i] = arr[m + i + 1];
        }
                
        List<Integer> list = new ArrayList<>();  

        int index1 = 0;
        int index2 = 0;
        
        while (index1 < length1 && index2 < length2){
        	if (arr1[index1] >= arr2[index2]){
        		list.add(arr2[index2]);
        		index2 ++;
        	}
        	else{
        		list.add(arr1[index1]);
        		index1 ++;
        	}
        }
        	
        	
        while (index1 <= length1-1){
        	list.add(arr1[index1]);
        	index1++;
        }
        while (index2 <= length2-1){
        	list.add(arr2[index2]);
        	index2++;
        }
        int[] array = new int[list.size()];
        for(int i=0;i<list.size();i++){
        	array[i] = list.get(i);
        }
        return array;
	}
	
}
