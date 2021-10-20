package com.xoriant.bank.model;

public class Address {

	private int doornumber;
	private String city;
	private String area;
	private String state;
	private int pin;
	public Address(int doornumber, String city, String area, String state, int pin) {
		this.doornumber = doornumber;
		this.city = city;
		this.area = area;
		this.state = state;
		this.pin = pin;
	}
	public Address() {
	}
	@Override
	public String toString() {
		return "Address [doornumber=" + doornumber + ", city=" + city + ", area=" + area + ", state=" + state + ", pin="
				+ pin + "]";
	}
	public int getDoornumber() {
		return doornumber;
	}
	public void setDoornumber(int doornumber) {
		this.doornumber = doornumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

}
