package xpadro.spring.rest.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xpadro.spring.rest.simple.model.Client;
import xpadro.spring.rest.simple.service.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
	@Autowired
	private ClientService service;
	
	@RequestMapping(value="/{clientId}", method = RequestMethod.GET)
	public @ResponseBody Client getClientWithDelay(@PathVariable String clientId) throws InterruptedException {
		Thread.sleep(2000);
		Client client = service.getClient(clientId);
		System.out.println("Returning client " + client.getId());
		
		return client;
	}
}
