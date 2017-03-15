package minibank.rest.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import minibank.models.BankAccount;
import minibank.models.BankTransactions;
import minibank.rest.domain.Account;
import minibank.services.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/accounts")
public class CreateAccountController {

	private Logger logger = LoggerFactory.getLogger(CreateAccountController.class);

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createAccount(@RequestBody Account account) throws JsonGenerationException, JsonMappingException,
			IOException {
		logger.info("account: " + account);
		String response = accountService.createAccount(account);
		return response;
	}

	@RequestMapping(value = "/createTransAccount", method = RequestMethod.POST)
	public String createAccountTrans(@RequestBody minibank.rest.domain.BankAccount bankDetails)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		logger.info("bankDetails: " + bankDetails);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(bankDetails);
		logger.info("jsonInString: " + jsonInString);
		String response = accountService.createAccTransactions(bankDetails);
		return response;
	}

	@RequestMapping(value = "/listAllAccounts", method = RequestMethod.POST)
	public String listAllAccounts() throws JsonGenerationException, JsonMappingException, IOException {
		List<BankAccount> listAllAccounts = accountService.listAllAccounts();
		listAllAccounts.listIterator();
		StringBuffer sb = new StringBuffer("[");
		for (Iterator<BankAccount> iterator = listAllAccounts.iterator(); iterator.hasNext();) {
			BankAccount bankAccount = (BankAccount) iterator.next();
			long id = bankAccount.getId();
			String bankName = bankAccount.getBankName();
			String Iban = bankAccount.getAccountIban();
			String bic = bankAccount.getAccountBic();
			BigDecimal balance = bankAccount.getAccountBalance();
			sb.append("{");
			sb.append("\"Id\":\"");
			sb.append(id);
			sb.append("\",");
			sb.append("\"bankName\":\"");
			sb.append(bankName);
			sb.append("\",");
			sb.append("\"Iban\":\"");
			sb.append(Iban);
			sb.append("\",");
			sb.append("\"bic\":\"");
			sb.append(bic);
			sb.append("\",");
			sb.append("\"balance\":\"");
			sb.append(balance);
			sb.append("\"");
			sb.append("}");
			if (iterator.hasNext()) {
				sb.append(",");
			}
		}
		sb.append("]");
		logger.info("All the accounts: " + sb.toString());
		return sb.toString();
	}

	@RequestMapping(value = "/listAllAccountsByBankName", method = RequestMethod.POST)
	public String listAllAccountsByBankName(@RequestBody String bankNameParam) throws JsonGenerationException,
			JsonMappingException, IOException {
		logger.info("All the accounts by bankname: " + bankNameParam);
		List<BankAccount> listAllAccounts = accountService.listAllAccountsByBankName(bankNameParam);
		listAllAccounts.listIterator();
		StringBuffer sb = new StringBuffer("[");
		for (Iterator<BankAccount> iterator = listAllAccounts.iterator(); iterator.hasNext();) {
			BankAccount bankAccount = (BankAccount) iterator.next();
			long id = bankAccount.getId();
			String bankName = bankAccount.getBankName();
			String Iban = bankAccount.getAccountIban();
			String bic = bankAccount.getAccountBic();
			BigDecimal balance = bankAccount.getAccountBalance();
			sb.append("{");
			sb.append("\"Id\":\"");
			sb.append(id);
			sb.append("\",");
			sb.append("\"bankName\":\"");
			sb.append(bankName);
			sb.append("\",");
			sb.append("\"Iban\":\"");
			sb.append(Iban);
			sb.append("\",");
			sb.append("\"bic\":\"");
			sb.append(bic);
			sb.append("\",");
			sb.append("\"balance\":\"");
			sb.append(balance);
			sb.append("\"");
			sb.append("}");
			if (iterator.hasNext()) {
				sb.append(",");
			}
		}
		sb.append("]");
		logger.info("All the accounts: " + sb.toString());
		return sb.toString();
	}

	@RequestMapping(value = "/listTransactionsByDate", method = RequestMethod.POST)
	public String listTransactionsByDate(@RequestBody String date) throws JsonGenerationException,
			JsonMappingException, IOException, ParseException {
		logger.info("Get all the transactions by date: " + date);
		List<BankTransactions> trans = accountService.listTransactionsByDate(date);
		trans.listIterator();
		StringBuffer sb = new StringBuffer("[");
		for (Iterator<BankTransactions> iterator = trans.iterator(); iterator.hasNext();) {
			BankTransactions transaction = (BankTransactions) iterator.next();
			long id = transaction.getId();
			Date transactionDate = transaction.getTransactionDate();
			String transactionDescription = transaction.getTransactionDescription();
			BigDecimal transactionAmount = transaction.getTransactionAmount();
			sb.append("{");
			sb.append("\"Id\":\"");
			sb.append(id);
			sb.append("\",");
			sb.append("\"transDate\":\"");
			sb.append(transactionDate);
			sb.append("\",");
			sb.append("\"transDescription\":\"");
			sb.append(transactionDescription);
			sb.append("\",");
			sb.append("\"transAmount\":\"");
			sb.append(transactionAmount);
			sb.append("\"");
			sb.append("}");
			if (iterator.hasNext()) {
				sb.append(",");
			}
		}
		sb.append("]");
		logger.info("All the transactions: " + sb.toString());
		return sb.toString();
	}
}
