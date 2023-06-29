package com.ayouForItSolutions.v1.entities.concretes;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pointage")
public class Pointage {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "temps_e")
	private LocalTime  temps_e;
	
	@Column(name = "temps_s")
	private LocalTime  temps_s;
	
	@Column(name = "date")
	private LocalDate date;
	
	@ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "directeur_id")
    private DirecteurDeDepartement dirDept;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getTemps_e() {
		return temps_e;
	}

	public void setTemps_e(LocalTime temps_e) {
		this.temps_e = temps_e;
	}

	public LocalTime getTemps_s() {
		return temps_s;
	}

	public void setTemps_s(LocalTime temps_s) {
		this.temps_s = temps_s;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public DirecteurDeDepartement getDirecteur() {
		return dirDept;
	}

	public void setDirecteur(DirecteurDeDepartement directeur) {
		this.dirDept = directeur;
	}

	public Pointage() {
		this.date =  LocalDate.now();
	}

	public Pointage(int id, LocalTime temps_e, LocalTime temps_s, LocalDate date, Employe employe,
			DirecteurDeDepartement dirDept) {
		this.id = id;
		this.temps_e = temps_e;
		this.temps_s = temps_s;
		this.date = date;
		this.employe = employe;
		this.dirDept = dirDept;
	}
	
    
    
	
	
}
