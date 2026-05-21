package com.nish.project.controller;

import com.nish.project.dao.StudentDAO;
import com.nish.project.model.Student;
import com.nish.project.util.InputValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String name = InputValidator.validateName(
                            request.getParameter("name"));

            String email = InputValidator.validateEmail(
                            request.getParameter("email"));

            String phone = InputValidator.validatePhone(
                            request.getParameter("phone"));

			String city = InputValidator.validateCity(
                            request.getParameter("city"));

            int age = InputValidator.validateAge(Integer.parseInt(
                                    request.getParameter("age")));

            Student student = new Student(name, email, age, phone, city);

            StudentDAO studentDAO = new StudentDAO();

            studentDAO.addStudent(student);

            response.sendRedirect("students");

        } catch (NumberFormatException exception) {

            request.setAttribute("error", "Age must be a valid number.");

            request.getRequestDispatcher("/WEB-INF/views/student-form.jsp")
                   .forward(request, response);

        } catch (Exception exception) {

            request.setAttribute("error",
                    exception.getMessage());

            request.getRequestDispatcher("/WEB-INF/views/student-form.jsp")
                   .forward(request, response);
        }
    }
}