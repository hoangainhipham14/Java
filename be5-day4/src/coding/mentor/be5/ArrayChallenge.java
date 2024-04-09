package coding.mentor.be5;

public class ArrayChallenge {

	public static void main(String[] args) {
		int[] input = { -2, 2, 6, 10 };
		boolean isArithmetic = checkArithmetic(input);
		boolean isGeometric = checkGeometric(input);
		if (isArithmetic) {
			System.out.println("Arithmetic");
		} else if (isGeometric) {
			System.out.println("Geometric");
		} else {
			System.out.println("-1");
		}
	}
	
	public static boolean checkArithmetic(int[] numbs) {
		int difference = numbs[1] - numbs[0];
		int index = 2;
		
		while (index < numbs.length) {
			if (numbs[index] - numbs[index - 1] != difference) {
				return false;
			}
			index++;
		}
		return true;
	}
	
	public static boolean checkGeometric(int[] numbs) {
		int quotient = numbs[1] / numbs[0];
		int index = 2;
		
		while (index < numbs.length) {
			if (numbs[index] / numbs[index - 1] != quotient) {
				return false;
			}
			index++;
		}
		return true;
	}
}
