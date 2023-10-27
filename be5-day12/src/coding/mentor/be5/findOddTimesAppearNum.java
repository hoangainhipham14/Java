package coding.mentor.be5;

import java.util.Arrays;
import java.util.ArrayList;

public class findOddTimesAppearNum {
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 100, 400, 15, 15, 15, 15 };
		Arrays.sort(arr);
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		int current = arr[0];
		int count = 0;
		
		// O(n)
		for (int num: arr) {
			if (current == num) {
				count += 1;
			} else {
				if (count % 2 != 0) {
					res.add(current);
				}
				current = num;
				count = 1;
			}
		}
		
		System.out.println("Numbers that appear odd times: ");
		
		// O(n)
		for (int num: res) {
			System.out.print(num + " ");
		}
	}
}
