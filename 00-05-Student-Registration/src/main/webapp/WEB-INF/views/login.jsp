<%@ page language="java" %>

<html>

<head>
    <title>Login</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<h2>Admin Login</h2>

<form action="login-action" method="post">

    Username:
    <input type="text"
           name="username"
           value="${savedUsername}" />

    Password:
    <input type="password"
           name="password" />

    Remember Me:
    <input type="checkbox"
           name="remember" />

    <button type="submit">Login</button>

</form>

<p class="error">${error}</p>

</body>
</html>