package com.xoriant.bank.model;


public class Transactions {
	private int transactionid;
	private String transactiontype;
	private float transactionamount;
	private String transactiondate;
	
	
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	
	public Transactions() {
	}
	@Override
	public String toString() {
		return "Transactions [transactionid=" + transactionid + ", transactiontype=" + transactiontype
				+ ", transactionamount=" + transactionamount + ", transactiondate=" + transactiondate + "]";
	}
	public Transactions(int transactionid, String transactiontype, float transactionamount,
			String transactiondate) {
		this.transactionid = transactionid;
		this.transactiontype = transactiontype;
		this.transactionamount = transactionamount;
		this.transactiondate = transactiondate;
	}
	
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public float getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(float transactionamount) {
		this.transactionamount = transactionamount;
	}
	public String getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

}
