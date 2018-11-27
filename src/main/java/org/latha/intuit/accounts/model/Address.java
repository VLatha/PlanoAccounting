package org.latha.intuit.accounts.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {
	private String streeName;
	private String buildingNumber;
	private String city;
	private String state;
	
	public Address(){}
	
	public Address(String streeName, String buildingNumber, String city,
			String state) {
		super();
		this.streeName = streeName;
		this.buildingNumber = buildingNumber;
		this.city = city;
		this.state = state;
	}
	public String getStreeName() {
		return streeName;
	}
	public void setStreeName(String streeName) {
		this.streeName = streeName;
	}
	public String getBuildingNumber() {
		return buildingNumber;
	}
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
