package com.amayas.roomApp.Service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amayas.roomApp.Entity.Salle;
import com.amayas.roomApp.Repository.SalleRepository;

@Service
public class SalleService {

	@Autowired
	private SalleRepository salleRepo;
	
	
	public void initSalle() throws ParseException {
		Salle salle = new Salle("Maupassant");
		salleRepo.save(salle);
		
		Salle salle1 = new Salle("MACRON");
		salleRepo.save(salle1);
		
		Salle salle2 = new Salle("ATAL");
		salleRepo.save(salle2);
		
		Salle salle3 = new Salle("ZOUBIR");
		salleRepo.save(salle3);
		
		Salle salle4 = new Salle("KADOUR");
		salleRepo.save(salle4);
		
		Salle salle5 = new Salle("ALORS");
		salleRepo.save(salle5);
		
		
		
		
	}

}
