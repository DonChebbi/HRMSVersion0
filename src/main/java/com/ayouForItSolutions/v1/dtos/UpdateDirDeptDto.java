package com.ayouForItSolutions.v1.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDirDeptDto {
	private int id;
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private String numTel;
	private LocalDate dob;

}
