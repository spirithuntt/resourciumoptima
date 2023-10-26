package com.resourciumoptima.service;

import com.resourciumoptima.domain.Reservation;
import com.resourciumoptima.repository.ReservationRepository;

public class ReservationService {

    private  ReservationRepository reservationRepository;

    public ReservationService() {
        this.reservationRepository = this.reservationRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        if (isValidReservation(reservation)) {
            return reservationRepository.save(reservation);
        } else {
            throw new IllegalArgumentException("Invalid reservation data. Please check your input.");
        }
    }

    public void updateReservation(Reservation reservation) {
        if (isValidReservation(reservation)) {
            reservationRepository.update(reservation);
        } else {
            throw new IllegalArgumentException("Invalid reservation data. Please check your input.");
        }
    }

    public void deleteReservation(long id) {
        reservationRepository.delete(id);
    }

    private boolean isValidReservation(Reservation reservation) {
        if (reservation == null) {
            return false;
        }

        if (reservation.getReservationDate() != null && reservation.getReturnDate() != null) {
            if (reservation.getReservationDate().after(reservation.getReturnDate())) {
                return false;
            }
        }


        return true;
    }
    //getReservationById
    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id);
    }
}
