package org.latha.intuit.accounts.database.dao;


import java.util.List;

import org.latha.intuit.accounts.model.Client;


public interface ClientDAO {
	List<Client> getAllClients(String clientType);
	List<Client> addClient(Client user);
	List<Client> getClient(int id);
	boolean isExistingClient(Client client);
}

