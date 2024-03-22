package com.amayas.roomApp.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amayas.roomApp.Entity.Utilisateur;
import com.amayas.roomApp.Service.UtilisateurService;

import java.text.ParseException;

import javax.annotation.PostConstruct;

@RestController


public class UtilisateurController {
	@Autowired
	private UtilisateurService userService;
	
	@PostConstruct
	public void initRolesAndUsers() throws ParseException {
		userService.initUtilisateur();
	}
	
	@PostMapping("/registerNewUser")
	public Utilisateur registerNewUser(@RequestBody Utilisateur user) {
		return userService.registerNewUser(user);
	}
}
