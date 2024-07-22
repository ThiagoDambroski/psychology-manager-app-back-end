package com.dambroski.clientManager.clientSession;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.clientManager.client.Client;
import com.dambroski.clientManager.client.ClientRepository;
import com.dambroski.clientManager.erros.ClientNotFoundException;
import com.dambroski.clientManager.erros.ClientSessionNotFoundException;

@Service
public class ClientSessionServiceImpl implements ClientSessionService {
	
	@Autowired
	ClientSessionRepository repository;
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<ClientSession> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public ClientSession post(ClientSession session, Long clientId) {
		
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ClientNotFoundException("Client not found"));
		
		session.setClient(client);
		
		
		return repository.save(session);
	}

	@Override
	public ClientSession put(ClientSession newClientSession, Long clientSessionId) {
		
		ClientSession oldClientSession = repository.findById(clientSessionId)
				.orElseThrow(() -> new ClientSessionNotFoundException("Session not found"));
		
		if(Objects.nonNull(newClientSession.isAttend())) {
			oldClientSession.setAttend(newClientSession.isAttend());
		}
		
		
		if(Objects.nonNull(newClientSession.getSessionDescription())) {
			oldClientSession.setSessionDescription(newClientSession.getSessionDescription());
		}
		if(Objects.nonNull(newClientSession.getTagsDescription())) {
			oldClientSession.setTagsDescription(newClientSession.getTagsDescription());
		}
		
		if(Objects.nonNull(newClientSession.getDate())) {
			oldClientSession.setDate(newClientSession.getDate());
		}
		
		return repository.save(oldClientSession);
	}

	@Override
	public List<ClientSession> getByClientId(Long clientId) {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ClientNotFoundException("Client not found"));
		
		List<ClientSession> allSessions = repository.findAll();
		
		List <ClientSession> clientSession = allSessions.stream().filter(session -> session.getClient()
				.equals(client)).collect(Collectors.toList());
		
		return clientSession;
	}

}
