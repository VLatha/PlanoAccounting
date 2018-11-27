package org.latha.intuit.accounts.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetAllClientsResponse {
	private int statusCode;
	private String message;
	private List<Client> response;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Client> getResponse() {
		return response;
	}
	public void setResponse(List<Client> response) {
		this.response = response;
	}
	
	
}
