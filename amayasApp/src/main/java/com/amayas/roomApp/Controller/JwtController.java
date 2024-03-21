package com.amayas.roomApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import  com.amayas.roomApp.Entity.JwtRequest;
import  com.amayas.roomApp.Entity.JwtResponse;
import  com.amayas.roomApp.Service.JwtService;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/authenticate")
	public JwtResponse createJwtToken(@RequestBody  JwtRequest jwtRequest) throws Exception{
		return jwtService.createJwtToken(jwtRequest);
	}
}
