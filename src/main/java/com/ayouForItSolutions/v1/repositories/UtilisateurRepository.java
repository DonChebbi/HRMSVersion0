package com.ayouForItSolutions.v1.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ayouForItSolutions.v1.entities.abstracts.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
	

}
