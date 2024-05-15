package com.dambroski.clientManager.clientSessionDays;

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
@RequestMapping("/sessionsDays")
public class ClientSessionDaysController {
	
	@Autowired
	ClientSessionsDaysService service;
	
	@GetMapping("/getAll")
	public List<ClientSessionDays> getAll(){
		return service.getAll();
	}

	@PostMapping("/post/{clientId}")
	public ClientSessionDays post(@RequestBody ClientSessionDays sessionsDays, @PathVariable("clientId") 
	Long clientId) {
		return service.post(sessionsDays,clientId);
		
	}
	
	@PutMapping("/put/{sessionDaysId})")
	public ClientSessionDays put(@RequestBody ClientSessionDays newSessionsDays,
			@PathVariable("sessionDaysId")Long sessionDayId) {
		return service.put(newSessionsDays,sessionDayId);
	}
}
