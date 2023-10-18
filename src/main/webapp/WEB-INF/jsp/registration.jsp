<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form method="post" action="register">
    <label for="username">Username</label>
    <input type="text" name="username" id="username" required>
    <br>
    <label for="password1">Password</label>
    <input type="password" name="password1" id="password1" required>
    <br>
    <label for="password2">Confirm Password</label>
    <input type="password" name="password2" id="password2" required>
    <br>
    <label for="name">Name</label>
    <input type="text" name="name" id="name" required>
    <br>
    <label for="firstname">First Name</label>
    <input type="text" name="firstname" id="firstname" required>
    <br>
    <label for="email">Email</label>
    <input type="email" name="email" id="email" required>
    <br>
    <label for="position">Position</label>
    <input type="text" name="position" id="position" required>
    <br>
    <label for="hiringDate">Hiring Date</label>
    <input type="date" name="hiringDate" id="hiringDate" required>
    <br>
    <input type="submit" value="Register">
</form>
</body>
</html>
