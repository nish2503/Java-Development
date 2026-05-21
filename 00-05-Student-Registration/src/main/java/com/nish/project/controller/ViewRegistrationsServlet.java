package com.nish.project.controller;

import java.io.IOException;
import java.util.List;

import com.nish.project.dao.RegistrationDAO;
import com.nish.project.model.Registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrations")
public class ViewRegistrationsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Registration> registrationList = new RegistrationDAO().getAllRegistrations();

        request.setAttribute("registrations", registrationList);

        request.getRequestDispatcher("/WEB-INF/views/registration-list.jsp")
               .forward(request, response);
    }
}