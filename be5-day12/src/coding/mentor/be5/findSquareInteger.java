package coding.mentor.be5;

import java.util.Scanner;
import java.util.ArrayList;

public class findSquareInteger {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numTestCases = input.nextInt();
		int[] numSquareIntegers = new int[numTestCases];
		
		// O(n^2)
		for (int i = 0; i < numTestCases; i++) {
			int start = input.nextInt();
			int end = input.nextInt();
			ArrayList<Integer> squareIntegers = findSquareIntegers(start, end);
			numSquareIntegers[i] = squareIntegers.size();
		}
		
		for (int count: numSquareIntegers) {
			System.out.println(count);
		}
		
		input.close();
	}
	
	public static ArrayList<Integer> findSquareIntegers(int start, int end) {
		ArrayList<Integer> squareIntegers = new ArrayList<Integer>();

		for (int i = start; i < end + 1; i++) {
			int squareRoot = (int) Math.sqrt(i);
			if (squareRoot == Math.sqrt(i)) {
				squareIntegers.add(i);
			}
		}
		return squareIntegers;
	}
}
