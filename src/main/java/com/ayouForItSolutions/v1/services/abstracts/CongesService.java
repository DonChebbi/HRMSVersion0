package com.ayouForItSolutions.v1.services.abstracts;

import java.util.List;

import com.ayouForItSolutions.v1.dtos.AddCongesDto;
import com.ayouForItSolutions.v1.entities.concretes.Conges;
import com.ayouForItSolutions.v1.servicesPublics.resultats.DataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;

public interface CongesService {

	Result add(AddCongesDto conge);

	DataResult<List<List<Conges>>> getCongesByDirDept(int id);

	DataResult<List<Conges>> getCongesEmploye(int id);

	Result accepter(int id);

	Result refuser(int id);

}
