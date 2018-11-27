package org.latha.intuit.accounts.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Individual {
	private int id;
	private String name;
	private int ssn;
	private float salary;
	private String phoneNumber;
	private Address address;
	public Individual(){
		
	}
	public Individual(int id, String name, int ssn, float salary,
			String phoneNumber, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.ssn = ssn;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
