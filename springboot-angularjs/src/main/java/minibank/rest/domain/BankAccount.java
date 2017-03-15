package minibank.rest.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class BankAccount {

	@NotNull
	private String id;

	@NotNull
	private String bankname;

	@NotNull
	private String iban;

	@NotNull
	private String bic;

	@NotNull
	private BigDecimal balance;

	private String description;

	private Date date;

	private String transBalance;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransBalance() {
		return transBalance;
	}

	public void setTransBalance(String transBalance) {
		this.transBalance = transBalance;
	}
}