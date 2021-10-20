package com.xoriant.bank.model;

public class Branch {

	
	private String branchname;
	private String ifsccode;
	private String micrcode;
	
	
	public Branch() {
	}
	@Override
	public String toString() {
		return "Branch [ branchname=" + branchname + ", ifsccode=" + ifsccode + ", micrcode="
				+ micrcode + "]";
	}
	public Branch(String branchname, String ifsccode, String micrcode) {
		this.branchname = branchname;
		this.ifsccode = ifsccode;
		this.micrcode = micrcode;
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
