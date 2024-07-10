package com.dambroski.clientManager.clientSession;

import java.util.List;

public interface ClientSessionService {

	List<ClientSession> getAll();

	ClientSession post(ClientSession session, Long clientId);

	ClientSession put(ClientSession newClientSession, Long clientSessionId);

	List<ClientSession> getByClientId(Long clientId);

}
