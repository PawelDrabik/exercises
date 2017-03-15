package minibank.rest.domain;


public class Account {

	private AccountHolder accountHolder;

	private BankAccount bankDetails;

	public BankAccount getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankAccount bankDetails) {
		this.bankDetails = bankDetails;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

}