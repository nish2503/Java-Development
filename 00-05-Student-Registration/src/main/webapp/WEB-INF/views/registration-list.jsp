<%@ page import="java.util.*" %>
<%@ page import="com.nish.project.model.Registration" %>

<html>

<head>
    <title>Registrations</title>

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

<h2>Registrations</h2>

<a href="registration-form">Register Student</a>

<br><br>

<table>

<tr>
    <th>ID</th>
    <th>Student</th>
    <th>Course</th>
    <th>Date</th>
    <th>Status</th>
</tr>

<%
List<Registration> registrationList =
(List<Registration>) request.getAttribute("registrations");

for(Registration registration : registrationList){
%>

<tr>

<td><%= registration.getId() %></td>
<td><%= registration.getStudentName() %></td>
<td><%= registration.getCourseName() %></td>
<td><%= registration.getRegistrationDate() %></td>
<td><%= registration.getStatus() %></td>

</tr>

<% } %>

</table>

</body>
</html>