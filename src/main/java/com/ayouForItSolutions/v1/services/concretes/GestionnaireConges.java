package com.ayouForItSolutions.v1.services.concretes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayouForItSolutions.v1.dtos.AddCongesDto;
import com.ayouForItSolutions.v1.dtos.UpdateEmpDto;
import com.ayouForItSolutions.v1.entities.concretes.Conges;
import com.ayouForItSolutions.v1.entities.concretes.Employe;
import com.ayouForItSolutions.v1.repositories.CongesRepository;
import com.ayouForItSolutions.v1.repositories.DeptRepository;
import com.ayouForItSolutions.v1.repositories.DirDeptRepository;
import com.ayouForItSolutions.v1.repositories.EmployeRepository;
import com.ayouForItSolutions.v1.services.abstracts.CongesService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.DataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessDataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessResult;

@Service
public class GestionnaireConges implements CongesService{
	private CongesRepository congesRepository;
	private EmployeRepository employeRepository;
	private DirDeptRepository dirDeptRepository;
	private DeptRepository deptRepository;
	
	@Autowired
	public GestionnaireConges(CongesRepository congesRepository, EmployeRepository employeRepository,
			DirDeptRepository dirDeptRepository, DeptRepository deptRepository) {
		super();
		this.congesRepository = congesRepository;
		this.employeRepository = employeRepository;
		this.dirDeptRepository = dirDeptRepository;
		this.deptRepository = deptRepository;
	}


	@Override
	public Result add(AddCongesDto conge) {
		Conges cong = new Conges();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		cong.setDate_d(LocalDate.parse(conge.getDate_d(), formatter));
		cong.setDate_f(LocalDate.parse(conge.getDate_f(), formatter));
		cong.setMotif(cong.getMotif());
		cong.setType_conge(cong.getType_conge());
		cong.setEmploye(employeRepository.getAllById(conge.getId_emp()));
		congesRepository.save(cong);
		return new SuccessResult( "Votre demande de congé a bien envoyé");
	}



	@Override
	public DataResult<List<List<Conges>>> getCongesByDirDept(int id) {
		
		List<List<Conges>> cong = new ArrayList<>();
		
		List<Employe> emp = this.deptRepository.getEmpByDeptId(this.dirDeptRepository.getDepartementId(id));
		for (Employe employe : emp) {
			List<Conges> employeeConges = employeRepository.getCongesByEmpId(employe.getId());
			cong.add(employeeConges);
		}
		return new SuccessDataResult<List<List<Conges>>>(cong);
		
	}
	@Override
	public DataResult<List<Conges>> getCongesEmploye(int id) {
		return new SuccessDataResult<List<Conges>>(employeRepository.getCongesByEmpId(id));
		
	}
	@Override
    public Result accepter(int id) {
		congesRepository.accepter(id);
		return new SuccessResult("La congé est acceptée");
    }
	@Override
    public Result refuser(int id) {
		congesRepository.refuser(id);
        return new SuccessResult("La congé est refusée");
    }
}
