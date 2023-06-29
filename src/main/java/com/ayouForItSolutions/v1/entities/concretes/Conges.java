package com.ayouForItSolutions.v1.entities.concretes;

import java.time.LocalDate;

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
@Table(name = "Conges")
public class Conges {
	
	@Id
    @Column(name = "id_cong")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cong;
	
	@Column(name = "date_d")
	private LocalDate date_d;
	
	@Column(name = "date_f")
	private LocalDate date_f;
	
	@Column(name = "motif")
	private String motif;
	
	@Column(name = "type_conge")
	private String type_conge;
	
	@Column(name = "decision")
	private boolean decision;
	
	@Column(name = "demande")
	private boolean demande;
	
	@Column(name = "solde_conges")
	private int solde_conges;
	
	@ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

	public int getId_cong() {
		return id_cong;
	}

	public void setId_cong(int id_cong) {
		this.id_cong = id_cong;
	}

	public LocalDate getDate_d() {
		return date_d;
	}

	public void setDate_d(LocalDate date_d) {
		this.date_d = date_d;
	}

	public LocalDate getDate_f() {
		return date_f;
	}

	public void setDate_f(LocalDate date_f) {
		this.date_f = date_f;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getType_conge() {
		return type_conge;
	}

	public void setType_conge(String type_conge) {
		this.type_conge = type_conge;
	}

	public boolean isDecision() {
		return decision;
	}

	public void setDecision(boolean decision) {
		this.decision = decision;
	}

	public boolean isDemande() {
		return demande;
	}

	public void setDemande(boolean demande) {
		this.demande = demande;
	}

	public int getSolde_conges() {
		return solde_conges;
	}

	public void setSolde_conges(int solde_conges) {
		this.solde_conges = solde_conges;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Conges(int id_cong, LocalDate date_d, LocalDate date_f, String motif, String type_conge, boolean decision,
			boolean demande, int solde_conges, Employe employe) {
		this.id_cong = id_cong;
		this.date_d = date_d;
		this.date_f = date_f;
		this.motif = motif;
		this.type_conge = type_conge;
		this.decision = decision;
		this.demande = demande;
		this.solde_conges = solde_conges;
		this.employe = employe;
	}

	public Conges() {
		this.solde_conges = 30;
		this.decision = false;
		this.demande = true;
	}
	
	
	
	
	

}
