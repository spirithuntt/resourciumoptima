package com.resourciumoptima.service;

import com.resourciumoptima.domain.Reservation;
import com.resourciumoptima.repository.ReservationRepository;

public class ReservationService {

    private final ReservationRepository reservationRepository ;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public Reservation createReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public void updateReservation(Reservation reservation){
        reservationRepository.update(reservation);
    }

    public void deleteReservation(long id){
        reservationRepository.delete(id);
    }

}
