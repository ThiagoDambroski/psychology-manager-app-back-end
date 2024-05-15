package com.dambroski.clientManager.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	ClientService service;
	
	
	@GetMapping("/getAll")
	public List<Client> getAllClients(){
		return service.getAll();
	}
	
	@PostMapping("/post")
	public Client postClient(@RequestBody Client client) {
		return service.post(client);
	}
	
	@PutMapping("/put/{clientId}")
	public Client putClient(@RequestBody Client client,@PathVariable("clientId") Long clientId) {
		return service.put(client,clientId);
	}

}
