package minibank.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents the transactions history
 */
@Entity
@Table(name = "tbl_transactions")
public class BankTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "transaction_date", unique = true, nullable = false, length = 10)
	private Date transactionDate;

	@Column(name = "transaction_description")
	private String transactionDescription;

	@Column(name = "transaction_amount")
	private BigDecimal transactionAmount;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "bank_id", referencedColumnName = "id") })
	private BankAccount bankAccount;

	public BankTransactions() {
	}

	public BankTransactions(long id) {
		this.id = id;
	}

	public BankTransactions(Date transactionDate, String transactionDescription, BigDecimal transactionAmount) {
		this.transactionDate = transactionDate;
		this.transactionDescription = transactionDescription;
		this.transactionAmount = transactionAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long value) {
		this.id = value;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

}