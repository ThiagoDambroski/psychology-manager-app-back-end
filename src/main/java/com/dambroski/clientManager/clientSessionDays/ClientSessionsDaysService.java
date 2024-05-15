package com.dambroski.clientManager.clientSessionDays;

import java.util.List;

public interface ClientSessionsDaysService  {

	List<ClientSessionDays> getAll();

	ClientSessionDays post(ClientSessionDays sessionsDays, Long clientId);

	ClientSessionDays put(ClientSessionDays newSessionsDays, Long sessionDayId);

}
