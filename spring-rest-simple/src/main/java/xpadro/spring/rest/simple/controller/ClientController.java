package xpadro.spring.rest.simple.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
	
	@RequestMapping(value="/{clientId}", method = RequestMethod.GET)
	public String getProductName(@PathVariable String clientId) {
		return "";
	}
}
