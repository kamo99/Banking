import java.util.ArrayList;

class User {
	private String id, pin;
	private SavingsAccount savings;
	private CheckingAccount checkings;
	private ArrayList<Receipt> receipts;

	public User(String id, String pin) {
		this.id = id;
		this.pin = pin;
		this.receipts = new ArrayList<Receipt>();
	}

	public String toString() {
		return this.id;
	}

	public void setSavings(SavingsAccount savings) {
		this.savings = savings;
	}

	public void setCheckings(CheckingAccount checkings) {
		this.checkings = checkings;
	}

	public SavingsAccount getSavings() {return savings;}
	public CheckingAccount getCheckings() {return checkings;}

	public ArrayList<Receipt> getReceipts() {return this.receipts;}

	public void addReceipt(Receipt rec) {this.receipts.add(rec);}
}
