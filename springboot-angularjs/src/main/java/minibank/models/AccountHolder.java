package minibank.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents a person who is a bank account owner
 */
@Entity
@Table(name = "tbl_personal_info")
public class AccountHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "dateofbirth", unique = true, nullable = false, length = 10)
	private Date dateofbirth;

	@Column(name = "address")
	private String address;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "id", referencedColumnName = "id") })
	private BankAccount bankAccount;

	public AccountHolder() {
	}

	public AccountHolder(long id) {
		this.id = id;
	}

	public AccountHolder(Date dateofbirth, String address, String firstname, String lastname, String email) {
		this.dateofbirth = dateofbirth;
		this.address = address;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long value) {
		this.id = value;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
}