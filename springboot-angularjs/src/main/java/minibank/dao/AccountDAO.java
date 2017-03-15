package minibank.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import minibank.models.BankAccount;
import minibank.models.BankTransactions;
import minibank.rest.domain.Account;

public interface AccountDAO {
	String createAccount(Account account);

	List<BankAccount> listAllAccounts();
	
	List<BankAccount> listAllAccountsByBankName(String bankName);

	String createAccTransactions(minibank.rest.domain.BankAccount bankDetails) throws ParseException;
	
	List<BankTransactions> listTransactionsByDate(String date) throws ParseException;
}
