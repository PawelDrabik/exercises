package minibank.models;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Represents a bank account entity
 */
@Entity
@Table(name = "tbl_bank_account")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "account_bank_name")
	private String bankName;

	@Column(name = "account_iban")
	private String accountIban;

	@Column(name = "account_bic")
	private String accountBic;

	@Column(name = "account_balance")
	private BigDecimal accountBalance;

	@OneToOne(mappedBy = "bankAccount", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private AccountHolder accountHolder;

	@OneToMany(mappedBy="bankAccount", cascade=CascadeType.ALL)
	private Set<BankTransactions> bankTransactions;

	public BankAccount() {
	}

	public BankAccount(long id) {
		this.id = id;
	}

	public BankAccount(String account_bank_name, String account_iban, String account_bic, BigDecimal account_balance) {
		this.bankName = account_bank_name;
		this.accountIban = account_iban;
		this.accountBic = account_bic;
		this.accountBalance = account_balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long value) {
		this.id = value;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountIban() {
		return accountIban;
	}

	public void setAccountIban(String accountIban) {
		this.accountIban = accountIban;
	}

	public String getAccountBic() {
		return accountBic;
	}

	public void setAccountBic(String accountBic) {
		this.accountBic = accountBic;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	public Set<BankTransactions> getBankTransactions() {
		return bankTransactions;
	}

	public void setBankTransactions(Set<BankTransactions> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

}