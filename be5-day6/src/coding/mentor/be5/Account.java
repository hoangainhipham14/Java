package coding.mentor.be5;

public class Account {
	String cardNo;
	String PIN;
	String userName;
	double balance;
	
	public Account(String cardNo, String PIN, double balance, String userName) {
		super();
		this.cardNo = cardNo;
		this.PIN = PIN;
		this.balance = balance;
		this.userName = userName;
	}
	
	public void showBalance() {
		System.out.println("Your balance: " + this.balance);
	}
	
	public void deposit(double amount) {
		System.out.println("You deposited successfully!");
		this.balance += amount;
		System.out.println("Your balance: " + this.balance);
	}
	
	public boolean validateBalance(double amount) {
		if (this.balance < amount) {
			return false;
		}
		return true;
	}
	
	public void withdraw(double amount) {
		if (validateBalance(amount)) {
			System.out.println("You withdrawn successfully!");
			this.balance -= amount;
			System.out.println("Your balance: " + this.balance);
		} else {
			System.out.println("Invalid amount to withdraw. Your balance: " + this.balance);
		}
	}
	
	public void showMenu() {
		System.out.println("Hello " + this.userName);
		System.out.println("1. Show Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Logout");
	}
}
