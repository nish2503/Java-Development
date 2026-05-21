<%@ page import="com.nish.project.model.Student" %>

<%
Student student =
(Student) request.getAttribute("student");
%>

<html>

<head>
    <title>Edit Student</title>

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

<h2>Edit Student</h2>

<form action="update-student" method="post">

    <input type="hidden"
           name="id"
           value="<%= student.getStudentId() %>">

    Name:
    <input type="text"
           name="name"
           value="<%= student.getName() %>">

    Email:
    <input type="text"
           name="email"
           value="<%= student.getEmail() %>">

    Age:
    <input type="number"
           name="age"
           value="<%= student.getAge() %>">

    Phone:
    <input type="text"
           name="phone"
           value="<%= student.getPhone() %>">

    City:
    <input type="text"
           name="city"
           value="<%= student.getCity() %>">

    <button type="submit">Update Student</button>

</form>

<br>

<a href="students">Back to Students</a>

</body>
</html>