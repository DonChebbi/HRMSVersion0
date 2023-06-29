package com.ayouForItSolutions.v1.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayouForItSolutions.v1.entities.concretes.Departement;
import com.ayouForItSolutions.v1.entities.concretes.DirecteurDeDepartement;
import com.ayouForItSolutions.v1.entities.concretes.Employe;

@Repository
public interface DeptRepository extends JpaRepository<Departement,Integer> {
	@Query("SELECT d.dirDept FROM Departement d WHERE d.dirDept IS NOT NULL AND d.id_dept =:id")
	DirecteurDeDepartement getDirDept(@Param("id") int id);
	
	 @Query("SELECT d FROM Departement d WHERE d.id_dept = :id")
	 Departement getDepartementById(int id);

	@Query("SELECT d.dirDept FROM Departement d WHERE d.id_dept=:id_dept")
	DirecteurDeDepartement getDirDeptByDeptId(@Param("id_dept")int id_dept);

	@Query("SELECT d.employes FROM Departement d WHERE d.id_dept =:id_dept")
	List<Employe> getEmpByDeptId(@Param("id_dept")int id_dept);
	
	@Query("SELECT d FROM Departement d WHERE d.dirDept IS NULL")
	List<Departement> deptEmptyGet();
	
}
