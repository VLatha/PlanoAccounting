package org.latha.intuit.accounts.util;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.latha.intuit.accounts.model.Client;
import org.latha.intuit.accounts.model.GetAllClientsResponse;

public class ResponseUtil {
	public static  GetAllClientsResponse createSuccessResponse(String message, List<Client> data) {
		GetAllClientsResponse getAllClientsResponse = new GetAllClientsResponse();
		getAllClientsResponse.setMessage(message);
		getAllClientsResponse.setResponse(data);
		getAllClientsResponse.setStatusCode(Status.OK.getStatusCode());
		return getAllClientsResponse;
	}
	
	public static GetAllClientsResponse createFailureResponse(String message,Integer status) {
		GetAllClientsResponse response = new GetAllClientsResponse();
		response.setMessage(message);
		if(status != null)
			response.setStatusCode(status);
		else
			response.setStatusCode(Status.INTERNAL_SERVER_ERROR.getStatusCode());
		return response;
	}

}
