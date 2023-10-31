package be5;

import java.util.Scanner;

public class TheFeast {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int money = input.nextInt();
		int cost = input.nextInt();
		int amountWrappersForOneCandy = input.nextInt();
		int totalWrappers = (int) money / cost;
		int totalBars = totalWrappers;
		while (totalWrappers >= amountWrappersForOneCandy) {
			int amountWrappersLeft = totalWrappers % amountWrappersForOneCandy;
			int numBars = (int) totalWrappers / amountWrappersForOneCandy;
			totalWrappers = amountWrappersLeft + numBars;
			totalBars += numBars;		
		}
		System.out.println("Total bars: " + totalBars);
		input.close();
	}
}
