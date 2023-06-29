package com.ayouForItSolutions.v1.services.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ayouForItSolutions.v1.repositories.EmployeRepository;
import com.ayouForItSolutions.v1.services.abstracts.DrhService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;

@Service
public class GestionnaireDrh implements DrhService{
	private EmployeRepository employeRepository;

	@Autowired
	public GestionnaireDrh(EmployeRepository employeRepository) {
		this.employeRepository = employeRepository;
	}
	
	@Override
	public Result addEmploye() {
		
		//Employe emp = new Employe();
		//emp.setPrenom("Firas");
		//emp.setNom("Chebbi");
		//emp.setNumTel("22991706");
		//emp.setSalaire(1200);
		//emp.setPoste("Developpeur");
		//emp.setDob(LocalDate.of(1999, 6, 1));
		//emp.setDateRej(LocalDate.now());
		//emp.setDemand(true);
		//emp.setDecision(false);
		//emp.setUsername("firas010203");
		//emp.setPassword("123456789");
		//employeRepository.save(emp);
		//return new SuccessResult("La demande a été envoyé");
		return null;
	}
	
	
}
