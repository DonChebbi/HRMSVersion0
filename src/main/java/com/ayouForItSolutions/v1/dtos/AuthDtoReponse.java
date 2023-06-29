package com.ayouForItSolutions.v1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDtoReponse {
	private int id;
	private String nom;
	private String prenom;
	private String username;

}