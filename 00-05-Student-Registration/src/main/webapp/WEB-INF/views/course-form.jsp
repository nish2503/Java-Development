<html>

<head>
    <title>Add Course</title>

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

<h2>Add Course</h2>

<form action="add-course" method="post">

    Course Name:
    <input type="text" name="name">

    Duration:
    <input type="text" name="duration">

    Fees:
    <input type="number" name="fees">

    Trainer:
    <input type="text" name="trainer">

    <button type="submit">Add Course</button>

</form>

<p class="error">${error}</p>

<br>

<a href="courses">Back to Courses</a>

</body>
</html>