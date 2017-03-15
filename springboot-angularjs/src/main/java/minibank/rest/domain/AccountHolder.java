package minibank.rest.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;


/**
 * Represents a person who is a bank account owner
 */
public class AccountHolder {

	@NotNull
	private String firstname;

	@NotNull
	private String lastname;

	@NotNull
	private Date dateOfBirth;

	@NotNull
	private String address;

	@NotNull
	private String email;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}