package minibank.rest.domain;

import javax.validation.constraints.NotNull;

public class Transactions {

	@NotNull
	private String description;

	@NotNull
	private String date;

	@NotNull
	private String transBalance;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTransBalance() {
		return transBalance;
	}

	public void setTransBalance(String transBalance) {
		this.transBalance = transBalance;
	}


}