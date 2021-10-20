package com.xoriant.bank.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xoriant.bank.dao.utils.DBQueries;
import com.xoriant.bank.model.Account;
import com.xoriant.bank.model.Transactions;
import com.xoriant.bank.model.Userdetails;

@Repository
public class BankDaoImpl implements BankDao  {
	int personid=0;
	private JdbcTemplate jdbcTemplate;
	Base64.Encoder encoder = Base64.getEncoder();  
	@Autowired
	public BankDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public float GetBalance(int accountnumber) {

		return jdbcTemplate.query(DBQueries.GETBALANCE, (ResultSet rs)->{
			float balance = 0;
			while (rs.next()) {
			 balance=rs.getFloat("Balance");
			}
			return balance;
		},accountnumber);

	}
	
	@Override
	public Userdetails addUserdetails(Userdetails userdetails,String emailid)
	{
		 
		 jdbcTemplate.query(DBQueries.GETPERSONID, (ResultSet rs)->{
			while (rs.next()) {
			 personid=rs.getInt("PersonID");
			}
			return personid;
		},emailid);
		 String encryptedpassword=encoder.encodeToString(userdetails.getPassword().getBytes());
		 jdbcTemplate.update(DBQueries.ADDUSERDETAILS,personid,userdetails.getUsername(),encryptedpassword,userdetails.getSecurityquestion(),userdetails.getSecurityanswer(),userdetails.getRole());
	return userdetails;
	}
	
	@Override
	public List<Transactions> getministatement(int accountnumber)
	{
		
		
		return jdbcTemplate.query(DBQueries.GETMINISTMT, (ResultSet rs)->{
			List<Transactions> t= new ArrayList<Transactions>();
			while (rs.next()) {
			Transactions ts = new Transactions();
			 ts.setTransactionid(rs.getInt("TransactionID"));
			 ts.setTransactiontype(rs.getString("Transaction_Type"));
			 ts.setTransactionamount(rs.getFloat("TransactionAmount"));
			 ts.setTransactiondate(rs.getDate("Transaction_Date_Time").toString());
			 t.add(ts);
			}
			return t;
			},accountnumber);
		
	}
	
	@Override
	public List<Account> getaccount(int customerid)
	{
		
		
		return jdbcTemplate.query(DBQueries.GETACCOUNT, (ResultSet rs)->{
			List<Account> a= new ArrayList<Account>();
			while (rs.next()) {
			Account ac= new Account();
			 ac.setAccountnumber(rs.getInt("AccountNumber"));
			 ac.setBalance(rs.getFloat("Balance"));
			 ac.setTransactionlimit(rs.getInt("Transactionlimit"));
			 ac.setMinimumbalance(rs.getFloat("Minimumbalance"));
			 ac.setTransactionamountlimit(rs.getFloat("Transactionamoutlimit"));
			 ac.setInterestrate(rs.getInt("InterestRate"));
			 a.add(ac);
			}
			return a;
			},customerid);
		
	}
	@Override
	public String changepassword(String username,String newpassword)
	{
		String encryptedpassword=encoder.encodeToString(newpassword.getBytes());
		jdbcTemplate.update(DBQueries.CHANGEPASSWORD,encryptedpassword,username);
		return "Password change successfully for: "+username;
	}
	@Override
	public List<Transactions> customreport (String start,String end)
	{
		return jdbcTemplate.query(DBQueries.CUSTOMREPORT, (ResultSet rs)->{
			List<Transactions> t= new ArrayList<Transactions>();
			while (rs.next()) {
			Transactions ts = new Transactions();
			 ts.setTransactionid(rs.getInt("TransactionID"));
			 ts.setTransactiontype(rs.getString("Transaction_Type"));
			 ts.setTransactionamount(rs.getFloat("TransactionAmount"));
			 ts.setTransactiondate(rs.getDate("Transaction_Date_Time").toString());
			 t.add(ts);
			}
			return t;
			},start,end);
	}
	
}
