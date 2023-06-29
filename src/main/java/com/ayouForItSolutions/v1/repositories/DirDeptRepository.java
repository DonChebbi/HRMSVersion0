package com.ayouForItSolutions.v1.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayouForItSolutions.v1.dtos.AuthDtoReponse;
import com.ayouForItSolutions.v1.entities.concretes.DirecteurDeDepartement;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface DirDeptRepository extends JpaRepository<DirecteurDeDepartement,Integer> {
	
	DirecteurDeDepartement findByUsername(String username);
	
	
	Optional<DirecteurDeDepartement> findOneByUsernameAndPassword(String username, String password);
    
    @Query("SELECT id, nom, prenom, 'dirDept' AS role, username " +
    	       "FROM DirecteurDeDepartement WHERE id=:id")
    	AuthDtoReponse getReponse(int id);


	@Modifying
    @Query("UPDATE DirecteurDeDepartement d SET d.nom = ?1, d.prenom = ?2, d.numTel =?3, d.dob = ?4 WHERE d.id = ?5")
    void updateNomAndPrenom(String nom, String prenom, String numDeTel, LocalDate datedenaissance, int id);
	
	@Query("SELECT d FROM DirecteurDeDepartement d WHERE d.id=:id")
	DirecteurDeDepartement getDirDept(@Param("id")int id);
	
	@Query("SELECT d.dept.id_dept FROM DirecteurDeDepartement d WHERE d.id=:id")
	int getDepartementId(@Param("id")int id);
	
	@Modifying
    @Query("UPDATE DirecteurDeDepartement d SET d.nom = ?1, d.prenom = ?2, d.numTel =?3, d.dob = ?4, d.username = ?5,d.password = ?6 WHERE d.id = ?7")
    void update(String nom, String prenom, String numDeTel, LocalDate datedenaissance, String username, String password, int id);
}
