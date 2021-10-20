package com.xoriant.bank.model;


public class Customer {
private String name;
private String gender;
private String dateofbirth;
private String emailid;
private int mobilenumber;
private Address address;

public Customer() {
}


@Override
public String toString() {
	return "Customer [name=" + name + ", gender=" + gender + ", dateofbirth=" + dateofbirth + ", emailid=" + emailid
			+ ", mobilenumber=" + mobilenumber + ", address=" + address + "]";
}




public Customer(String name, String gender, String dateofbirth, String emailid, int mobilenumber, Address address) {
	this.name = name;
	this.gender = gender;
	this.dateofbirth = dateofbirth;
	this.emailid = emailid;
	this.mobilenumber = mobilenumber;
	this.address = address;
}




public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public String getName() {
	return name;
}




public void setName(String name) {
	this.name = name;
}




public String getDateofbirth() {
	return dateofbirth;
}




public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}




public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public int getMobilenumber() {
	return mobilenumber;
}
public void setMobilenumber(int mobilenumber) {
	this.mobilenumber = mobilenumber;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
}
