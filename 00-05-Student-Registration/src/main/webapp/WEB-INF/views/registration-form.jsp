<%@ page import="java.util.*" %>
<%@ page import="com.nish.project.model.Student" %>
<%@ page import="com.nish.project.model.Course" %>

<html>

<head>
    <title>Register Student</title>

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

<h2>Register Student</h2>

<form action="add-registration" method="post">

    Student:

    <select name="studentId">

    <%
    for(Student student :
        (List<Student>) request.getAttribute("students")){
    %>

        <option value="<%= student.getStudentId() %>">
            <%= student.getName() %>
        </option>

    <% } %>

    </select>

    Course:

    <select name="courseId">

    <%
    for(Course course :
        (List<Course>) request.getAttribute("courses")){
    %>

        <option value="<%= course.getCourseId() %>">
            <%= course.getName() %>
        </option>

    <% } %>

    </select>

    Registration Date:
    <input type="date" name="date">

    Status:

    <select name="status">
        <option value="ACTIVE">ACTIVE</option>
        <option value="COMPLETED">COMPLETED</option>
    </select>

    <button type="submit">Register</button>

</form>

<p class="error">${error}</p>

<br>

<a href="registrations">Back to Registrations</a>

</body>
</html>