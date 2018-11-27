package org.latha.intuit.accounts.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.latha.intuit.accounts.model.Client;
import org.latha.intuit.accounts.model.GetAllClientsResponse;
import org.latha.intuit.accounts.service.AccountsService;



@Path("/acc")
public class AccountsResource {
	
	AccountsService  accountsService = new AccountsService();
	
	@GET
	@Path("/clients/{clientType}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClients(@PathParam("clientType") String clientType){
		GetAllClientsResponse getAllClientsResponse = null;
		try {
			System.out.println("response received" + clientType);
			getAllClientsResponse = accountsService.getAllClients(clientType);
			
			System.out.println("status");
			return Response.status(Status.OK).entity(getAllClientsResponse).build();
		} catch (Exception e) {
			System.out.println("in exception");
			return Response.status(500).build();
		}
	}
	
	@GET
	@Path("/client/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientById(@PathParam("id") String id){
		GetAllClientsResponse getAllClientsResponse = null;
		try {
			System.out.println("response received in getClientById " + id);
			getAllClientsResponse = accountsService.getClient(id);
			System.out.println("status");
			return Response.status(Status.OK).entity(getAllClientsResponse).build();
		} 
		catch (Exception e) {
			System.out.println("in exception");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getClients2(){
		return "hello";

	}
	
	@POST
	@Path("/addClient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClient(Client client){
		System.out.println("resource "+client.getClientType());
		try {
			GetAllClientsResponse addedClient = accountsService.addClient(client);
			return Response.status(Status.OK).entity(addedClient).build();
		} catch (Exception e) {
			System.out.println("in exception");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}
