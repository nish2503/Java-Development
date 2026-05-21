<%@ page import="java.util.*" %>
<%@ page import="com.nish.project.model.Course" %>

<html>

<head>
    <title>Courses</title>

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

<h2>Courses</h2>

<a href="course-form">Add Course</a>

<br><br>

<table>

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Duration</th>
    <th>Fees</th>
    <th>Trainer</th>
    <th>Actions</th>
</tr>

<%
List<Course> courseList =
(List<Course>) request.getAttribute("courses");

for(Course course : courseList){
%>

<tr>

<td><%= course.getCourseId() %></td>
<td><%= course.getName() %></td>
<td><%= course.getDuration() %></td>
<td><%= course.getFees() %></td>
<td><%= course.getTrainerName() %></td>

<td>
    <a href="edit-course?id=<%= course.getCourseId() %>">Edit</a>
    |
    <a href="delete-course?id=<%= course.getCourseId() %>">Delete</a>
</td>

</tr>

<% } %>

</table>

</body>
</html>