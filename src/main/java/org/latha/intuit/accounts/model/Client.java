package org.latha.intuit.accounts.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {
	private ClientStatus clientType;
	private Business business;
	private Individual individual;
	
	public Client(){}
	
	public Client(ClientStatus clientType, Business business, Individual individual) {
		super();
		this.clientType = clientType;
		this.business = business;
		this.individual = individual;
	}
	public ClientStatus getClientType() {
		return clientType;
	}
	public void setClientType(ClientStatus clientType) {
		this.clientType = clientType;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public Individual getIndividual() {
		return individual;
	}
	public void setIndividual(Individual individual) {
		this.individual = individual;
	}
	public String toString(){
		return this.getClientType().toString();
	}
	
}
