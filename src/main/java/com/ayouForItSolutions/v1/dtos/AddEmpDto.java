package com.ayouForItSolutions.v1.dtos;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmpDto {
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private String dateRejoindre;
	private String numDeTel;
	private String datedenaissance;
	private String salaire;
	private String poste;
	private String typeContrat;
	private String DureeContrat;
	private String idDept;

}
