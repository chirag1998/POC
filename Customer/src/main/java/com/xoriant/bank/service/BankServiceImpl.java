package com.xoriant.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.bank.dao.BankDao;
import com.xoriant.bank.model.Account;
import com.xoriant.bank.model.Transactions;
import com.xoriant.bank.model.Userdetails;

@Service
public class BankServiceImpl implements BankService  {
	@Autowired
	private BankDao bankDao;

	@Override
	public float GetBalance(int accountnumber) {
		// TODO Auto-generated method stub
		if(accountnumber<0)
		{
			return 0;
		}
		else {
		return bankDao.GetBalance(accountnumber);
		}
	}
	
	@Override
	public List<Account> getaccount(int customerid)
	{
		if(customerid<0)
		{
			return null;
		}
		else {
	return bankDao.getaccount(customerid);
		}
	}
	@Override
	public Userdetails addUserdetails(Userdetails userdetails,String emailid)
	{
		if(userdetails==null && emailid.equals(""))
		{
			return null;
		}
		else {
		 return bankDao.addUserdetails(userdetails, emailid);
		}
	}
	
	@Override
	public List<Transactions> getministatement(int accountnumber)
	{
		if(accountnumber<0)
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
	public List<Transactions> customreport (String start,String end)
	{
		if(start.equalsIgnoreCase("") && end.equalsIgnoreCase(""))
		{
			return null;
		}
		{
		return bankDao.customreport(start, end);
		}
	}
}
