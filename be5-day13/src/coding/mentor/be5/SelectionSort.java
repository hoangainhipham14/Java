package coding.mentor.be5;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = { 50, 25, 5, 20, 10 };
		for (int j = 0; j < arr.length; j++) {
			int min = arr[j];
			int minIndex = j;
			for (int i = j + 1; i < arr.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
					minIndex = i;
				}
			}
			arr[minIndex] = arr[j];
			arr[j] = min;
		}
	}    
} 
