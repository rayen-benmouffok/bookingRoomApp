package com.amayas.roomApp.Service;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amayas.roomApp.Entity.Utilisateur;
import com.amayas.roomApp.Repository.UtilisateurRepository;


@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository userRepo;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Utilisateur registerNewUser(Utilisateur user) {
		
        Utilisateur existingUser = userRepo.findByUserName(user.getUserName());
       
        if (existingUser != null) {
            throw new RuntimeException("Utilisateur déjà enregistré avec ce nom d'utilisateur");
        }
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));
		return userRepo.save(user); 
	}
	
	public void initUtilisateur() throws ParseException {
		Utilisateur utilisateur = new Utilisateur("User123",getEncodedPassword("User123"));
		userRepo.save(utilisateur);
		Utilisateur utilisateur1 = new Utilisateur("User",getEncodedPassword("User"));
		userRepo.save(utilisateur1);
		Utilisateur utilisateur2 = new Utilisateur("User1",getEncodedPassword("u"));
		userRepo.save(utilisateur2);
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}	
	
}
