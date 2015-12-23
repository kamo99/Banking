abstract class BankAccount {
	protected Double balance;
	private Receipt[] receipts;
	protected User owner;

	public BankAccount(double balance, User owner) {
		this.balance = balance;
		this.owner = owner;
	}

	public BankAccount(User owner) {
		this(0, owner);
	}

	public Double getBalance() {
		return balance;
	}

	public Receipt deposit(double deposition) throws Exception {
		if (deposition < 0)
			throw new Exception("Cannot deposit a negative number");
		else
			balance += deposition;
		Receipt rec = new Receipt(this, deposition);
		owner.addReceipt(rec);
		return rec;
	}

	abstract public Receipt withdraw(double withdrawl) throws Exception;
}
