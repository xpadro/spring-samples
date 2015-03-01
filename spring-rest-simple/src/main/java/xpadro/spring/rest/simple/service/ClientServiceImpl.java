package xpadro.spring.rest.simple.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import xpadro.spring.rest.simple.model.Client;

@Service
public class ClientServiceImpl implements ClientService {
	private ConcurrentMap<String, Client> clients = new ConcurrentHashMap<>();
	
	public ClientServiceImpl() {
		initDatabase();
	}

	@Override
	public Client getClient(String id) {
		return clients.get(id);
	}
	
	private void initDatabase() {
		clients.put("C01", new Client("C01", 1.0));
		clients.put("C02", new Client("C02", 1.0));
		clients.put("C03", new Client("C03", 1.0));
		clients.put("C04", new Client("C04", 1.0));
		clients.put("C05", new Client("C05", 1.0));
		clients.put("C06", new Client("C06", 1.0));
		clients.put("C07", new Client("C07", 1.0));
		clients.put("C08", new Client("C08", 1.0));
		clients.put("C09", new Client("C09", 1.0));
		clients.put("C10", new Client("C10", 1.0));
		clients.put("C11", new Client("C11", 1.0));
		clients.put("C12", new Client("C12", 1.0));
		clients.put("C13", new Client("C13", 1.0));
		clients.put("C14", new Client("C14", 1.0));
		clients.put("C15", new Client("C15", 1.0));
		clients.put("C16", new Client("C16", 1.0));
		clients.put("C17", new Client("C17", 1.0));
		clients.put("C18", new Client("C18", 1.0));
		clients.put("C19", new Client("C19", 1.0));
		clients.put("C20", new Client("C20", 1.0));
	}
}
