package com.amayas.roomApp.Controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.amayas.roomApp.Entity.Reservation;
import com.amayas.roomApp.Repository.ReservationRepository;

import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReservationController.class)
@AutoConfigureMockMvc
class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationController reservationController;

    @Test
    void getAllReservations_ReturnsListOfReservations() throws Exception {
        Reservation reservation1 = new Reservation();
        Reservation reservation2 = new Reservation();
        List<Reservation> reservations = Arrays.asList(reservation1, reservation2);

        Mockito.when(reservationRepository.findAll()).thenReturn(reservations);

        mockMvc.perform(get("/api/reservations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.length()").value(reservations.size()));
    }

    // Write similar tests for other endpoints like createReservation and deleteReservation
}

