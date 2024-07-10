package com.dambroski.clientManager.Pagament;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.clientManager.client.Client;
import com.dambroski.clientManager.client.ClientRepository;
import com.dambroski.clientManager.clientSession.ClientSession;
import com.dambroski.clientManager.erros.ClientNotFoundException;
import com.dambroski.clientManager.erros.PagamentNotFoundException;

@Service
public class PagamentServiceImpl implements PagamentService {
	
	@Autowired
	PagamentRepository repository;
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Pagament> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Pagament post(Pagament pagament, Long clientId) {
		
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ClientNotFoundException("Client not found"));
		
		pagament.setClient(client);
		
		return repository.save(pagament);
	}

	@Override
	public Pagament put(Pagament pagament, Long pagamentId) {
		
		Pagament oldPagament = repository.findById(pagamentId)
				.orElseThrow(() -> new PagamentNotFoundException("Pagament not found"));
		
		
		if(Objects.nonNull(pagament.getPayDate())) {
			oldPagament.setPayDate(pagament.getPayDate());
		}
		
		if(Objects.nonNull(pagament.getDelay())) {
			oldPagament.setDelay(pagament.getDelay());
		}
		
		if(Objects.nonNull(pagament.getValue())) {
			oldPagament.setValue(pagament.getValue());
		}
		
		if(Objects.nonNull(pagament.getPagamentTags())) {
			oldPagament.setPagamentTags(pagament.getPagamentTags());
		}
		
		
		return repository.save(oldPagament);
	}

	@Override
	public List<Pagament> getByClientId(Long clientId) {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ClientNotFoundException("Client not found"));
		
		List<Pagament> allPagament = repository.findAll();
		
		List <Pagament> clientPagament = allPagament.stream().filter(pagament -> pagament.getClient()
				.equals(client)).collect(Collectors.toList());
		return clientPagament;
	}

}
