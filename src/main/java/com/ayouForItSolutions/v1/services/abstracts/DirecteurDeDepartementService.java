package com.ayouForItSolutions.v1.services.abstracts;

import java.util.List;

import com.ayouForItSolutions.v1.dtos.AddDirDeptDto;
import com.ayouForItSolutions.v1.dtos.DeleteDirDeptDto;
import com.ayouForItSolutions.v1.dtos.UpdateDirDeptDto;
import com.ayouForItSolutions.v1.entities.concretes.DirecteurDeDepartement;
import com.ayouForItSolutions.v1.entities.concretes.Employe;
import com.ayouForItSolutions.v1.servicesPublics.resultats.DataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;

public interface DirecteurDeDepartementService {

	DataResult<List<DirecteurDeDepartement>> getAll();

	Result update(UpdateDirDeptDto dirDept);

	Result add(AddDirDeptDto dirDeptDto);

	Result delete(DeleteDirDeptDto dirDept);

	DataResult<DirecteurDeDepartement> getDirDeptById(int id);

	DataResult<List<Employe>> getAllEmpByDept(int id);
	
}
