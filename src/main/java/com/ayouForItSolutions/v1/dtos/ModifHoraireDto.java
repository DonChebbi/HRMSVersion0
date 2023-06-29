package com.ayouForItSolutions.v1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifHoraireDto {
	private String lundi_hd;
    private String lundi_hf;
    private String mardi_hd;
    private String mardi_hf;
    private String mercredi_hd;
    private String mercredi_hf;
    private String jeudi_hd;
    private String jeudi_hf;
    private String vendredi_hd;
    private String vendredi_hf;
    private String id_emp;
}
