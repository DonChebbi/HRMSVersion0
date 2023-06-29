package com.ayouForItSolutions.v1.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

import com.ayouForItSolutions.v1.entities.abstracts.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Employe")
public class Employe extends Utilisateur{
	
	@Column(name = "salaire")
	private double salaire;
	
	@Column(name = "poste")
	private String poste;
	
	@Column(name = "typeContrat")
	private String typeContrat;
	
	@Column(name = "DureeContrat")
	private int dureeContrat;
	
	@ManyToOne
    @JoinColumn(name = "departement_id")
	@JsonIgnore
    private Departement departement;
	
	@OneToMany(mappedBy = "employe")
	private List<Horaire> horaires;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employe")
    private List<Conges> congesList;
	
	@OneToMany(mappedBy = "employe")
	private List<Pointage> pointages;
	
	@Override
	public String getRole() {
		return "Employe";
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public int getDureeContrat() {
		return dureeContrat;
	}

	public void setDureeContrat(int dureeContrat) {
		this.dureeContrat = dureeContrat;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Horaire> getHoraires() {
		return horaires;
	}

	public void setHoraires(List<Horaire> horaires) {
		this.horaires = horaires;
	}

	public List<Conges> getCongesList() {
		return congesList;
	}

	public void setCongesList(List<Conges> congesList) {
		this.congesList = congesList;
	}

	public List<Pointage> getPointages() {
		return pointages;
	}

	public void setPointages(List<Pointage> pointages) {
		this.pointages = pointages;
	}

	public Employe(int id, String nom, String prenom, String username, String password, LocalDate dateRej,
			String numTel, LocalDate dob, double salaire, String poste, String typeContrat, int dureeContrat,
			Departement departement, List<Horaire> horaires, List<Conges> congesList, List<Pointage> pointages) {
		super(id, nom, prenom, username, password, dateRej, numTel, dob);
		this.salaire = salaire;
		this.poste = poste;
		this.typeContrat = typeContrat;
		this.dureeContrat = dureeContrat;
		this.departement = departement;
		this.horaires = horaires;
		this.congesList = congesList;
		this.pointages = pointages;
	}

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
		this.congesList = null;
		this.horaires = null;
		this.pointages = null;
	}

	public Employe(int id, String nom, String prenom, String username, String password, LocalDate dateRej,
			String numTel, LocalDate dob) {
		super(id, nom, prenom, username, password, dateRej, numTel, dob);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	



	
}