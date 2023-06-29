package com.ayouForItSolutions.v1.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

import com.ayouForItSolutions.v1.entities.abstracts.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Table(name = "dirdept")
@Entity
public class DirecteurDeDepartement extends Utilisateur {
	
	@Column(name = "salaire")
	private double salaire;
	
	@Column(name = "typeContrat")
	private String typeContrat;
	
	@Column(name = "DureeContrat")
	private int dureeContrat;

	@Override
	public String getRole() {
		return "Directeur De Departement";
	}
	
	
	@OneToOne(mappedBy = "dirDept")
		private Departement dept;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dirDept")
	private List<Poste> postes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dirDept")
	private List<Pointage> pointages;

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
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

	public Departement getDept() {
		return dept;
	}

	public void setDept(Departement dept) {
		this.dept = dept;
	}

	public List<Poste> getPostes() {
		return postes;
	}

	public void setPostes(List<Poste> postes) {
		this.postes = postes;
	}

	public List<Pointage> getPointages() {
		return pointages;
	}

	public void setPointages(List<Pointage> pointages) {
		this.pointages = pointages;
	}

	public DirecteurDeDepartement(int id, String nom, String prenom, String username, String password,
			LocalDate dateRej, String numTel, LocalDate dob, double salaire, String typeContrat, int dureeContrat,
			Departement dept, List<Poste> postes, List<Pointage> pointages) {
		super(id, nom, prenom, username, password, dateRej, numTel, dob);
		this.salaire = salaire;
		this.typeContrat = typeContrat;
		this.dureeContrat = dureeContrat;
		this.dept = dept;
		this.postes = postes;
		this.pointages = pointages;
	}

	public DirecteurDeDepartement() {
		super();
		this.pointages = null;
		this.postes = null;
	}

	public DirecteurDeDepartement(int id, String nom, String prenom, String username, String password,
			LocalDate dateRej, String numTel, LocalDate dob) {
		super(id, nom, prenom, username, password, dateRej, numTel, dob);
		// TODO Auto-generated constructor stub
	}
	
	

	
}
