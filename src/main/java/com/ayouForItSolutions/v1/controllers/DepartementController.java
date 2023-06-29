package com.ayouForItSolutions.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayouForItSolutions.v1.dtos.AddDeptDto;
import com.ayouForItSolutions.v1.dtos.DeleteDeptDto;
import com.ayouForItSolutions.v1.services.abstracts.DepartementService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;

@RestController
@RequestMapping("/api/dept/")
@CrossOrigin
public class DepartementController {
	private DepartementService deptService;
	
	@Autowired
	public DepartementController(DepartementService deptService) {
		this.deptService = deptService;
	}
	@PostMapping("add")
    public Result add(@RequestBody AddDeptDto dept){
        return this.deptService.add(dept);
    }
	@PostMapping("delete")
	public Result delete(@RequestBody DeleteDeptDto dept){
        return this.deptService.delete(dept);
    }
	@GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.deptService.getAll());
    }
	@GetMapping("deptEmptyGet")
    public ResponseEntity<?> deptEmptyGet() {
        return ResponseEntity.ok(deptService.deptEmptyGet());
    }

}
