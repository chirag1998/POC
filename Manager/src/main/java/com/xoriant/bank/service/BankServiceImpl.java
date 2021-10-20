package com.xoriant.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.bank.dao.BankDao;
import com.xoriant.bank.model.Account;
import com.xoriant.bank.model.Customer;
import com.xoriant.bank.model.Transactions;

@Service
public class BankServiceImpl implements BankService   {
	@Autowired
	private BankDao bankDao;

	
	@Override
	public Customer Addcustomer(Customer customer) {
		if(customer==null)
		{
			return customer;
		}
		else {
			return bankDao.Addcustomer(customer);
		}
		
	}
	@Override
	public String editcustomer(int customerid,Customer customer)
	{
		if(customerid<0 && customer==null)
		{
			return "Customer details are invalid";
		}
		else {
		return bankDao.editcustomer(customerid, customer);
		}
	}
	
	@Override
	public String deletecustomer(int customerid)
	{
		if(customerid<0)
		{
			return "Enter Valid customerid";
		}
		else {
			return bankDao.deletecustomer(customerid);
		}
		
	}
	
	
	@Override
	public Account addaccount(Account account)
	{
		if(account==null)
		{
			return account;
		}
		else {
		 return bankDao.addaccount(account);
		}
	}
	
	@Override
	public String deleteaccount(int accountid)
	{
		if(accountid<0) {
			return "Invalid accountid";
		}
		else {
		return bankDao.deleteaccount(accountid);
		}
	}
	
	@Override
	public String deposit(int accountnumber,float amount)
	{
		if(accountnumber<0 || amount<0.0)
		{
			return "Invalid Details";
		}
		else {
		return bankDao.deposit(accountnumber, amount);
		}
	}
	

	@Override
	public String withdraw(int accountnumber ,float amount)
	{
		if(accountnumber<0 || amount<0.0)
		{
			return "Invalid Details";
		}
		else {
		return bankDao.withdraw(accountnumber, amount);
		}
	}
	

	@Override
	public List<Transactions> getministatement(int accountnumber)
	{
		if(accountnumber<0 )
		{
			return null;
		}
		else {
		return bankDao.getministatement(accountnumber);
		}
	}

	@Override
	public String changepassword(String username,String newpassword)
	{
		if(username.equalsIgnoreCase("") || newpassword.equalsIgnoreCase(""))
		{
			return "Invalid Details";
		}
		else {
		return bankDao.changepassword(username, newpassword);
		}
	}
	
	@Override
	public String fundtransfer(int sender,int receiver,float amount)
	{
		if(sender<0 || receiver<0 || amount<0.0)
		{
			return "Invalid Details";
		}
		else {
		return bankDao.fundtransfer(sender, receiver, amount);
		}
	}
}
