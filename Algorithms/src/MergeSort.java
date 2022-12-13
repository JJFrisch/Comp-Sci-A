import java.util.*; 

public class MergeSort {
	
	public MergeSort(int[] arr, int s, int e){
		sort(arr,s,e-1);
		printArray(arr);
		
	}

	
	void sort(int[] arr, int s, int f){
		if (s < f){
			int m = (s+f)/2;
			
			sort(arr, s, m);
			sort(arr, m+1, f);
			
			int[] sortedArr = merge(arr, s, m, f);
			
			for (int i=0; i<sortedArr.length; i++) {
				arr[i+s] = sortedArr[i];
			}
			
		}
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

	
	
	
	void printArray(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

}
