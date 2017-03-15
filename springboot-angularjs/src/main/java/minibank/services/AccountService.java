package minibank.services;

import java.text.ParseException;
import java.util.List;

import minibank.dao.AccountDAO;
import minibank.models.BankAccount;
import minibank.models.BankTransactions;
import minibank.rest.domain.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pawel.drabik on 16/02/2017.
 */
@Service
public class AccountService {

	private Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountDAO accountDAO;

	public String createAccount(Account account) {
		logger.info("AccountService: " + account);
		return accountDAO.createAccount(account);
	}

	public String createAccTransactions(minibank.rest.domain.BankAccount bankDetails) throws ParseException {
		logger.info("AccountService: " + bankDetails);
		return accountDAO.createAccTransactions(bankDetails);		
	}
	
	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public List<BankAccount> listAllAccounts() {
		logger.info("AccountService: listAllAccounts");
		return accountDAO.listAllAccounts();
	}

	public List<BankAccount> listAllAccountsByBankName(String bankName) {
		logger.info("AccountService: listAllAccountsByBankName");
		return accountDAO.listAllAccountsByBankName(bankName);
	}

	public List<BankTransactions> listTransactionsByDate(String date) throws ParseException {
		logger.info("AccountService: listTransactionsByDate");
		return accountDAO.listTransactionsByDate(date);
	}
}
