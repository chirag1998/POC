package com.xoriant.bank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.xoriant.bank.dao.utils.DBQueries;
import com.xoriant.bank.model.Account;
import com.xoriant.bank.model.Customer;
import com.xoriant.bank.model.Transactions;

@Repository
public class BankDaoImpl implements BankDao  {
	
	private JdbcTemplate jdbcTemplate;
	Base64.Encoder encoder = Base64.getEncoder();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now(); 
	@Autowired
	public BankDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public Customer Addcustomer(Customer customer) {
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
		PreparedStatement ps = connection.prepareStatement(DBQueries.AddAddress,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,customer.getAddress().getState());
		ps.setString(2, customer.getAddress().getCity());
		ps.setString(3,customer.getAddress().getArea());
		ps.setInt(4, customer.getAddress().getDoornumber());
		ps.setInt(5,customer.getAddress().getPin());
		ps.setString(2, customer.getAddress().getCity());
		return ps;
		},keyHolder);
		int key =keyHolder.getKey().intValue();
		jdbcTemplate.update(DBQueries.AddPerson, customer.getName(),customer.getGender(),customer.getEmailid(),customer.getDateofbirth(),customer.getMobilenumber(),key);
		return customer;
	}
	@Override
	public String editcustomer(int customerid,Customer customer)
	{
		jdbcTemplate.update(DBQueries.EditCustomer,customer.getName(),customer.getGender(),customer.getEmailid(),customer.getDateofbirth(),customer.getMobilenumber(),customerid);
		return "Customer edited successfully";
	}

	@Override
	public String deletecustomer(int customerid)
	{
		jdbcTemplate.update(DBQueries.DeleteCustomer,customerid);
		return "Customer deleted successfully";
	}
	
	@Override
	public Account addaccount(Account account)
	{
		 KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(DBQueries.AddBranch,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,account.getBranch().getBranchname());
			ps.setString(2, account.getBranch().getIfsccode());
			ps.setString(3,account.getBranch().getMicrcode());
			ps.setInt(4, 1);
			return ps;
			},keyHolder);
			int key =keyHolder.getKey().intValue();
			jdbcTemplate.update(DBQueries.AddAccount, account.getAccountnumber(),account.getAccounttype(),account.getBalance(),account.getCustomerid(),key,account.getTransactionlimit(),account.getMinimumbalance(),account.getTransactionamountlimit(),account.getInterestrate());
			return account;
			
	}
	
	@Override
	public String deleteaccount(int accountid)
	{
		jdbcTemplate.update(DBQueries.DeleteAccount,accountid);
		return "Account deleted successsfully";
	}
	
	@Override
	public String deposit(int accountnumber,float amount)
	{
		jdbcTemplate.update(DBQueries.DepositAmount,amount,accountnumber);
		jdbcTemplate.update(DBQueries.deposittransaction,"DEPOSIT",dtf.format(now).toString(),amount,accountnumber);
		return amount+" deposited successfully";
	}
	
	@Override
	public String withdraw(int accountnumber ,float amount)
	{
		jdbcTemplate.update(DBQueries.WithdrawAmount,amount,accountnumber);
		jdbcTemplate.update(DBQueries.withdrawtransaction,"WITHDRAW",dtf.format(now).toString(),amount,accountnumber);
		return amount+" withdraw successful";
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
	public String changepassword(String username,String newpassword)
	{
		String encryptedpassword=encoder.encodeToString(newpassword.getBytes());
		jdbcTemplate.update(DBQueries.CHANGEPASSWORD,encryptedpassword,username);
		return "Password change successfully for: "+username;
	}
	
	@Override
	public String fundtransfer(int sender,int receiver,float amount)
	{
		jdbcTemplate.update(DBQueries.DepositAmount,amount,sender);
		jdbcTemplate.update(DBQueries.WithdrawAmount,amount,receiver);
		jdbcTemplate.update(DBQueries.transfertransaction,"TRANSFER",dtf.format(now).toString(),amount,sender);
		return "Funds transferred succesfully"; 
	}
}
