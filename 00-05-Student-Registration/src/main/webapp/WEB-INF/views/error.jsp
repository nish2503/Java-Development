<html>

<head>
    <title>Error</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="navbar">

    <a href="dashboard">Dashboard</a>
    <a href="students">Students</a>
    <a href="courses">Courses</a>
    <a href="registrations">Registrations</a>
    <a href="logout">Logout</a>

</div>

<h2>Error</h2>

<p class="error">${error}</p>

<br>

<a href="dashboard">Back to Dashboard</a>

</body>
</html>