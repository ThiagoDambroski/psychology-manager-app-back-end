package com.dambroski.clientManager.clientSession;

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
@RequestMapping("/sessions")
public class ClientSessionController {
	
	@Autowired
	ClientSessionService service;
	
	@GetMapping("/getAll")
	public List<ClientSession> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getByClientId/{clientId}")
	public List<ClientSession> getByClientId(@PathVariable("clientId") Long clientId){
		return service.getByClientId(clientId);
	}
	
	@PostMapping("/post/{clientId}")
	public ClientSession post(@RequestBody ClientSession session,@PathVariable("clientId") Long clientId) {
		return service.post(session,clientId);
	}
	
	@PutMapping("/put/{clientSessionId}")
	public ClientSession put(@RequestBody ClientSession newClientSession,@PathVariable("clientSessionId") 
	Long clientSessionId) {
		return service.put(newClientSession,clientSessionId);
	}
	
	
	
}
