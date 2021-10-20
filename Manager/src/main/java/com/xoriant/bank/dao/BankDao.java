package com.xoriant.bank.dao;

import java.util.List;

import com.xoriant.bank.model.Account;
import com.xoriant.bank.model.Customer;
import com.xoriant.bank.model.Transactions;

public interface BankDao {

	Customer Addcustomer(Customer customer);

	String deletecustomer(int customerid);

	Account addaccount(Account account);

	String deleteaccount(int accountid);

	String deposit(int accountnumber, float amount);

	String withdraw(int accountnumber, float amount);

	List<Transactions> getministatement(int accountnumber);

	String changepassword(String username, String newpassword);

	String fundtransfer(int sender, int receiver, float amount);

	String editcustomer(int customerid, Customer customer);

}