package com.ayouForItSolutions.v1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayouForItSolutions.v1.dtos.AuthDto;
import com.ayouForItSolutions.v1.services.abstracts.AuthenticationService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthenticationController {
	private AuthenticationService authenticationService;
	
	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping("/auth")
	public  ResponseEntity<?> authentication(@RequestBody AuthDto authDto){
		return ResponseEntity.ok(authenticationService.authUser(authDto));
		
	}

}
