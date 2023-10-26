<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Resourcium Optima Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header class="bg-primary text-white text-center py-4">
  <h1>Resourcium Optima</h1>
</header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="home.jsp">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="departments.jsp">Departments</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="employees.jsp">Employees</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="equipment.jsp">Equipment</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="reservations.jsp">Reservations</a>
      </li>
    </ul>
  </div>
</nav>
<main class="container my-4">
  <h2>Data</h2>
  <button class="btn btn-success" data-toggle="modal" data-target="#addDepartmentModal">Add Department</button>
  <table class="table table-bordered mt-5">
    <thead class="bg-primary text-white">
    <tr>
      <th>ID</th>
<%--      tasks--%>

</main>

<div class="modal fade" id="addDepartmentModal" tabindex="-1" role="dialog" aria-labelledby="addDepartmentModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addDepartmentModalLabel">Add Department</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success">Add</button>
      </div>
    </div>
  </div>
</div>

<footer class="text-center py-3">
</footer>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
