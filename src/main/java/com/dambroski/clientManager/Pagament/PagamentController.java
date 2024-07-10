package com.dambroski.clientManager.Pagament;

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
@RequestMapping("/pagament")
public class PagamentController {
	
	@Autowired
	PagamentService service;
	
	@GetMapping("/getAll")
	public List<Pagament> getAllPagament() {
		return service.getAll();
	}
	
	@GetMapping("/getById/{clientId}")
	public List<Pagament> getByClientId(@PathVariable("clientId") Long clientId){
		return service.getByClientId(clientId);
	}
	
	
	@PostMapping("/post/{clientId}")
	public Pagament postPagament(@RequestBody Pagament pagament, @PathVariable("clientId") Long clientId) {
		return service.post(pagament,clientId);
	}
	
	@PutMapping("/put/{pagamentId}")
	public Pagament putPagament(@RequestBody Pagament pagament, @PathVariable("pagamentId") Long pagamentId) {
		return service.put(pagament,pagamentId);
	}

}
