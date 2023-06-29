package com.ayouForItSolutions.v1.entities.concretes;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Poste")
public class Poste {
	@Id
    @Column(name = "id_poste")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_poste;
	
	@Column(name = "titre_emploi")
	private String titre_emploi;
	
	@Column(name = "desc_emploi")
	private String desc_emploi;
	
	@Column(name = "exigence_emploi")
	private String exigence_emploi;
	
	@Column(name = "decision")
	private boolean decision;
	
	@Column(name = "formation_req")
	private String formation_req;
	
	@Column(name = "competance_req")
	private String competance_req;
	
	@Column(name = "duree_contrat")
	private int dureeContrat;
	
	@Column(name = "date_deb")
	private LocalDate date_deb;
	
	@Column(name = "date_demande")
	private LocalDate date_demande;
	
	@Column(name = "demande")
	private boolean demande;
	
	@ManyToOne
    @JoinColumn(name = "directeur_id")
    private DirecteurDeDepartement dirDept;

	public int getId_poste() {
		return id_poste;
	}

	public void setId_poste(int id_poste) {
		this.id_poste = id_poste;
	}

	public String getTitre_emploi() {
		return titre_emploi;
	}

	public void setTitre_emploi(String titre_emploi) {
		this.titre_emploi = titre_emploi;
	}

	public String getDesc_emploi() {
		return desc_emploi;
	}

	public void setDesc_emploi(String desc_emploi) {
		this.desc_emploi = desc_emploi;
	}

	public String getExigence_emploi() {
		return exigence_emploi;
	}

	public void setExigence_emploi(String exigence_emploi) {
		this.exigence_emploi = exigence_emploi;
	}

	public boolean isDecision() {
		return decision;
	}

	public void setDecision(boolean decision) {
		this.decision = decision;
	}

	public String getFormation_req() {
		return formation_req;
	}

	public void setFormation_req(String formation_req) {
		this.formation_req = formation_req;
	}

	public String getCompetance_req() {
		return competance_req;
	}

	public void setCompetance_req(String competance_req) {
		this.competance_req = competance_req;
	}

	public int getDureeContrat() {
		return dureeContrat;
	}

	public void setDureeContrat(int dureeContrat) {
		this.dureeContrat = dureeContrat;
	}

	public LocalDate getDate_deb() {
		return date_deb;
	}

	public void setDate_deb(LocalDate date_deb) {
		this.date_deb = date_deb;
	}

	public LocalDate getDate_demande() {
		return date_demande;
	}

	public void setDate_demande(LocalDate date_demande) {
		this.date_demande = date_demande;
	}

	public boolean isDemande() {
		return demande;
	}

	public void setDemande(boolean demande) {
		this.demande = demande;
	}

	public DirecteurDeDepartement getDirDept() {
		return dirDept;
	}

	public void setDirDept(DirecteurDeDepartement dirDept) {
		this.dirDept = dirDept;
	}

	public Poste(int id_poste, String titre_emploi, String desc_emploi, String exigence_emploi, boolean decision,
			String formation_req, String competance_req, int dureeContrat, LocalDate date_deb, LocalDate date_demande,
			boolean demande, DirecteurDeDepartement dirDept) {
		super();
		this.id_poste = id_poste;
		this.titre_emploi = titre_emploi;
		this.desc_emploi = desc_emploi;
		this.exigence_emploi = exigence_emploi;
		this.decision = decision;
		this.formation_req = formation_req;
		this.competance_req = competance_req;
		this.dureeContrat = dureeContrat;
		this.date_deb = date_deb;
		this.date_demande = date_demande;
		this.demande = demande;
		this.dirDept = dirDept;
	}

	public Poste() {
		this.demande = true;
		this.decision = false;
		this.date_demande = LocalDate.now();
	}

	

	
	
	
	

}

