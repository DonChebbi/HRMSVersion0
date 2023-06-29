package com.ayouForItSolutions.v1.services.concretes;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayouForItSolutions.v1.dtos.AddDirDeptDto;
import com.ayouForItSolutions.v1.dtos.DeleteDirDeptDto;
import com.ayouForItSolutions.v1.dtos.UpdateDirDeptDto;
import com.ayouForItSolutions.v1.entities.concretes.DirecteurDeDepartement;
import com.ayouForItSolutions.v1.entities.concretes.Employe;
import com.ayouForItSolutions.v1.repositories.DeptRepository;
import com.ayouForItSolutions.v1.repositories.DirDeptRepository;
import com.ayouForItSolutions.v1.services.abstracts.DirecteurDeDepartementService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.DataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.FailResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessDataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessResult;



@Service
public class GestionnaireDirecteurDeDepartement implements DirecteurDeDepartementService{
	
	private DirDeptRepository dirDeptRepository;
	private DeptRepository deptRepository;

	@Autowired
	public GestionnaireDirecteurDeDepartement(DirDeptRepository dirDeptRepository, DeptRepository deptRepository) {
		this.dirDeptRepository = dirDeptRepository;
		this.deptRepository = deptRepository;
	}
	
	@Override
    public DataResult<List<DirecteurDeDepartement>> getAll() {
        return new SuccessDataResult<List<DirecteurDeDepartement>>("voila tous les directeurs de departements", dirDeptRepository.findAll());
    }

	@Override
	public Result add(AddDirDeptDto dirDeptDto) {
			DirecteurDeDepartement dirDept = new DirecteurDeDepartement();
			dirDept.setNom(dirDeptDto.getNom());
			dirDept.setPrenom(dirDeptDto.getPrenom());
			dirDept.setUsername(dirDeptDto.getUsername());
			dirDept.setPassword(dirDeptDto.getPassword());
			LocalDate dateRej = LocalDate.parse(dirDeptDto.getDateRejoindre());
			dirDept.setDateRej(dateRej);
			dirDept.setNumTel(dirDeptDto.getNumDeTel());
			LocalDate dob = LocalDate.parse(dirDeptDto.getDatedenaissance());
			dirDept.setDob(dob);
			double salaire = Double.parseDouble(dirDeptDto.getSalaire());
			dirDept.setSalaire(salaire);
			dirDept.setTypeContrat(dirDeptDto.getTypeContrat());
			int dureeContrat = Integer.parseInt(dirDeptDto.getDureeContrat());
			dirDept.setDureeContrat(dureeContrat);
			int id = Integer.parseInt(dirDeptDto.getDeptId());
			dirDept.setDept(deptRepository.getDepartementById(id));
			deptRepository.getDepartementById(id).setDirDept(dirDept);
			dirDeptRepository.save(dirDept);
			return new SuccessResult( "Le Directeur du Département a bien nommé un nouveau directeur pour superviser le département intitulé : " + deptRepository.getDepartementById(id).getNomDept() );

	}

	@Override
    public DataResult<DirecteurDeDepartement> getDirDeptById(int id) {
        return new SuccessDataResult<DirecteurDeDepartement>("voici le directeur pour le modifier", this.dirDeptRepository.getDirDept(id));
    }
	@Override
	public Result delete(DeleteDirDeptDto dirDept) {
		if((dirDeptRepository.getDirDept(dirDept.getDirDeptId()).getDept().getEmployes()) == null) {
			dirDeptRepository.deleteById(dirDept.getDirDeptId());
			return new SuccessResult("Le Directeur De Departement a bien supprimer");
		}
		else {
			return new FailResult("Vous pouvez pas de supprimer cette Directeur car il y'a ou moins un employé"); 
			
		}
	}
	@Override
	public Result update(UpdateDirDeptDto dirdept) {
		/*DirecteurDeDepartement nouveau = new DirecteurDeDepartement();
        nouveau.setDateRej((dirDeptRepository.getDirDept(dirdept.getId())).getDateRej());
        nouveau.setDept((dirDeptRepository.getDirDept(dirdept.getId())).getDept());
        nouveau.setDob(dirdept.getDob());
        nouveau.setNom(dirdept.getNom());
        nouveau.setPrenom(dirdept.getPrenom());
        nouveau.setNumTel(dirdept.getNumTel());
        nouveau.setPassword(dirdept.getPassword());
		nouveau.setUsername(dirdept.getUsername());
		dirDeptRepository.deleteById(dirdept.getId());
		dirDeptRepository.save(nouveau);
        return new SuccessResult("Le Directeur De Département a bien Modifié");*/
		dirDeptRepository.update(dirdept.getNom(), dirdept.getPrenom(), dirdept.getNumTel(), dirdept.getDob(), dirdept.getUsername(), dirdept.getPassword(), dirdept.getId());
		return new SuccessResult("Le Directeur De Département a bien Modifié");
		
    }
	
	@Override
	public DataResult<List<Employe>> getAllEmpByDept(int id) {
        return new SuccessDataResult<List<Employe>>(deptRepository.getEmpByDeptId(dirDeptRepository.getDepartementId(id)));
    }
	
	
	
	
	
	

}
