package com.resourciumoptima.servlets;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.domain.Equipement;
import com.resourciumoptima.domain.Reservation;
import com.resourciumoptima.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ReservationServlet", value = "/reservations")
public class ReservationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try {
            List<Reservation> reservations = em.createQuery("SELECT t FROM Reservation t", Reservation.class).getResultList();
            request.setAttribute("reservations", reservations);

            List<Equipement> equipment = em.createQuery("SELECT u FROM Equipement u", Equipement.class).getResultList();
            request.setAttribute("equipments", equipment);

        } finally {
            em.close();
        }
        request.getRequestDispatcher("/WEB-INF/jsp/add-reservation.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost reservation");

        int reservationUserId = Integer.parseInt(request.getParameter("user"));
        int reservationEquipementId = Integer.parseInt(request.getParameter("assignedTo"));
        String reservationDateStr = request.getParameter("reservationDate");
        String returnDateStr = request.getParameter("returnDate");


        System.out.println(reservationUserId);
        System.out.println(reservationEquipementId);
        System.out.println(reservationDateStr);

        Reservation reservation = new Reservation();

        LocalDate reservationDate = LocalDate.parse(reservationDateStr);
        LocalDate returnDate = LocalDate.parse(returnDateStr);

        reservation.setReservationDate(Date.from(reservationDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        reservation.setReturnDate(Date.from(returnDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Employee assignedUser = entityManager.find(Employee.class, reservationUserId);
            reservation.setUser(assignedUser);
            Equipement equipement = entityManager.find(Equipement.class, reservationEquipementId);

            if (equipement.isAvailability()) {

                reservation.setEquipement(equipement);

                equipement.setAvailability(false);

                entityManager.persist(reservation);

                transaction.commit();

                request.getSession().removeAttribute("reservationError");

                request.getSession().setAttribute("reservationSuccess", "Reservation saved successfully");
            } else {
                request.getSession().removeAttribute("reservationSuccess");

                request.getSession().setAttribute("reservationError", "Equipment is not available");
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        System.out.println("Reservation saved successfully");
        System.out.println(reservationUserId);
        System.out.println(reservationEquipementId);
        System.out.println(reservationDateStr);
        System.out.println(returnDateStr);

        response.sendRedirect(request.getContextPath() + "/reservations");

    }

}