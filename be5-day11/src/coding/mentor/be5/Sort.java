package coding.mentor.be5;

import java.util.ArrayList;

public class Sort {
	public static void main(String args[]) {
		int[] arr = { 0, 1, 2, 1, 0, 0, 2 };
		sort(arr);
	}
	
	public static ArrayList<Integer> sort(int[] arr) {
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();
		int[] count = new int[3];
		
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] += 1;
		}
		
		System.out.print("Sorted array:");
		
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				sortedArray.add(i);
				System.out.print(" " + i + " ");
			}
		}
		
		return sortedArray;
	}
}
