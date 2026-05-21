package com.nish.project.controller;

import com.nish.project.dao.CourseDAO;
import com.nish.project.dao.RegistrationDAO;
import com.nish.project.dao.StudentDAO;
import com.nish.project.model.Registration;
import com.nish.project.util.InputValidator;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/add-registration")
public class AddRegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int studentId = Integer.parseInt(request.getParameter("studentId"));

			int courseId = Integer.parseInt(request.getParameter("courseId"));

			String date = request.getParameter("date").trim();

			String status = InputValidator.validateStatus(request.getParameter("status"));

			if (date.isEmpty()) {

				throw new Exception("Registration date is required.");
			}

			Registration registration = new Registration(studentId, courseId, date, status);

			RegistrationDAO registrationDAO = new RegistrationDAO();

			if (registrationDAO.isAlreadyRegistered(studentId, courseId)) {

				request.setAttribute("error", "Student already registered for this course");

				request.setAttribute("students", new StudentDAO().getAllStudents());

				request.setAttribute("courses", new CourseDAO().getAllCourses());

				request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp")
				       .forward(request, response);

				return;
			}

			registrationDAO.addRegistration(registration);

			response.sendRedirect("registrations");

		} catch (NumberFormatException exception) {

			request.setAttribute("error", "Invalid student or course selection.");

			request.setAttribute("students", new StudentDAO().getAllStudents());

			request.setAttribute("courses", new CourseDAO().getAllCourses());

			request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp")
			       .forward(request, response);

		} catch (Exception exception) {

			request.setAttribute("error", exception.getMessage());

			request.setAttribute("students", new StudentDAO().getAllStudents());

			request.setAttribute("courses", new CourseDAO().getAllCourses());

			request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp")
			       .forward(request, response);
		}
	}
}