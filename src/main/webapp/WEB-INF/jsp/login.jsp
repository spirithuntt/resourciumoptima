<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="login">
    Username: <input type="text" name="username" required><br>
    Password: <input type="password" name="password" required><br>
    Sign up: <a href="${pageContext.request.contextPath}/registration">Sign up</a><br>
    <input type="submit" value="Login">

</form>
</body>
</html>
