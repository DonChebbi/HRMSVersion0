package com.ayouForItSolutions.v1.services.concretes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayouForItSolutions.v1.dtos.AddEmpDto;
import com.ayouForItSolutions.v1.dtos.DeleteEmpDto;
import com.ayouForItSolutions.v1.dtos.ModifHoraireDto;
import com.ayouForItSolutions.v1.dtos.UpdateEmpDto;
import com.ayouForItSolutions.v1.entities.concretes.Conges;
import com.ayouForItSolutions.v1.entities.concretes.Employe;
import com.ayouForItSolutions.v1.entities.concretes.Horaire;
import com.ayouForItSolutions.v1.repositories.CongesRepository;
import com.ayouForItSolutions.v1.repositories.DeptRepository;
import com.ayouForItSolutions.v1.repositories.EmployeRepository;
import com.ayouForItSolutions.v1.repositories.HoraieRepository;
import com.ayouForItSolutions.v1.services.abstracts.EmployeService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessResult;

import com.ayouForItSolutions.v1.servicesPublics.resultats.DataResult;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;
import com.ayouForItSolutions.v1.servicesPublics.resultats.SuccessDataResult;

@Service
public class GestionnaireEmploye implements EmployeService {
	private EmployeRepository employeRepository;
	private DeptRepository deptRepository;
	private HoraieRepository horaireRepository;
	private CongesRepository congesRepository;
	
	@Autowired
	public GestionnaireEmploye(EmployeRepository employeRepository, DeptRepository deptRepository,
			HoraieRepository horaireRepository, CongesRepository congesRepository) {
		super();
		this.employeRepository = employeRepository;
		this.deptRepository = deptRepository;
		this.horaireRepository = horaireRepository;
		this.congesRepository = congesRepository;
	}
	@Override
	public Result delete(DeleteEmpDto emp) {
		List<Conges> conges = congesRepository.getAllCongesForEmp(emp.getId());
		
		for(Conges conge : conges){
			congesRepository.delete(conge);
		}
		
		employeRepository.deleteById(emp.getId());
		return new SuccessResult("L'Employé a bien supprimer");
	}
	
	

