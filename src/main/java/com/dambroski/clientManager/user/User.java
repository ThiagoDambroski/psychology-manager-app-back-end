package com.dambroski.clientManager.user;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_app")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String password;

    // User configurations
    private String limitTimeOfSession;

    private String limitDurationOfSession;

    private int numberOfClientsPerPage;

    private int numberOfSessionsPerPage;

    private int numberOfPagamentsPerPage;

    private int numberOfPagamentsPerMonthPage;

   
}
