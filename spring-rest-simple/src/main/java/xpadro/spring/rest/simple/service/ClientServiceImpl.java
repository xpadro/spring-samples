package xpadro.spring.rest.simple.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
	private ConcurrentMap<String, String> clients = new ConcurrentHashMap<>();
	
	public ClientServiceImpl() {
		clients.put("C1", "John");
		clients.put("C2", "Eva");
		clients.put("C3", "Sandra");
		clients.put("C4", "Mike");
	}

	@Override
	public String getClientName(String id) {
		return clients.get(id);
	}
}
