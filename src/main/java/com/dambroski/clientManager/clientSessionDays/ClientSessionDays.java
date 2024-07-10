package com.dambroski.clientManager.clientSessionDays;

import java.util.Date;
import java.util.List;

import com.dambroski.clientManager.Pagament.Pagament;
import com.dambroski.clientManager.client.Client;
import com.dambroski.clientManager.clientSession.ClientSession;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientSessionDays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientSessionDaysId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "client_id", referencedColumnName = "clientId")
	@JsonIgnoreProperties("daysOfSession")
	private Client client;
	
	private SessionsDays dayOfSession;
	
	private String timeOfSession;
	
	private String durationOfSession;
	
	private boolean everyWeek;
	

}
