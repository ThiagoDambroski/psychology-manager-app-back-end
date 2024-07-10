package com.dambroski.clientManager.client;

import java.util.List;

public interface ClientService {

	List<Client> getAll();

	Client post(Client client);

	Client put(Client client, Long clientId);

	Client activeChange(Long clientId);

	void delete(Long clientId);

}
