<%@ page import="com.resourciumoptima.domain.Reservation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Reservation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Update Reservation</h2>
    <form action="${pageContext.request.contextPath}/update-reservation" method="POST">
        <input type="hidden" name="reservationId" value="<%= reservation.getId() %>">
        <div class="form-group">
            <label for="reservationDate">Reservation Date</label>
            <input type="date" class="form-control" id="reservationDate" name="reservationDate" value="<%= reservation.getReservationDate() %>">
        </div>
        <div class="form-group">
            <label for="returnDate">Return Date</label>
            <input type="date" class="form-control" id="returnDate" name="returnDate" value="<%= reservation.getReturnDate() %>">
        </div>
        <button type="submit" class="btn btn-primary">Update Reservation</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
