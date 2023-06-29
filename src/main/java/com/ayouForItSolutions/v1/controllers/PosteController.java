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

import com.ayouForItSolutions.v1.dtos.AddPosteDto;
import com.ayouForItSolutions.v1.services.abstracts.PosteService;
import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;

@RestController
@RequestMapping("/api/poste/")
@CrossOrigin
public class PosteController {
	PosteService posteService;

	@Autowired
	public PosteController(PosteService posteService) {
		super();
		this.posteService = posteService;
	}
	@PostMapping("add")
    public Result add(@RequestBody AddPosteDto poste){
        return this.posteService.add(poste);
    }
	@GetMapping("getByDirDept")
    public ResponseEntity<?> getAllSaved(int id){
        return ResponseEntity.ok(this.posteService.getByDirDept(id));
    }
	@GetMapping("getAllNew")
    public ResponseEntity<?> getAllNew(){
        return ResponseEntity.ok(this.posteService.getAllNew());
    }
	
	@GetMapping("getAllOld")
    public ResponseEntity<?> getAllOld(){
        return ResponseEntity.ok(this.posteService.getAllOld());
    }
	
	@PostMapping("accepter")
	public Result accepter(@RequestParam int id){
		return this.posteService.accepter(id);
	}

	@PostMapping("refuser")
	public Result refuser(@RequestParam int id){
		return this.posteService.refuser(id);
	}
}
