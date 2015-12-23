class Receipt {
	final private BankAccount account;
	final private double change;

	public Receipt(BankAccount account, double change) {
		this.account = account;
		this.change = change;
	}

	public BankAccount getAccount() {return account;}
	public double getChange() {return change;}

	public String toString() {
		final String action = this.change > 0 ? " added to " : " taken from ";
		return Math.abs(this.change) + " was" + action + this.account;
	}
}
