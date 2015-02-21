package xpadro.spring.rest.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xpadro.spring.rest.simple.service.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
	@Autowired
	private ClientService service;
	
	@RequestMapping(value="/{clientId}", method = RequestMethod.GET)
	public String getProductName(@PathVariable String clientId) {
		return service.getClientName(clientId);
	}
}
