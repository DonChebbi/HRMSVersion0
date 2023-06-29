package com.ayouForItSolutions.v1.services.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayouForItSolutions.v1.dtos.AddPosteDto;
import com.ayouForItSolutions.v1.entities.concretes.Poste;
import com.ayouForItSolutions.v1.repositories.DirDeptRepository;
import com.ayouForItSolutions.v1.repositories.PosteRepository;
import com.ayouForItSolutions.v1.services.abstracts.PosteService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.DataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessDataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessResult;

@Service
public class GestionnairePoste implements PosteService {
	private PosteRepository posteRepository;
	private DirDeptRepository dirDeptRepsoitory;

	
	@Autowired
	public GestionnairePoste(PosteRepository posteRepository, DirDeptRepository dirDeptRepsoitory) {
		this.posteRepository = posteRepository;
		this.dirDeptRepsoitory = dirDeptRepsoitory;
	}


	@Override
	public Result add(AddPosteDto poste) {
		Poste nouvPoste = new Poste();
		nouvPoste.setCompetance_req(poste.getCompetance_req());
		nouvPoste.setDate_deb(poste.getDate_deb());
		nouvPoste.setDesc_emploi(poste.getDesc_emploi());
		nouvPoste.setExigence_emploi(poste.getExigence_emploi());
		nouvPoste.setFormation_req(poste.getFormation_req());
		nouvPoste.setTitre_emploi(poste.getTitre_emploi());
		nouvPoste.setDirDept(dirDeptRepsoitory.getDirDept(poste.getDirDept_id()));
		nouvPoste.setDureeContrat(poste.getDureeContrat());
		posteRepository.save(nouvPoste);
		return new SuccessResult( "Votre demande de recrutement d'un employé a été envoyé avec succée");
	}
	
	@Override
	public DataResult<List<Poste>> getByDirDept(int id) {
		return new SuccessDataResult<List<Poste>>(posteRepository.getByDirDept(id));
		
	}
	
	@Override
	public DataResult<List<Poste>> getAllNew() {
		return new SuccessDataResult<List<Poste>>(posteRepository.getAllNew());
	}
	
	@Override
	public DataResult<List<Poste>> getAllOld() {
		return new SuccessDataResult<List<Poste>>(posteRepository.getAllOld());
	}
	
	@Override
    public Result accepter(int id) {
		posteRepository.accepter(id);
		return new SuccessResult("La demande de recrutement est acceptée");
    }
	@Override
    public Result refuser(int id) {
		posteRepository.refuser(id);
        return new SuccessResult("La demande de recrutement est refusé");
    }
	
	
	

}
