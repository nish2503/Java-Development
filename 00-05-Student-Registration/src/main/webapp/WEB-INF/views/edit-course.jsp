<%@ page import="com.nish.project.model.Course" %>

<%
Course course =
(Course) request.getAttribute("course");
%>

<html>

<head>
    <title>Edit Course</title>

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

<h2>Edit Course</h2>

<form action="update-course" method="post">

    <input type="hidden"
           name="id"
           value="<%= course.getCourseId() %>">

    Course Name:
    <input type="text"
           name="name"
           value="<%= course.getName() %>">

    Duration:
    <input type="text"
           name="duration"
           value="<%= course.getDuration() %>">

    Fees:
    <input type="number"
           name="fees"
           value="<%= course.getFees() %>">

    Trainer:
    <input type="text"
           name="trainer"
           value="<%= course.getTrainerName() %>">

    <button type="submit">Update Course</button>

</form>

<br>

<a href="courses">Back to Courses</a>

</body>
</html>