package org.latha.intuit.accounts.database;

import java.util.HashMap;
import java.util.Map;

import org.latha.intuit.accounts.model.Client;

public class DatabaseClass {
	
	private static Map<Integer, Client> clients= new HashMap<>();
	
	public static Map<Integer, Client> getClients(){
		return clients;
	}
	
}
