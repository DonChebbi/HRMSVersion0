package com.ayouForItSolutions.v1.entities.concretes;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Horaire")
public class Horaire {
	
	@Id
    @Column(name = "id_horaire")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_horaire;
	
	@Column(name = "heure_debut")
	private LocalTime heure_debut;
	
	@Column(name = "heure_fin")
	private LocalTime heure_fin;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

	public int getId_horaire() {
		return id_horaire;
	}

	public void setId_horaire(int id_horaire) {
		this.id_horaire = id_horaire;
	}

	public LocalTime getHeure_debut() {
		return heure_debut;
	}

	public void setHeure_debut(LocalTime heure_debut) {
		this.heure_debut = heure_debut;
	}

	public LocalTime getHeure_fin() {
		return heure_fin;
	}

	public void setHeure_fin(LocalTime heure_fin) {
		this.heure_fin = heure_fin;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Horaire(int id_horaire, LocalTime heure_debut, LocalTime heure_fin, Employe employe) {
		this.id_horaire = id_horaire;
		this.heure_debut = heure_debut;
		this.heure_fin = heure_fin;
		this.employe = employe;
	}

	public Horaire() {
	}
	
	
	
	

}
