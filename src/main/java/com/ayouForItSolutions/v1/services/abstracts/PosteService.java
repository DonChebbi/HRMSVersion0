package com.ayouForItSolutions.v1.services.abstracts;

import java.util.List;

import com.ayouForItSolutions.v1.dtos.AddPosteDto;
import com.ayouForItSolutions.v1.entities.concretes.Poste;
import com.ayouForItSolutions.v1.servicesPublics.resultats.DataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;

public interface PosteService {

	Result add(AddPosteDto poste);

	DataResult<List<Poste>> getByDirDept(int id);

	DataResult<List<Poste>> getAllNew();

	DataResult<List<Poste>> getAllOld();

	Result refuser(int id);

	Result accepter(int id);

}
