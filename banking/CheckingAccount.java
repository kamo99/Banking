class CheckingAccount extends BankAccount {
	protected double overdraftlimit;

	public CheckingAccount(double balance, double overdraftlimit, User owner) {
		super(balance, owner);
		this.overdraftlimit = Math.abs(overdraftlimit);
	}

	public CheckingAccount(double balance, User owner) {
		this(balance, 1000, owner);
	}

	public CheckingAccount(User owner) {
		this(0, owner);
	}

	public Receipt withdraw(double withdrawl) throws Exception {
		if (withdrawl - balance > this.overdraftlimit)
			throw new Exception("Cannot withdraw that much money");
		else
			balance -= withdrawl;

		Receipt receipt = new Receipt(this, -withdrawl);
		owner.addReceipt(receipt);
		return receipt;
	}
}
