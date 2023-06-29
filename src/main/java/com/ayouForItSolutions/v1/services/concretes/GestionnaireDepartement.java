package com.ayouForItSolutions.v1.services.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayouForItSolutions.v1.repositories.DeptRepository;
import com.ayouForItSolutions.v1.dtos.AddDeptDto;
import com.ayouForItSolutions.v1.dtos.DeleteDeptDto;
import com.ayouForItSolutions.v1.entities.concretes.Departement;
import com.ayouForItSolutions.v1.entities.concretes.DirecteurDeDepartement;
import com.ayouForItSolutions.v1.entities.concretes.Employe;
import com.ayouForItSolutions.v1.services.abstracts.DepartementService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.FailResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessDataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.DataResult;

@Service
public class GestionnaireDepartement implements DepartementService {
	private DeptRepository deptRep;
	
	@Autowired
	public GestionnaireDepartement(DeptRepository deptRep) {
		this.deptRep = deptRep;
	}
	
	
	@Override
	public Result add(AddDeptDto dept) {
		Departement newDept = new Departement();
		newDept.setNomDept(dept.getNomdept());
		newDept.setDescDept(dept.getDescdept());
		newDept.setDirDept(null);
		deptRep.save(newDept);
		return new SuccessResult( "Nouveau Departement Ajouté");
	}

	@Override
	public Result delete(DeleteDeptDto dept) {
		DirecteurDeDepartement dirDept = deptRep.getDirDeptByDeptId(dept.getId_dept());
		List<Employe> emp = deptRep.getEmpByDeptId(dept.getId_dept());
		if (dirDept == null && (emp == null || emp.isEmpty()) ) {
			deptRep.deleteById(dept.getId_dept());
			return new SuccessResult("Le Departement a bien supprimer");
		}
		else {
			
			return new FailResult("Vous n'avez pas le droit de supprimer un departement qui contient un ou plusieur Employe au minimum");
		}
	}
	@Override
	public DataResult<List<Departement>> getAll() {
		return new SuccessDataResult<List<Departement>>("voici tous les départements",deptRep.findAll());
	}


	@Override
	public DataResult<List<Departement>> deptEmptyGet() {
		return new SuccessDataResult<List<Departement>>("voici tous les départements vides",deptRep.deptEmptyGet());
	}
}