	@Override
	public Result add(AddEmpDto emp) {
		Employe newEmp = new Employe();
		List<Horaire> listHoraire = new ArrayList<>();
		String timeString = "00:00";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	    LocalTime time = LocalTime.parse(timeString, formatter);
		newEmp.setNom(emp.getNom());
		newEmp.setPrenom(emp.getPrenom());
		LocalDate dateRej = LocalDate.parse(emp.getDateRejoindre());
		newEmp.setDateRej(dateRej);
		LocalDate dob = LocalDate.parse(emp.getDatedenaissance());
		newEmp.setDob(dob);
		newEmp.setUsername(emp.getUsername());
		newEmp.setPassword(emp.getPassword());
		newEmp.setNumTel(emp.getNumDeTel());
		newEmp.setPoste(emp.getPoste());
		double salaire = Double.parseDouble(emp.getSalaire());
		newEmp.setSalaire(salaire);
		int id = Integer.parseInt(emp.getIdDept());
		newEmp.setDepartement(deptRepository.getDepartementById(id));
		int dureeContrat = Integer.parseInt(emp.getDureeContrat());
		newEmp.setDureeContrat(dureeContrat);
		newEmp.setTypeContrat(emp.getTypeContrat());
		newEmp = employeRepository.save(newEmp);
		for (int i = 1; i <= 5; i++) {
			Horaire newHoraire = new Horaire();
			newHoraire.setHeure_debut(time);
			newHoraire.setHeure_fin(time);
			newHoraire.setEmploye(newEmp);
			newHoraire = horaireRepository.save(newHoraire);
			listHoraire.add(newHoraire);
        }
		newEmp.setHoraires(listHoraire);
		return new SuccessResult( "l'Employé est ajouté");
	}
	@Override
	public DataResult<List<Employe>> getAllSaved() {
		return new SuccessDataResult<List<Employe>>(employeRepository.getAll());
		
	}
	/*@Override
	public DataResult<List<Employe>> getAllEmpGoingDelete(){
		return new SuccessDataResult<List<Employe>>(employeRepository.vaSupprimer());
	}*/
	@Override
    public DataResult<Employe> getAllById(int id) {
        return new SuccessDataResult<Employe>("voici l'employé pour le modifier", employeRepository.getAllById(id));
    }
	@Override
    public Result update(UpdateEmpDto emp) {
		/*System.out.println(emp.getId());
		Employe nouveau = new Employe();
        nouveau.setDateRej(employeRepository.getAllById(emp.getId()).getDateRej());
        nouveau.setDepartement(employeRepository.getAllById(emp.getId()).getDepartement());
        nouveau.setDob(emp.getDob());
        nouveau.setNom(emp.getNom());
        nouveau.setPrenom(emp.getPrenom());
        nouveau.setNumTel(emp.getNumTel());
        nouveau.setPassword(emp.getPassword());
        nouveau.setPoste(emp.getPoste());
        double sal = Double.parseDouble(emp.getSalaire());
		nouveau.setSalaire(sal);
		nouveau.setUsername(emp.getUsername());
		employeRepository.deleteById(emp.getId());
		employeRepository.save(nouveau);*/
		employeRepository.update(emp.getNom(), emp.getPrenom(), emp.getNumTel(), emp.getDob(), emp.getUsername(), emp.getPassword() ,emp.getTypeContrat(), emp.getDureeContrat(), emp.getId());
        return new SuccessResult("L'employé a bien Modifié");
    }
	@Override
	public DataResult<List<Employe>> getAllEmpByDept(int id) {
		Employe emp = employeRepository.getAllById(id);
		return new SuccessDataResult<List<Employe>>(deptRepository.getEmpByDeptId(emp.getDepartement().getId_dept()));
	}
	@Override
	public Result ModifHoraireEmpById(ModifHoraireDto dto) {
		dto.getId_emp();
		Integer id = Integer.parseInt(dto.getId_emp());
		LocalTime lundi_hd = LocalTime.parse(dto.getLundi_hd());
		LocalTime lundi_hf = LocalTime.parse(dto.getLundi_hf());
		LocalTime mardi_hd = LocalTime.parse(dto.getMardi_hd());
		LocalTime mardi_hf = LocalTime.parse(dto.getMardi_hf());
		LocalTime mercredi_hd = LocalTime.parse(dto.getMercredi_hd());
		LocalTime mercredi_hf = LocalTime.parse(dto.getMercredi_hf());
		LocalTime jeudi_hd = LocalTime.parse(dto.getJeudi_hd());
		LocalTime jeudi_hf = LocalTime.parse(dto.getJeudi_hf());
		LocalTime vendredi_hd = LocalTime.parse(dto.getVendredi_hd());
		LocalTime vendredi_hf = LocalTime.parse(dto.getVendredi_hf());
		List<Horaire> horaires = employeRepository.getAllHoraireEmp(id);
		Horaire horaire_lundi = horaires.get(0);
		horaire_lundi.setHeure_debut(lundi_hd);
		horaire_lundi.setHeure_fin(lundi_hf);
		Horaire horaire_mardi = horaires.get(1);
		horaire_mardi.setHeure_debut(mardi_hd);
		horaire_mardi.setHeure_fin(mardi_hf);
		Horaire horaire_mercredi = horaires.get(2);
		horaire_mercredi.setHeure_debut(mercredi_hd);
		horaire_mercredi.setHeure_fin(mercredi_hf);
		Horaire horaire_jeudi = horaires.get(3);
		horaire_jeudi.setHeure_debut(jeudi_hd);
		horaire_jeudi.setHeure_fin(jeudi_hf);
		Horaire horaire_vendredi = horaires.get(04);
		horaire_vendredi.setHeure_debut(vendredi_hd);
		horaire_vendredi.setHeure_fin(vendredi_hf);
		return new SuccessResult("L'employé a bien Modifié");
	}
	

}
