package com.xoriant.bank.model;

public class Branch {

	
	private int branchid;
	private String branchname;
	private String ifsccode;
	private String micrcode;
	
	
	public Branch() {
	}
	@Override
	public String toString() {
		return "Branch [branchid=" + branchid + ", branchname=" + branchname + ", ifsccode=" + ifsccode + ", micrcode="
				+ micrcode + "]";
	}
	public Branch(int branchid, String branchname, String ifsccode, String micrcode) {
		this.branchid = branchid;
		this.branchname = branchname;
		this.ifsccode = ifsccode;
		this.micrcode = micrcode;
	}
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getIfsccode() {
		return ifsccode;
	}
	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}
	public String getMicrcode() {
		return micrcode;
	}
	public void setMicrcode(String micrcode) {
		this.micrcode = micrcode;
	}
	
}
