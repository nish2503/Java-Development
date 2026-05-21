package com.nish.project.controller;

import java.io.IOException;

import com.nish.project.dao.CourseDAO;
import com.nish.project.model.Course;
import com.nish.project.util.InputValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-course")
public class UpdateCourseServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int courseId = 0;
		String name = "";
		String duration = "";
		double fees = 0;
		String trainer = "";

		try {

			courseId = Integer.parseInt(request.getParameter("id"));

			name = InputValidator.validateCourseName(request.getParameter("name"));

			duration = InputValidator.validateDuration(request.getParameter("duration"));

			fees = InputValidator.validateFees(Double.parseDouble(request.getParameter("fees")));

			trainer = InputValidator.validateTrainer(request.getParameter("trainer"));

			Course course = new Course(courseId, name, duration, fees, trainer);

			CourseDAO courseDAO = new CourseDAO();

			courseDAO.updateCourse(course);

			response.sendRedirect("courses");

		} catch (NumberFormatException exception) {

			request.setAttribute("error", "Fees must be a valid number.");

			Course course = new Course(courseId, name, duration, fees, trainer);

			request.setAttribute("course", course);

			request.getRequestDispatcher("/WEB-INF/views/edit-course.jsp")
				   .forward(request, response);

		} catch (Exception exception) {

			request.setAttribute("error", exception.getMessage());

			Course course = new Course(courseId, name, duration, fees, trainer);

			request.setAttribute("course", course);

			request.getRequestDispatcher("/WEB-INF/views/edit-course.jsp")
				   .forward(request, response);
		}
	}
}