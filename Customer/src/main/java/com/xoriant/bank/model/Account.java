package com.xoriant.bank.model;

public class Account {

	private int accountnumber;
	private String accounttype;
	private float balance;
	private int transactionlimit;
	private float minimumbalance;
	private float transactionamountlimit;
	private int interestrate;
	private Branch branch;
	
	
	public Account() {
	}
	public Account(int accountnumber, String accounttype, float balance, int transactionlimit,
			float minimumbalance, float transactionamountlimit, int interestrate, Branch branch) {
		this.accountnumber = accountnumber;
		this.accounttype = accounttype;
		this.balance = balance;
		this.transactionlimit = transactionlimit;
		this.minimumbalance = minimumbalance;
		this.transactionamountlimit = transactionamountlimit;
		this.interestrate = interestrate;
		this.branch = branch;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getTransactionlimit() {
		return transactionlimit;
	}
	public void setTransactionlimit(int transactionlimit) {
		this.transactionlimit = transactionlimit;
	}
	public float getMinimumbalance() {
		return minimumbalance;
	}
	public void setMinimumbalance(float minimumbalance) {
		this.minimumbalance = minimumbalance;
	}
	public float getTransactionamountlimit() {
		return transactionamountlimit;
	}
	public void setTransactionamountlimit(float transactionamountlimit) {
		this.transactionamountlimit = transactionamountlimit;
	}
	public int getInterestrate() {
		return interestrate;
	}
	public void setInterestrate(int interestrate) {
		this.interestrate = interestrate;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Account [accountnumber=" + accountnumber + ", accounttype=" + accounttype + ", balance=" + balance
				+ ", transactionlimit=" + transactionlimit + ", minimumbalance=" + minimumbalance
				+ ", transactionamountlimit=" + transactionamountlimit + ", interestrate=" + interestrate + ", branch="
				+ branch + "]";
	}
	
	
}
