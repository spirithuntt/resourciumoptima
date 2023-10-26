package com.resourciumoptima.repository;

import com.resourciumoptima.domain.Reservation;
import jakarta.persistence.EntityManager;


public class ReservationRepository {

        private final EntityManager em;

        public ReservationRepository(EntityManager em) {
            this.em = em;
        }

        public Reservation save(Reservation reservation) {
            em.getTransaction().begin();
            em.persist(reservation);
            em.getTransaction().commit();
            return reservation;
        }
        public void update(Reservation reservation) {
            em.getTransaction().begin();
            em.merge(reservation);
            em.getTransaction().commit();
        }
        public void delete(long id) {
            em.getTransaction().begin();
            Reservation reservation = em.find(Reservation.class, id);
            em.remove(reservation);
            em.getTransaction().commit();
        }


}
