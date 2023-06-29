package com.ayouForItSolutions.v1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDeptDto {
	private String descdept;
	private String nomdept;
	private int directeur_id;
}
