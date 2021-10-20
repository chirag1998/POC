package com.xoriant.bank.dao.utils;

public class DBQueries {
	public static final String GETBALANCE="select * from account where personid = ( select personid from persons where personname=?) ";
	public static final String GETPERSONID="select * from Persons where EmailID=?";
	public static final String ADDUSERDETAILS="insert into users values(default,?,?,?,?,?,?)";
	public static final String GETMINISTMT="select * from Transaction where accountid =(select accountid from account where accountnumber=?) limit 5";
	public static final String CHANGEPASSWORD="update Users set PassWord=? where Username=?";
	public static final String CUSTOMREPORT="select  * from Transaction where  transaction_date_time between ? and ?";
	public static final String GETACCOUNT="select  * from account where personid = ( select personid from persons where personname=?)";
}
