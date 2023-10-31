package coding.mentor.be5;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 50, 25, 5, 20, 10 };
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - j - 1; i++) {
				if (arr[i + 1] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}
}
