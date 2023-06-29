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

import com.ayouForItSolutions.v1.dtos.AddEmpDto;
import com.ayouForItSolutions.v1.dtos.DeleteEmpDto;
import com.ayouForItSolutions.v1.dtos.ModifHoraireDto;
import com.ayouForItSolutions.v1.dtos.UpdateEmpDto;
import com.ayouForItSolutions.v1.services.abstracts.EmployeService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;



@RestController
@RequestMapping("/api/employe/")
@CrossOrigin
public class EmployerController {3
	EmployeService employeService;
	@Autowired
	public EmployerController(EmployeService employeService) {
		this.employeService = employeService;
	}
	@PostMapping("add")
    public Result addByDrh(@RequestBody AddEmpDto emp){
        return this.employeService.add(emp);
    }

    /*@PostMapping("updateByDrh")
    public ResponseEntity<?> update(Employe emp){
        return ResponseEntity.ok(this.employeService.delete(emp));
    }*/
	@PostMapping("update")
	public Result update(@RequestBody UpdateEmpDto emp){
		return this.employeService.update(emp);
	}

    @PostMapping("delete")
    public Result deleteByDrh(@RequestBody DeleteEmpDto emp){
        return this.employeService.delete(emp);
    }

    @GetMapping("getAllSaved")
    public ResponseEntity<?> getAllSaved(){
        return ResponseEntity.ok(this.employeService.getAllSaved());
    }
    
    @GetMapping("getAllSavedById")
    public ResponseEntity<?> getAllSavedById(int id) {
        return ResponseEntity.ok(employeService.getAllById(id));
    }
    @GetMapping("getAllEmpByDept")
    public ResponseEntity<?> getAllEmpByDept(@RequestParam int id) {
        return ResponseEntity.ok(employeService.getAllEmpByDept(id));
    }
    @PostMapping("ModifHoraireEmpById")
    public Result ModifHoraireEmpById(@RequestBody ModifHoraireDto dto){
        return this.employeService.ModifHoraireEmpById(dto);
    }
}
