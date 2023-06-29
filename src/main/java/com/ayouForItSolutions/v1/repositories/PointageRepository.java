package com.ayouForItSolutions.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayouForItSolutions.v1.entities.concretes.Pointage;

@Repository
public interface PointageRepository extends JpaRepository<Pointage, Integer> {

}
