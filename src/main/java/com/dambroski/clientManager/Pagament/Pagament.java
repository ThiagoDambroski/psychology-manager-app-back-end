package com.dambroski.clientManager.Pagament;

import java.util.Date;
import java.util.List;

import com.dambroski.clientManager.client.Client;
import com.dambroski.clientManager.clientSession.ClientSession;
import com.dambroski.clientManager.clientSessionDays.ClientSessionDays;
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
public class Pagament {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pagamentId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName = "clientId")
	@JsonIgnoreProperties("pagamentHistory")
	private Client client;
	
	private int delay;
	
	private Date payDate;
	
	private String pagamentTags;
	
	private float value;

}
