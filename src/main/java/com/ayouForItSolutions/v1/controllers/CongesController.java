package com.ayouForItSolutions.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayouForItSolutions.v1.dtos.AddCongesDto;
import com.ayouForItSolutions.v1.services.abstracts.CongesService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;

@RestController
@RequestMapping("/api/conges/")
@CrossOrigin
public class CongesController {
	
	CongesService congesService;

	@Autowired
	public CongesController(CongesService congesService) {
		super();
		this.congesService = congesService;
	}

	@PostMapping("add")
    public Result add(@RequestBody AddCongesDto conge){
        return this.congesService.add(conge);
    }

	@GetMapping("getCongesDepartement")
    public ResponseEntity<?> getCongesDepartement(int id){
        return ResponseEntity.ok(this.congesService.getCongesByDirDept(id));
    }
	@GetMapping("getCongesEmploye")
    public ResponseEntity<?> getCongesEmplye(int id){
        return ResponseEntity.ok(this.congesService.getCongesEmploye(id));
    }
	
	@PostMapping("accepter")
	public Result accepter(int id){
		return this.congesService.accepter(id);
	}

	@PostMapping("refuser")
	public Result refuser(int id){
		return this.congesService.refuser(id);
	}
}
