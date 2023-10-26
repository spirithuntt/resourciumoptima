package com.resourciumoptima.servlets;

import com.resourciumoptima.domain.Equipement;
import com.resourciumoptima.domain.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReservationDeleteServlet", value = "/ReservationDeleteServlet")
public class ReservationDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            Reservation reservationToDelete = em.find(Reservation.class, reservationId);

            // Check if the reservation exists
            if (reservationToDelete != null) {
                EntityTransaction transaction = em.getTransaction();

                try {
                    transaction.begin();

                    Equipement equipement = reservationToDelete.getEquipement();

                    equipement.setAvailability(true);

                    em.remove(reservationToDelete);

                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null && transaction.isActive()) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                }
            }
        } finally {
            em.close();
            emf.close();
        }

        response.sendRedirect(request.getContextPath() + "/reservations");
    }


}