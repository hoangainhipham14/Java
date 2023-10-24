package coding.mentor.be5;

import java.util.Scanner;

public class SquareRoot {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		Double num;
		Double result;
		do {
			num = getUserInput(input);
			result = calSquareRoot(num);
			System.out.println("Square root of " + num + ": " + result);
		} while (num != null);
		
		input.close();
	}
	
	public static Double getUserInput(Scanner input) {
		System.out.println("Please enter a number");
		
		try {
			double num = input.nextDouble();
			return num;
		} catch (Exception e) {
			System.out.println("Please input a positive number");
			return null;
		}
	}
	
	public static Double calSquareRoot(Double number) {
		double i = 0;
		
		while (i * i <= number) {
			System.out.println(i);
			if (i * i > number - 0.01 && i * i < number + 0.01) {
				return i;
			}
			i += 0.5;
		}
		return number;
	}
}




