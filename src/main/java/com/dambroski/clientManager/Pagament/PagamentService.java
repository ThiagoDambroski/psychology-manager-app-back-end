package com.dambroski.clientManager.Pagament;

import java.util.List;

public interface PagamentService {

	List<Pagament> getAll();

	Pagament post(Pagament pagament, Long clientId);

	Pagament put(Pagament pagament, Long pagamentId);

}
