<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Update Profile</title>
</head>
<body>
<h1>Update Profile</h1>
<form action="updateProfile" method="post">
  <label for="username">Username:</label>
    <input type="hidden" id="id" name="id" value="${sessionScope.id}" required><br>
  <input type="text" id="username" name="username" value="${sessionScope.username}" required><br>
<label for="password">Password:</label>
    <input type="password" id="password" name="password" value="${sessionScope.password}" required><br>
<label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${sessionScope.email}" required><br>
<label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" value="${sessionScope.firstName}" required><br>
<label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" value="${sessionScope.lastName}" required><br>



  <input type="submit" value="Update">
</form>
</body>
</html>
