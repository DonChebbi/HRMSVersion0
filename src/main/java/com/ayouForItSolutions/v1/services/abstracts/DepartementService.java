package com.ayouForItSolutions.v1.services.abstracts;

import java.util.List;

import com.ayouForItSolutions.v1.dtos.AddDeptDto;
import com.ayouForItSolutions.v1.dtos.DeleteDeptDto;
import com.ayouForItSolutions.v1.entities.concretes.Departement;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;

import com.ayouForItSolutions.v1.servicesPublics.resultats.DataResult;

public interface DepartementService {

	Result delete(DeleteDeptDto dept);

	Result add(AddDeptDto dept);

	DataResult<List<Departement>> getAll();

	Object deptEmptyGet();
	

}
