package org.latha.intuit.accounts.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Business {
	private int Id;
	private String name;
	private String phoneNumber;
	private float income;
	private Address address;
	
	public Business(){}

	public Business(int id, String name, String phoneNumber, float income,
			Address address) {
		super();
		Id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.income = income;
		this.address = address;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}
