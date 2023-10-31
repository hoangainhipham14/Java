package be5;

import java.util.Arrays;

public class MinimumGap {
	
	public static void main(String[] args) {
		Integer[] arr = { 7, 7, 1, 4, 1, 7 };
		int minGap = arr.length;
		
		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			arr[i] = 0;
			int index = Arrays.asList(arr).indexOf(curr);
			if (Math.abs(i - index) < minGap) {
				minGap = Math.abs(i - index);
			}
		}
		
		System.out.println(minGap);
	}
}
