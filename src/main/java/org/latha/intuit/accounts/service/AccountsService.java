package org.latha.intuit.accounts.service;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.latha.intuit.accounts.database.dao.ClientDAO;
import org.latha.intuit.accounts.database.daoImpl.ClientDAOImpl;
import org.latha.intuit.accounts.model.Client;
import org.latha.intuit.accounts.model.GetAllClientsResponse;
import org.latha.intuit.accounts.util.ResponseUtil;


public class AccountsService {
	
	ClientDAO clientDao = new ClientDAOImpl();
	public GetAllClientsResponse getAllClients(String clientType){
		String message = null;
		if(null != clientType && (clientType== "INDIVIDUAL" || clientType=="BUSINESS")){
		List<Client> clients= clientDao.getAllClients(clientType);
		return ResponseUtil.createSuccessResponse("All clients retrieved", clients);
		}
		else {
			message = "clientType is null or invalid ";	
			int statuscode= Status.BAD_REQUEST.getStatusCode();
			return ResponseUtil.createFailureResponse(message, statuscode);
		}
	}
	
	public GetAllClientsResponse getClient(String id) {
		String message = null;
		if ((!id.equals(null)) && (!id.equals(""))) {
			List<Client> clients = clientDao.getClient(Integer.valueOf(id));
			if (clients.size() > 0)
				return ResponseUtil.createSuccessResponse("client info retrieved", clients);
			else {
				message = "No data found for the id: " + id;
				int statuscode= Status.NOT_FOUND.getStatusCode();
				return ResponseUtil.createFailureResponse(message, statuscode);
			}
		} else {
			message = "id cant be null ";
			int statuscode= Status.BAD_REQUEST.getStatusCode();
			return ResponseUtil.createFailureResponse(message, statuscode);
		}
	}
	
	public GetAllClientsResponse addClient(Client client) {
		String message = null;
		System.out.println("client request " + client.getClientType());
		boolean isExistingClient = clientDao.isExistingClient(client);
		if (isExistingClient) {
			message = "client already exists in database";
			int statuscode= Status.CONFLICT.getStatusCode();
			return ResponseUtil.createFailureResponse(message, statuscode);
		} else {
			List<Client> clients = clientDao.addClient(client);
			if (clients.size() > 0)
				return ResponseUtil.createSuccessResponse(
						"client info retrieved", clients);
			else {
				message = "Unable to add client";
				int statuscode= Status.BAD_REQUEST.getStatusCode();
				return ResponseUtil.createFailureResponse(message, statuscode);
			}
		}
	}
	
	
}
