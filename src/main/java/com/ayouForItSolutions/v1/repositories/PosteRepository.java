package com.ayouForItSolutions.v1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayouForItSolutions.v1.entities.concretes.Poste;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PosteRepository extends JpaRepository<Poste, Integer> {

	
	@Query("SELECT p FROM Poste p WHERE p.dirDept.id=:id")
	List<Poste> getByDirDept(@Param("id")int id);
	
	@Query("SELECT p FROM Poste p WHERE p.decision = false AND p.demande=true")
	List<Poste> getAllNew();
	
	
	@Query("SELECT p FROM Poste p WHERE (p.decision = false AND p.demande = false) OR (p.decision = true AND p.demande = true)")
	List<Poste> getAllOld();
	
	
	@Modifying
    @Query("UPDATE Poste p SET  p.decision = true, p.demande=true WHERE p.id_poste =:id")
	void accepter(int id);
	
	
	@Modifying
    @Query("UPDATE Poste p SET  p.decision = false, p.demande=false WHERE p.id_poste =:id")
	void refuser(int id);

}
