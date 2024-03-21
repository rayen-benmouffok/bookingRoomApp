package com.amayas.roomApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amayas.roomApp.Entity.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUtilisateurId(Long utilisateurId);
    List<Reservation> findBySalleId(Long salleId);
}