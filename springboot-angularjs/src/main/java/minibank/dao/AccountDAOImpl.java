package minibank.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import minibank.models.AccountHolder;
import minibank.models.BankAccount;
import minibank.models.BankTransactions;
import minibank.rest.domain.Account;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

	private Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);

	private SessionFactory sessionFactory;

	@Override
	public String createAccount(Account account) {
		logger.info("AccountDAOImpl: " + account);

		BankAccount bankAccount = new BankAccount();
		bankAccount.setBankName(account.getBankDetails().getBankname());
		bankAccount.setAccountIban(account.getBankDetails().getIban());
		bankAccount.setAccountBic(account.getBankDetails().getBic());
		bankAccount.setAccountBalance(account.getBankDetails().getBalance());

		minibank.models.AccountHolder accountHolder = new AccountHolder();
		accountHolder.setFirstname(account.getAccountHolder().getFirstname());
		accountHolder.setLastname(account.getAccountHolder().getLastname());
		accountHolder.setDateofbirth(account.getAccountHolder().getDateOfBirth());
		accountHolder.setAddress(account.getAccountHolder().getAddress());
		accountHolder.setEmail(account.getAccountHolder().getEmail());
		accountHolder.setBankAccount(bankAccount);

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(bankAccount);
		session.persist(accountHolder);
		tx.commit();
		session.close();
		logger.info("AccountDAOImpl: bankAccount-id " + bankAccount.getId());
		logger.info("AccountDAOImpl: accountHolder-id " + accountHolder.getId());
		String response = "{\"bankAccountId\":\"" + bankAccount.getId() + "\",\"accountHolderId\":\""
				+ accountHolder.getId() + "\"}";
		return response;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<BankAccount> listAllAccounts() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT * FROM tbl_bank_account");
		query.addEntity(BankAccount.class);
		List<BankAccount> results = query.list();
		tx.commit();
		session.close();
		return results;
	}

	@Override
	public List<BankAccount> listAllAccountsByBankName(String bankName) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT * FROM tbl_bank_account where account_bank_name=\"" + bankName
				+ "\"");
		query.addEntity(BankAccount.class);
		List<BankAccount> results = query.list();
		tx.commit();
		session.close();
		return results;
	}

	@Override
	public String createAccTransactions(minibank.rest.domain.BankAccount bankDetails) throws ParseException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		BankAccount bankAcc = session.load(BankAccount.class, Long.valueOf(bankDetails.getId()));

		minibank.models.BankTransactions bankTrans = new BankTransactions();
		bankTrans.setTransactionAmount(new BigDecimal(bankDetails.getTransBalance()));
		bankTrans.setTransactionDate(bankDetails.getDate());
		bankTrans.setTransactionDescription(bankDetails.getDescription());
		bankTrans.setBankAccount(bankAcc);
		session.persist(bankTrans);
		tx.commit();
		session.close();
		logger.info("BankAccount.ID: " + bankDetails.getId());
		logger.info("BankTransactions.ID: " + bankTrans.getId());
		String response = "{\"bankAccountId\":\"" + bankDetails.getId() + "\",\"accountTransId\":\""
				+ bankTrans.getId() + "\"}";

		return response;
	}

	@Override
	public List<BankTransactions> listTransactionsByDate(String date) throws ParseException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "SELECT * FROM minibank.tbl_transactions where transaction_date > "
				+ date + "";
		logger.info("sql: [" + sql + "]");
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(BankTransactions.class);
		List<BankTransactions> results = query.list();
		logger.info("A number of transactions is: [" + results.size() + "]");
		tx.commit();
		session.close();
		return results;
	}

}
