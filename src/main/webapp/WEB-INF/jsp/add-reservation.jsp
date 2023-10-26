<%@ page import="com.resourciumoptima.domain.Equipement" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
  </style>
</head>
<body>
<!-- MODAL -->
<div  id="modal-reservation-add" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" >
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="${pageContext.request.contextPath}/reservations" method="POST" id="form" >


        <div class="modal-header">
          <h5 class="modal-title" id="modal-title">Make Reservation</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">

          <input type="hidden" name="user" value="<%= session.getAttribute("userId") %>">

          <div class="mb-3">
            <label class="form-label" >Equipement</label>
            <select name="assignedTo"  class="form-select" aria-label="Default select example">
              <option selected disabled>Open this select menu</option>

              <%
                List<Equipement> equipments = (List<Equipement>) request.getAttribute("equipments");
                for (Equipement equipment : equipments) {
              %>
              <option value="<%= equipment.getId() %>"><%= equipment.getName()  %></option>
              <%
                }
              %>

            </select>
          </div>
          <div class="mb-3">
          <label class="form-label">Reservation Date</label>
          <input type="date" class="form-control" name="reservationDate" required>
        </div>
          <div class="mb-3">
            <label class="form-label">Return Date</label>
            <input type="date" class="form-control" name="returnDate" required>
          </div>




        </div>

        <div class="modal-footer">
          <button type="button" data-bs-dismiss="modal" class="btn btn-secondary" >Cancel</button>
          <button type="submit" name="save" class="btn btn-primary task-action-btn" id="save">Save</button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
