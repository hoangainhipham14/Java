package coding.mentor.be5;

public class Bank {
	Account[] accounts;
	
	public Bank() {}
	
	public Account findAccount(String cardNo, String PIN) {
		for (int index = 0; index < this.accounts.length; index++) {
			if (this.accounts[index].cardNo.equals(cardNo) && this.accounts[index].PIN.equals(PIN)) {
				return this.accounts[index];
			}
		}
		return null;
	}
	
	public void initBankDatabase() {
		Account account = new Account("000000", "111", 100, "A");
		Account account1 = new Account("111111", "222", 100, "B");
		Account account2 = new Account("222222", "333", 100, "C");
		Account[] accounts = { account, account1, account2 };
		this.accounts = accounts;
	}
}
