package com.nish.project.controller;

import java.io.IOException;

import com.nish.project.dao.StudentDAO;
import com.nish.project.model.Student;
import com.nish.project.util.InputValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-student")
public class UpdateStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int studentId = 0;
		String name = "";
		String email = "";
		String phone = "";
		String city = "";
		int age = 0;

		try {

			studentId = Integer.parseInt(request.getParameter("id"));

			name = InputValidator.validateName(request.getParameter("name"));

			email = InputValidator.validateEmail(request.getParameter("email"));

			phone = InputValidator.validatePhone(request.getParameter("phone"));

			city = InputValidator.validateCity(request.getParameter("city"));

			age = InputValidator.validateAge(Integer.parseInt(request.getParameter("age")));

			Student student = new Student(studentId, name, email, age, phone, city);

			StudentDAO studentDAO = new StudentDAO();

			studentDAO.updateStudent(student);

			response.sendRedirect("students");

		} catch (NumberFormatException exception) {

			request.setAttribute("error", "Age must be a valid number.");

			Student student = new Student(studentId, name, email, age, phone, city);

			request.setAttribute("student", student);

			request.getRequestDispatcher("/WEB-INF/views/edit-student.jsp")
				   .forward(request, response);

		} catch (Exception exception) {

			request.setAttribute("error", exception.getMessage());

			Student student = new Student(studentId, name, email, age, phone, city);

			request.setAttribute("student", student);

			request.getRequestDispatcher("/WEB-INF/views/edit-student.jsp")
				   .forward(request, response);
		}
	}
}