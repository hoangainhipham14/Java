package coding.mentor.be5;

import java.util.Scanner;

public class Main {
	
	static final int SHOW_BALANCE_COMMAND = 1;
	static final int DEPOSIT_COMMAND = 2;
	static final int WITHDRAW_COMMAND = 3;

	public static void main(String[] args) {

		Bank bank = new Bank();
		bank.initBankDatabase();
		
		Scanner input = new Scanner(System.in);
		String cardNo;
		String PIN;
		Account selectedAccount;
		
		do {
			System.out.println("Please enter your card number");
			cardNo = input.nextLine();
			System.out.println("Please enter your PIN");
			PIN = input.nextLine();
			selectedAccount = bank.findAccount(cardNo, PIN);
			if (selectedAccount == null) {
				System.out.println("Wrong card number or PIN");
			}
		} while (selectedAccount == null);
		
		selectedAccount.showMenu();
		int selectedCommand;
		double amount;
		
		do {
			System.out.println("Please select a command");
			selectedCommand = input.nextInt();
			
			switch (selectedCommand) {
				case SHOW_BALANCE_COMMAND: {
					selectedAccount.showBalance();
					break;
				}
				case DEPOSIT_COMMAND: {
					System.out.println("Please enter amount to deposit");
					amount = input.nextInt();
					selectedAccount.deposit(amount);
					break;
				}
				case WITHDRAW_COMMAND: {
					System.out.println("Please enter amount to withdraw");
					amount = input.nextInt();
					selectedAccount.withdraw(amount);
					break;
				}
				default: 
					break;
			}
			
		} while (selectedCommand != 4);
		input.close();
	}
}
