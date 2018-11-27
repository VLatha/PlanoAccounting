package org.latha.intuit.accounts.database.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.latha.intuit.accounts.database.dao.ClientDAO;
import org.latha.intuit.accounts.model.Address;
import org.latha.intuit.accounts.model.Business;
import org.latha.intuit.accounts.model.Client;
import org.latha.intuit.accounts.model.ClientStatus;
import org.latha.intuit.accounts.model.Individual;


public class ClientDAOImpl implements ClientDAO {
	
	private static Map<Integer, Client> clients= new HashMap<>();
	public ClientDAOImpl(){
		Address a1=new Address("RiverView","220","San Jose","CA");
		Business b1 = new Business(1,"ABC","408679111",10000000,a1);
		Client c1= new Client(ClientStatus.BUSINESS,b1,null);
		clients.put(1,c1);
		
		Address a2=new Address("RiverView","221","Santa Clara","CA");
		Business b2 = new Business(2,"XYZ","4086792222",15000000,a2);
		Client c2= new Client(ClientStatus.BUSINESS,b2,null);
		clients.put(2,c2);

		Address a3=new Address("Verus","222","Frisco","TX");
		Individual i1 = new Individual(3,"Latha",1234567890,100000,"4086793333",a3);
		Client c3= new Client(ClientStatus.INDIVIDUAL,null,i1);
		clients.put(3,c3);
	}
	
	@Override
	public List<Client> getAllClients(String clientType) {
		List<Client> allClients = new ArrayList<>();
		// get collection
		
			for(Integer i :clients.keySet()){
				Client c= clients.get(i);
				if(clientType.equals(c.getClientType().toString()) ){
					allClients.add(c);				}
			}
		for(Client c: allClients){
			System.out.println(c.getClientType());
		}
		return allClients;
	}

	@Override
	public List<Client> addClient(Client client) {
		int id=0;
		List<Client> addedClients = new ArrayList<>();
		if(client.getClientType().equals(ClientStatus.BUSINESS)){
			client.getBusiness().setId(clients.size()+1);
			clients.put(client.getBusiness().getId(), client);
			id= client.getBusiness().getId();
		}
		if(client.getClientType().equals(ClientStatus.INDIVIDUAL)){
			client.getIndividual().setId(clients.size()+1);
			clients.put(client.getIndividual().getId(), client);
			id= client.getIndividual().getId();
		}
		System.out.println("id "+id);
			System.out.println(clients.size());
			System.out.println(clients.get(id).toString());
			addedClients.add(clients.get(id));
		return addedClients;
	}

	@Override
	public List<Client> getClient(int id) {
		List<Client> allClients = new ArrayList<>();
		for(Integer i :clients.keySet()){
			if(i == id ){
				allClients.add(clients.get(i));				}
		}
		for(Client c: allClients){
			System.out.println("client in getClient()"+c.getClientType());
		}
		return allClients;
	}

	@Override
	public boolean isExistingClient(Client client) {
		if (client.getClientType().equals(ClientStatus.INDIVIDUAL)) {
			List<Client> existingIndividualClients = getAllClients("INDIVIDUAL");
			for (Client c : existingIndividualClients) {
				if (c.getIndividual().getSsn() == client.getIndividual()
						.getSsn()) {
					return true;
				}
			}
		} else if (client.getClientType().equals(ClientStatus.BUSINESS)) {
			List<Client> existingBusinessClients = getAllClients("BUSINESS");
			for (Client c : existingBusinessClients) {
				if ((c.getBusiness().getName()).equalsIgnoreCase(client
						.getBusiness().getName())) {
					return true;
				}
			}
		}
		return false;
	}

}
