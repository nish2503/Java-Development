package com.nish.project.dao;

import com.nish.project.model.Registration;
import com.nish.project.util.DBConnection;

import java.sql.*;
import java.util.*;

public class RegistrationDAO {

    public void addRegistration(Registration registration) {

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "INSERT INTO registrations(student_id, course_id, registration_date, status) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, registration.getStudentId());
            ps.setInt(2, registration.getCourseId());
            ps.setString(3, registration.getRegistrationDate());
            ps.setString(4, registration.getStatus());

            ps.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException exception) {
            throw new RuntimeException("Student already registered for this course");
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("Database error");
        }
    }

    public List<Registration> getAllRegistrations() {

        List<Registration> registrationList = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "SELECT r.registration_id, s.student_name, c.course_name, r.registration_date, r.status " +
                    "FROM registrations r " +
                    "JOIN students s ON r.student_id = s.student_id " +
                    "JOIN courses c ON r.course_id = c.course_id";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Registration registration = new Registration(
                        rs.getInt("registration_id"),
                        rs.getString("student_name"),
                        rs.getString("course_name"),
                        rs.getString("registration_date"),
                        rs.getString("status")
                );

                registrationList.add(registration);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return registrationList;
    }

    public boolean isAlreadyRegistered(int studentId, int courseId) {

        boolean exists = false;

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "SELECT * FROM registrations WHERE student_id=? AND course_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return exists;
    }
}