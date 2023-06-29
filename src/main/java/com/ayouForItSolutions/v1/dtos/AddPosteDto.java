package com.ayouForItSolutions.v1.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPosteDto {
	
	private String titre_emploi;
	private String desc_emploi;
	private String exigence_emploi;
	private String formation_req;
	private String competance_req;
	private LocalDate date_deb;
	private int DureeContrat;
	private int dirDept_id;

}
