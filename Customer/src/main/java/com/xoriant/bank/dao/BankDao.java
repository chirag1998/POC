package com.xoriant.bank.dao;

import java.util.List;

import com.xoriant.bank.model.Account;
import com.xoriant.bank.model.Transactions;
import com.xoriant.bank.model.Userdetails;

public interface BankDao {

	float GetBalance(int accountnumber);

	Userdetails addUserdetails(Userdetails userdetails, String emailid);

	List<Transactions> getministatement(int accountnumber);

	String changepassword(String username, String newpassword);

	List<Transactions> customreport(String start, String end);

	List<Account> getaccount(int customerid);

}