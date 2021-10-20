package com.xoriant.bank.model;

public class Userdetails {

	private String username;
	private String password;
	private String securityquestion;
	private String securityanswer;
	private String role;
	public Userdetails(String username, String password, String securityquestion, String securityanswer, String role) {
		this.username = username;
		this.password = password;
		this.securityquestion = securityquestion;
		this.securityanswer = securityanswer;
		this.role = role;
	}
	public Userdetails() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityquestion() {
		return securityquestion;
	}
	public void setSecurityquestion(String securityquestion) {
		this.securityquestion = securityquestion;
	}
	public String getSecurityanswer() {
		return securityanswer;
	}
	public void setSecurityanswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
