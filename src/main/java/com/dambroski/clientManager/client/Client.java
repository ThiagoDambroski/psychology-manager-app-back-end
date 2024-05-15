package com.dambroski.clientManager.client;

import java.util.Date;
import java.util.List;

import com.dambroski.clientManager.Pagament.Pagament;
import com.dambroski.clientManager.clientSession.ClientSession;
import com.dambroski.clientManager.clientSessionDays.ClientSessionDays;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientId;
	
	private String name;
	
	private Date birthDate;
	
	private int payday;
	
	@OneToMany(mappedBy = "client")
	@JsonIgnoreProperties("client")
	private List<ClientSession> sessions;
	
	@OneToMany(mappedBy = "client")
	@JsonIgnoreProperties("client")
	private List<ClientSessionDays> daysOfSession;
	
	@OneToMany(mappedBy = "client")
	@JsonIgnoreProperties("client")
	private List<Pagament> pagamentHistory;
	
	
	private boolean active;
	
	
	
	
}
