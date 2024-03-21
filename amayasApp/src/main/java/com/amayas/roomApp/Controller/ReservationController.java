package com.amayas.roomApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amayas.roomApp.Entity.Reservation;
import com.amayas.roomApp.Entity.Utilisateur;
import com.amayas.roomApp.Exception.ReservationConflictException;
import com.amayas.roomApp.Repository.ReservationRepository;
import com.amayas.roomApp.Repository.UtilisateurRepository;
import com.amayas.roomApp.Service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;
    
	@Autowired
	private UtilisateurRepository userRepo;
	
	

    
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    
    @GetMapping("/user/{userName}")
    public List<Reservation> getUserReservations(@PathVariable String userName) {
    	Long id = userRepo.findByUserName(userName).getId();
        return reservationRepository.findByUtilisateurId(id);
    }
    
    
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
    }
    
    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation) {
    	
    	String  userName = reservation.getUtilisateur().getUserName(); 
    	reservation.getUtilisateur().setId(userRepo.findByUserName(userName).getId());
    	
        try {
            reservationService.creerReservation(reservation);
            return ResponseEntity.ok("Réservation créée avec succès !");
        } catch (ReservationConflictException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


}
