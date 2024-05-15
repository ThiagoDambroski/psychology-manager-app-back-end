package com.dambroski.clientManager.clientSessionDays;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.clientManager.client.Client;
import com.dambroski.clientManager.client.ClientRepository;
import com.dambroski.clientManager.erros.ClientNotFoundException;
import com.dambroski.clientManager.erros.ClientSessionNotFoundException;

@Service
public class ClientSessionDaysServiceImpl implements ClientSessionsDaysService {
	
	@Autowired
	ClientSessionsDaysRepository repository;
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<ClientSessionDays> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public ClientSessionDays post(ClientSessionDays sessionsDays, Long clientId) {
		
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ClientNotFoundException("Client Not Found"));
		
		sessionsDays.setClient(client);
		
		return repository.save(sessionsDays);
	}

	@Override
	public ClientSessionDays put(ClientSessionDays newSessionsDays, Long sessionDayId) {
		
		ClientSessionDays clientSession = repository.findById(sessionDayId)
				.orElseThrow(() -> new ClientSessionNotFoundException("Client Session Day Not found"));
		
		if(Objects.nonNull(newSessionsDays.getDayOfSession())) {
			clientSession.setDayOfSession(newSessionsDays.getDayOfSession());
		}
		if(Objects.nonNull(newSessionsDays.getTimeOfSession())) {
			clientSession.setTimeOfSession(newSessionsDays.getTimeOfSession());
		}
		if(Objects.nonNull(newSessionsDays.getDurationOfSession())) {
			clientSession.setDurationOfSession(newSessionsDays.getDurationOfSession());
		}
		
		return repository.save(clientSession);
	}

}
