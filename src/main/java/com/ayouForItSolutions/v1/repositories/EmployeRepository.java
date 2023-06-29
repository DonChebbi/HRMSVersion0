package com.ayouForItSolutions.v1.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayouForItSolutions.v1.dtos.AuthDtoReponse;
import com.ayouForItSolutions.v1.entities.concretes.Conges;
import com.ayouForItSolutions.v1.entities.concretes.Employe;
import com.ayouForItSolutions.v1.entities.concretes.Horaire;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EmployeRepository extends JpaRepository<Employe,Integer>{

	Employe findByUsername(String username);

	Optional<Employe> findOneByUsernameAndPassword(String username, String password);
    
    @Query("SELECT id, nom, prenom, 'emp' AS role, username " +
    	       "FROM Employe WHERE id=:id")
    	AuthDtoReponse getReponse(int id);
    
    
    @Query("SELECT e FROM Employe e")
    List<Employe> getAll();
    
    @Query("SELECT e FROM Employe e WHERE e.id=:id")
	Employe getAllById(@Param("id")int id);
    
    @Query("SELECT e FROM Employe e WHERE e.username=:username AND e.password=:password")
    Employe getByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
    
    @Modifying
    @Query("UPDATE Employe e SET e.nom = ?1, e.prenom = ?2, e.numTel =?3, e.dob = ?4, e.username = ?5, e.password = ?6, e.typeContrat = ?7, e.dureeContrat = ?8 WHERE e.id = ?9")
	void update(String nom, String prenom, String numTel, LocalDate dob, String username, String password,
			String typeContrat, int dureeContrat, int id);
    
    @Query("SELECT e.congesList FROM Employe e WHERE e.id=:id")
    List<Conges> getCongesByEmpId(@Param("id")int id);
    
    @Query("SELECT e.horaires FROM Employe e WHERE e.id=:id")
    List<Horaire> getAllHoraireEmp(@Param("id")int id);
    
    
    
    
}
