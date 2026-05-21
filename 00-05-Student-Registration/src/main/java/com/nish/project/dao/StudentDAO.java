package com.nish.project.dao;

import com.nish.project.model.Student;
import com.nish.project.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	public void addStudent(Student student) {

	    try {

	        Connection connection =  DBConnection.getConnection();

	        String sql = "INSERT INTO students " +
	                	"(student_name, email, age, phone, city) " +
	                	"VALUES (?, ?, ?, ?, ?)";

	        PreparedStatement ps = connection.prepareStatement(sql);

	        ps.setString(1, student.getName());
	        ps.setString(2, student.getEmail());
	        ps.setInt(3, student.getAge());
	        ps.setString(4, student.getPhone());
	        ps.setString(5, student.getCity());

	        ps.executeUpdate();

	    } catch (SQLIntegrityConstraintViolationException exception) {

	        String message = exception.getMessage();

	        if(message.contains("email")) {

	            throw new RuntimeException("Student with this email already exists.");
	        }

	        if(message.contains("phone")) {

	            throw new RuntimeException("Student with this phone number already exists.");
	        }

	        throw new RuntimeException(
	                "Duplicate student data found.");

	    } catch (Exception exception) {

	        exception.printStackTrace();

	        throw new RuntimeException("Database error.");
	    }
	}

    public List<Student> getAllStudents() {

        List<Student> studentList = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM students");

            while (rs.next()) {

                Student student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getString("email"),
                        rs.getInt("age"),
                        rs.getString("phone"),
                        rs.getString("city")
                );

                studentList.add(student);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return studentList;
    }
    
    public Student getStudentById(int studentId) {

        Student student = null;

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "SELECT * FROM students WHERE student_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getString("email"),
                    rs.getInt("age"),
                    rs.getString("phone"),
                    rs.getString("city")
                );
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return student;
    }


    public void updateStudent(Student student) {

        try {

            Connection connection = DBConnection.getConnection();

            String sql = "UPDATE students " +
                    	"SET student_name=?, email=?, age=?, phone=?, city=? " +
                    	"WHERE student_id=?";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getCity());
            ps.setInt(6, student.getStudentId());

            ps.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException exception) {

            String message = exception.getMessage();

			if (message.contains("email")) {

				throw new RuntimeException("Student with this email already exists.");
			}

			if (message.contains("phone")) {

				throw new RuntimeException("Student with this phone number already exists.");
			}

			throw new RuntimeException("Duplicate student data found.");

        } catch (Exception exception) {

			exception.printStackTrace();

			throw new RuntimeException("Database error.");
		}
    }
    
    public boolean isStudentRegistered(int studentId) {

        boolean isRegistered = false;

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "SELECT * FROM registrations WHERE student_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isRegistered = true;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return isRegistered;
    }
    
    public void deleteStudent(int studentId) {

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "DELETE FROM students WHERE student_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, studentId);

            ps.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}