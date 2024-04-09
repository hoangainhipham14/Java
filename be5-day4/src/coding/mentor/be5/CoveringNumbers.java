package coding.mentor.be5;

public class CoveringNumbers {
	
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 6, 5, 0 };
		int output = checkCoveringNumbers(input);
		System.out.println(output);
	}
	
	public static int checkCoveringNumbers(int[] input) {
		int index = 0;
		int[] counts = new int[input.length + 1];
		int n = 0;
		while (index < input.length) {
			if (input[index] > n) {
				n = input[index];
			}
			if (input[index] > input.length + 1) {
				return -1;
			}
			counts[input[index]] += 1;
			index++;
		}
		
		index = 1;
		while (index < n) {
			if (counts[index] > 1 || counts[index] < 1) {
				return -1;
			}
			index++;
		}
		return counts[0];
	}
}
