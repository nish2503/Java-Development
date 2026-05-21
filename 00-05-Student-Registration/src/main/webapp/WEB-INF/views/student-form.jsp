<html>

<head>
    <title>Add Student</title>

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

<h2>Add Student</h2>

<form action="add-student" method="post">

    Name:
    <input type="text" name="name">

    Email:
    <input type="text" name="email">

    Age:
    <input type="number" name="age">

    Phone:
    <input type="text" name="phone">

    City:
    <input type="text" name="city">

    <button type="submit">Add Student</button>

</form>

<p class="error">${error}</p>

<br>

<a href="students">Back to Students</a>

</body>
</html>