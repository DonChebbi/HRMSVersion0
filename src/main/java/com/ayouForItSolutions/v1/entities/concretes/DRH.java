package com.ayouForItSolutions.v1.entities.concretes;

import java.time.LocalDate;

import jakarta.persistence.*;
import com.ayouForItSolutions.v1.entities.abstracts.Utilisateur;

@Table(name = "DRH")
@Entity
public class DRH extends Utilisateur {
	
	@Override
	public String getRole() {
		return "DRH";
	}

	public DRH() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DRH(int id, String nom, String prenom, String username, String password, LocalDate dateRej, String numTel,
			LocalDate dob) {
		super(id, nom, prenom, username, password, dateRej, numTel, dob);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
