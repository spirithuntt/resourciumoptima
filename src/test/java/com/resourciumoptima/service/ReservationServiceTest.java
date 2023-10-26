package com.resourciumoptima.service;

import com.resourciumoptima.domain.Reservation;
import com.resourciumoptima.repository.ReservationRepository;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ReservationServiceTest {


    // create a valid reservation and save it
    @Test
    public void test_create_valid_reservation_and_save_it() {
        // Arrange
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        ReservationService reservationService = new ReservationService();
        Reservation reservation = new Reservation();
    
        // Act
        Reservation result = reservationService.createReservation(reservation);
    
        // Assert
        assertNotNull(result);
        verify(reservationRepository, times(1)).save(reservation);
    }

    // update a valid reservation and save it
    @Test
    public void test_update_valid_reservation_and_save_it() {
        // Arrange
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        ReservationService reservationService = new ReservationService();
        Reservation reservation = new Reservation();
    
        // Act
        reservationService.updateReservation(reservation);
    
        // Assert
        verify(reservationRepository, times(1)).update(reservation);
    }

    // delete a reservation by id
    @Test
    public void test_delete_reservation_by_id() {
        // Arrange
        long id = 1;
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        ReservationService reservationService = new ReservationService();
    
        // Act
        reservationService.deleteReservation(id);
    
        // Assert
        verify(reservationRepository, times(1)).delete(id);
    }

    // get a reservation by id
    @Test
    public void test_get_reservation_by_id() {
        // Arrange
        int id = 1;
        Reservation expectedReservation = new Reservation();
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        when(reservationRepository.findById(id)).thenReturn(expectedReservation);
        ReservationService reservationService = new ReservationService();
    
        // Act
        Reservation result = reservationService.getReservationById(id);
    
        // Assert
        assertEquals(expectedReservation, result);
    }

    // create a reservation with null reservation and return dates
    @Test
    public void test_create_reservation_with_null_dates() {
        // Arrange
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        ReservationService reservationService = new ReservationService();
        Reservation reservation = new Reservation();
    
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            reservationService.createReservation(reservation);
        });
    }

    // create a reservation with null input
    @Test
    public void test_create_reservation_with_null_input() {
        // Arrange
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        ReservationService reservationService = new ReservationService();
    
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            reservationService.createReservation(null);
        });
    }

    // update a reservation with null input
    @Test
    public void test_update_reservation_with_null_input() {
        // Arrange
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        ReservationService reservationService = new ReservationService();
    
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            reservationService.updateReservation(null);
        });
    }

    // delete a reservation with invalid id
    @Test
    public void test_delete_reservation_with_invalid_id() {
        // Arrange
        long id = -1;
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        ReservationService reservationService = new ReservationService();
    
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            reservationService.deleteReservation(id);
        });
    }

    // get a reservation with invalid id
    @Test
    public void test_get_reservation_with_invalid_id() {
        // Arrange
        int id = -1;
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        ReservationService reservationService = new ReservationService();
    
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            reservationService.getReservationById(id);
        });
    }

    // create a reservation with reservation date after return date
    @Test
    public void test_create_reservation_with_invalid_dates() {
        // Arrange
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        ReservationService reservationService = new ReservationService();
        Reservation reservation = new Reservation();
        reservation.setReservationDate(new Date());
        reservation.setReturnDate(new Date(System.currentTimeMillis() - 1000));
    
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            reservationService.createReservation(reservation);
        });
    }

}