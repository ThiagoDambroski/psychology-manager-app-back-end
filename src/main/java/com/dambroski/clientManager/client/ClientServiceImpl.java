package com.dambroski.clientManager.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.clientManager.Pagament.Pagament;
import com.dambroski.clientManager.clientSession.ClientSession;
import com.dambroski.clientManager.clientSessionDays.ClientSessionDays;
import com.dambroski.clientManager.erros.ClientNotFoundException;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository repository;

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Client post(Client client) {
		
		List<ClientSession> emptySessions = new ArrayList<>();
		
		List<ClientSessionDays> emptySessionsDay = new ArrayList<>();
		
		List<Pagament> pagamentHistory = new ArrayList<>();
		
		client.setSessions(emptySessions);
		client.setDaysOfSession(emptySessionsDay);
		client.setPagamentHistory(pagamentHistory);
		
		client.setActive(true);
		
		return repository.save(client);
	}

	@Override
	public Client put(Client client, Long clientId) {
		
		Client oldClient = repository.findById(clientId)
				.orElseThrow(() -> new ClientNotFoundException("Client not found"));
		
		if(Objects.nonNull(client.getName())) {
			oldClient.setName(client.getName());
		}
		
		if(Objects.nonNull(client.getBirthDate())) {
			oldClient.setBirthDate(client.getBirthDate());
		}
		
		if(Objects.nonNull(client.getPayday())) {
			oldClient.setPayday(client.getPayday());
		}
		
		
		return repository.save(oldClient);
	}

}
