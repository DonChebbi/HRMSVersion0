package com.ayouForItSolutions.v1.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayouForItSolutions.v1.entities.concretes.Conges;
import com.ayouForItSolutions.v1.entities.concretes.Employe;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CongesRepository extends JpaRepository<Conges, Integer> {
	
	@Modifying
    @Query("UPDATE Conges c SET  c.decision = true, c.demande=true WHERE c.id_cong =:id")
	void accepter(int id);
	
	@Modifying
    @Query("UPDATE Conges c SET  c.decision = false, c.demande=false WHERE c.id_cong =:id")
	void refuser(int id);
	
	@Query("SELECT c FROM Conges c WHERE c.employe.id=:id")
    List<Conges> getAllCongesForEmp(@Param("id")int id);
}
