package com.xoriant.bank.dao.utils;

public class DBQueries {
	public static final String AddAddress="insert into Address values(default,?,?,?,?,?); ";
	public static final String AddPerson="insert into persons values(default,?,?,?,?,?,?); ";
	public static final String EditCustomer="update Persons set PersonName=?,Gender=?,EmailID=?,DateOFBirth=?,MobileNumber=? where personid=?";
	public static final String DeleteCustomer="delete from persons where personid=?";
	public static final String AddBranch="insert into Branch values(default,?,?,?,?)";
	public static final String AddAccount="insert into Account values(default,?,?,?,?,?,?,?,?,?)";
	public static final String DeleteAccount="delete from Account where account=?";
	public static final String DepositAmount="update account set balance=balance+?  where accountnumber=?";
	public static final String WithdrawAmount="update account set balance=balance-?  where accountnumber=?";
	public static final String GETMINISTMT="select * from Transaction where accountid =(select accountid from account where accountnumber=?) limit 5";
	public static final String CHANGEPASSWORD="update Users set PassWord=? where Username=?";
	public static final String deposittransaction="insert into Transaction values(default,?,?,?,(select accountid from account where accountnumber=?))";
	public static final String withdrawtransaction="insert into Transaction values(default,?,?,?,(select accountid from account where accountnumber=?))";
	public static final String transfertransaction="insert into Transaction values(default,?,?,?,(select accountid from account where accountnumber=?))";
}
