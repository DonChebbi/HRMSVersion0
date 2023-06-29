package com.ayouForItSolutions.v1.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmpDto {
	private int id;
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private String poste;
	private String salaire;
	private String numTel;
	private LocalDate dob;
	private String typeContrat;
	private int dureeContrat;
}
