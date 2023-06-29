package com.ayouForItSolutions.v1.services.concretes;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayouForItSolutions.v1.entities.concretes.DRH;
import com.ayouForItSolutions.v1.entities.concretes.DirecteurDeDepartement;
import com.ayouForItSolutions.v1.entities.concretes.Employe;
import com.ayouForItSolutions.v1.repositories.DRHRepository;
import com.ayouForItSolutions.v1.repositories.DirDeptRepository;
import com.ayouForItSolutions.v1.repositories.EmployeRepository;
import com.ayouForItSolutions.v1.repositories.UtilisateurRepository;
import com.ayouForItSolutions.v1.services.abstracts.AuthenticationService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.FailResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessDataResult;
import com.ayouForItSolutions.v1.dtos.*;

@Service
public class GestionnaireAuth implements AuthenticationService {
	private DirDeptRepository dirDeptRepository;
	private DRHRepository drhRepository;
	private EmployeRepository empRepository;
	
	@Autowired
	public GestionnaireAuth(DirDeptRepository dirDeptRepository, DRHRepository drhRepository,
			EmployeRepository empRepository, UtilisateurRepository utilisateurRepository) {
		this.dirDeptRepository = dirDeptRepository;
		this.drhRepository = drhRepository;
		this.empRepository = empRepository;
	}

    @Override
    public Result  authUser(AuthDto authDto) {
        DRH drh = drhRepository.findByUsername(authDto.getUsername());
        DirecteurDeDepartement dirDept = dirDeptRepository.findByUsername(authDto.getUsername());
        Employe emp = empRepository.findByUsername(authDto.getUsername());
        if((drh != null) || (dirDept != null) || (emp != null)) {
        	if(drh != null) {
        		String password = authDto.getPassword();
        		String pwdUser = drh.getPassword();
        		if(pwdUser.equals(password)) {
        			return new SuccessDataResult<DRH>(drh);
        		} 
        		else {
        			return new FailResult("Invalide nom d'utilisateur ou mot de passe");
        		}
        	}
        	else if(dirDept != null) {
        		String password = authDto.getPassword();
        		String pwdUser = dirDept.getPassword();
        		if(pwdUser.equals(password)) {
        				return new SuccessDataResult<DirecteurDeDepartement>(dirDept);
        		}
        		else {
        				return new FailResult("Invalide nom d'utilisateur ou mot de passe");
        		}
        	}
        	else {
        		String password = authDto.getPassword();
        		String pwdUser = emp.getPassword();
        		if(pwdUser.equals(password)) {
        			return new SuccessDataResult<Employe>(emp);
        		} 
        		else {
        			return new FailResult("Invalide nom d'utilisateur ou mot de passe");
        		}
        		
        	}
        }

        
        else {
        	return new FailResult("Invalide nom d'utilisateur ou mot de passe");
        }
    }
}
