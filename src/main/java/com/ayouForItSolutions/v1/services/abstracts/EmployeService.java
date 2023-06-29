package com.ayouForItSolutions.v1.services.abstracts;

import java.util.List;

import com.ayouForItSolutions.v1.dtos.AddEmpDto;
import com.ayouForItSolutions.v1.dtos.DeleteEmpDto;
import com.ayouForItSolutions.v1.dtos.ModifHoraireDto;
import com.ayouForItSolutions.v1.dtos.UpdateEmpDto;
import com.ayouForItSolutions.v1.entities.concretes.Employe;
import com.ayouForItSolutions.v1.entities.concretes.Horaire;
import com.ayouForItSolutions.v1.servicesPublics.resultats.DataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;

public interface EmployeService {
    DataResult<List<Employe>> getAllSaved();
	Result update(UpdateEmpDto emp);
	DataResult<Employe> getAllById(int id);
	Result add(AddEmpDto emp);
	Result delete(DeleteEmpDto emp);
	DataResult<List<Employe>> getAllEmpByDept(int id);
	Result ModifHoraireEmpById(ModifHoraireDto dto);
}
