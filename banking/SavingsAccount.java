class SavingsAccount extends BankAccount {
	public SavingsAccount(double balance, User owner) {
		super(balance, owner);
	}

	public SavingsAccount(User owner) {
		this(0, owner);
	}

	public Receipt withdraw(double withdrawl) throws Exception {
		if (balance < withdrawl)
			throw new Exception("Cannot withdraw that much money");
		else
			balance -= withdrawl;
		Receipt receipt = new Receipt(this, -withdrawl);
		owner.addReceipt(receipt);
		return receipt;
	}
}
