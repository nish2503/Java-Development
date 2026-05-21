<%@ page import="java.util.*" %>
<%@ page import="com.nish.project.model.Student" %>

<html>

<head>
    <title>Students</title>

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

<h2>Students</h2>

<a href="student-form">Add Student</a>

<br><br>

<table>

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Age</th>
    <th>Phone</th>
    <th>City</th>
    <th>Actions</th>
</tr>

<%
List<Student> studentList =
(List<Student>) request.getAttribute("students");

for(Student student : studentList){
%>

<tr>

<td><%= student.getStudentId() %></td>
<td><%= student.getName() %></td>
<td><%= student.getEmail() %></td>
<td><%= student.getAge() %></td>
<td><%= student.getPhone() %></td>
<td><%= student.getCity() %></td>

<td>
    <a href="edit-student?id=<%= student.getStudentId() %>">Edit</a>
    |
    <a href="delete-student?id=<%= student.getStudentId() %>">Delete</a>
</td>

</tr>

<% } %>

</table>

</body>
</html>