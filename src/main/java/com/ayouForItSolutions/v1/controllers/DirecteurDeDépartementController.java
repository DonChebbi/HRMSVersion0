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

import com.ayouForItSolutions.v1.dtos.AddDirDeptDto;
import com.ayouForItSolutions.v1.dtos.DeleteDirDeptDto;
import com.ayouForItSolutions.v1.dtos.UpdateDirDeptDto;
import com.ayouForItSolutions.v1.services.abstracts.DirecteurDeDepartementService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;

@RestController
@RequestMapping("/api/dirDept/")
@CrossOrigin
public class DirecteurDeDépartementController {
	private DirecteurDeDepartementService dirDeptService;

	@Autowired
	public DirecteurDeDépartementController(DirecteurDeDepartementService dirDeptService) {
		this.dirDeptService = dirDeptService;
	}
	
	@GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.dirDeptService.getAll());
    }
	 @GetMapping("getDirDeptById")
	    public ResponseEntity<?> getDirDeptById(int id) {
	        return ResponseEntity.ok(dirDeptService.getDirDeptById(id));
	    }
	@PostMapping("add")
    public Result add(@RequestBody AddDirDeptDto dirDept){
        return this.dirDeptService.add(dirDept);
    }

	@PostMapping("update")
    public Result update(@RequestBody UpdateDirDeptDto dirDept){
        return this.dirDeptService.update(dirDept);
    }
    @PostMapping("delete")
    public Result delete(@RequestBody DeleteDirDeptDto dirDept){
        return this.dirDeptService.delete(dirDept);
    }
    @GetMapping("getAllEmpByDept")
    public ResponseEntity<?> getAllEmpByDept(@RequestParam int id) {
        return ResponseEntity.ok(dirDeptService.getAllEmpByDept(id));
    }
}
