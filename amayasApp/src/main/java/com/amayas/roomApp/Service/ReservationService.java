package com.amayas.roomApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amayas.roomApp.Entity.Reservation;
import com.amayas.roomApp.Exception.ReservationConflictException;
import com.amayas.roomApp.Repository.ReservationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void creerReservation(Reservation reservation) {
        if (isSalleDisponible(reservation.getSalle().getId(), reservation.getDateDebut(), reservation.getDuree())) {
            reservationRepository.save(reservation);
        } else {
            throw new ReservationConflictException("La salle est déjà réservée pour cette période.");
        }
    }

    public Optional<Reservation> getReservationById(long id) {
        return reservationRepository.findById(id);
    }

    private boolean isSalleDisponible(Long salleId, LocalDateTime dateDebut, int duree) {
    	
    	List<Reservation> res = reservationRepository.findBySalleId(salleId);
    	LocalDateTime dateFin = dateDebut.plusMinutes(duree);
    	
    	for (Reservation element : res) {
    		LocalDateTime debutExist = element.getDateDebut();
    		LocalDateTime finExist = debutExist.plusMinutes(element.getDuree());
        	 boolean chevauchement =
                     (dateDebut.isBefore(finExist) || dateDebut.isEqual(finExist)) &&
                     (dateFin.isAfter(debutExist) || dateFin.isEqual(debutExist));

    	    if(chevauchement) {
    	    	return false;
    	    }
    	}
        return true;
    }

}
