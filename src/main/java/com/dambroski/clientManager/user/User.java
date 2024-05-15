package com.dambroski.clientManager.user;

import java.util.Date;
import java.util.List;

import com.dambroski.clientManager.Pagament.Pagament;
import com.dambroski.clientManager.client.Client;
import com.dambroski.clientManager.clientSession.ClientSession;
import com.dambroski.clientManager.clientSessionDays.ClientSessionDays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String name;
	
	private String password;

}
