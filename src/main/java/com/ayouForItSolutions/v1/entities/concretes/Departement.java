package com.ayouForItSolutions.v1.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Table(name = "departements")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dept;
	
	@Column(name = "nomdept")
    private String nomDept;
    
    @Column(name = "descdept")
    private String descDept;
    
    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private List<Employe> employes;
    
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "directeur_id")
    private DirecteurDeDepartement dirDept;
}
