package com.amayas.roomApp.Service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.amayas.roomApp.Entity.Reservation;
import com.amayas.roomApp.Entity.Salle;
import com.amayas.roomApp.Exception.ReservationConflictException;
import com.amayas.roomApp.Repository.ReservationRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    void creerReservation_NoConflict_Success() {
        Reservation reservation = new Reservation();
        reservation.setSalle(new Salle());
        reservation.setDateDebut(LocalDateTime.now());
        reservation.setDuree(60);

       

        reservationService.creerReservation(reservation);
        Mockito.verify(reservationRepository, Mockito.times(1)).save(reservation);
    }

    @Test
    void creerReservation_Conflict_ThrowsException() {
        Reservation reservation = new Reservation();
        reservation.setSalle(new Salle());
        reservation.setDateDebut(LocalDateTime.now());
        reservation.setDuree(60);

        List<Reservation> conflicts = new ArrayList<>();
        conflicts.add(new Reservation());

        assertThrows(ReservationConflictException.class, () -> reservationService.creerReservation(reservation));
        Mockito.verify(reservationRepository, Mockito.never()).save(Mockito.any());
    }
}
