package com.amayas.roomApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amayas.roomApp.Entity.Salle;
import com.amayas.roomApp.Repository.SalleRepository;
import com.amayas.roomApp.Service.SalleService;

import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/salles")
public class SalleController {

    @Autowired
    private SalleRepository salleRepository;

    @Autowired
	private SalleService salleService;
	
    
	@PostConstruct
	public void initSalle() throws ParseException {
		salleService.initSalle();
	}
	
	
    @GetMapping
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }
}
