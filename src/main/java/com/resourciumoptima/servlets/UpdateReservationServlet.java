package com.resourciumoptima.servlets;

import com.resourciumoptima.domain.Reservation;
import com.resourciumoptima.service.ReservationService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet(name = "UpdateReservationServlet", value = "/update-reservation")
public class UpdateReservationServlet extends HttpServlet {
    private final ReservationService reservationService;

    public UpdateReservationServlet() {
        this.reservationService = new ReservationService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int reservationId = Integer.parseInt(request.getParameter("id"));


        Reservation reservation = reservationService.getReservationById(reservationId);

        if (reservation != null) {

            request.setAttribute("reservation", reservation);
            request.getRequestDispatcher("/WEB-INF/jsp/update-reservation.jsp").forward(request, response);
        } else {

            response.sendRedirect(request.getContextPath() + "/reservations");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        int reservationUserId = Integer.parseInt(request.getParameter("user"));
        int reservationEquipementId = Integer.parseInt(request.getParameter("assignedTo"));
        String reservationDateStr = request.getParameter("reservationDate");
        String returnDateStr = request.getParameter("returnDate");

        LocalDate reservationDate = LocalDate.parse(reservationDateStr);
        LocalDate returnDate = LocalDate.parse(returnDateStr);

        Reservation updatedReservation = new Reservation();
        updatedReservation.setId(reservationId);
        updatedReservation.setReservationDate(Date.from(reservationDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        updatedReservation.setReturnDate(Date.from(returnDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));


        reservationService.updateReservation(updatedReservation);

        response.sendRedirect(request.getContextPath() + "/reservations");
    }
}
