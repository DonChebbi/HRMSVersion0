package com.ayouForItSolutions.v1.dtos;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCongesDto {
	
	private String date_d;
	private String date_f;
	private String motif;
	private String type_conge;
	private int id_emp;
	
}
