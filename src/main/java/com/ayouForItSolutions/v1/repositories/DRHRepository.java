package com.ayouForItSolutions.v1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ayouForItSolutions.v1.dtos.AuthDtoReponse;
import com.ayouForItSolutions.v1.entities.concretes.DRH;

@Repository
public interface DRHRepository extends JpaRepository<DRH,Integer> {
	
	
	DRH findByUsername(String username);

	Optional<DRH> findOneByUsernameAndPassword(String username, String password);
    
    @Query("SELECT id, nom, prenom, 'DRH' AS role , username " +
    	       "FROM DRH WHERE id=:id")
    	AuthDtoReponse getReponse(int id);

}
