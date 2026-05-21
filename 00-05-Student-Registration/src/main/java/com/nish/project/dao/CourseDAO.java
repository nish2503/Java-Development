package com.nish.project.dao;

import com.nish.project.model.Course;
import com.nish.project.util.DBConnection;

import java.sql.*;
import java.util.*;

public class CourseDAO {

	public void addCourse(Course course) {

	    try {

	        Connection connection = DBConnection.getConnection();

	        String sql =
	                "INSERT INTO courses " +
	                "(course_name, duration, fees, trainer_name) " +
	                "VALUES (?, ?, ?, ?)";

	        PreparedStatement ps = connection.prepareStatement(sql);

	        ps.setString(1, course.getName());
	        ps.setString(2, course.getDuration());
	        ps.setDouble(3, course.getFees());
	        ps.setString(4, course.getTrainerName());

	        ps.executeUpdate();

	    } catch (SQLIntegrityConstraintViolationException exception) {

			throw new RuntimeException("Course already exists.");

		} catch (Exception exception) {

			exception.printStackTrace();

			throw new RuntimeException("Database error.");
		}
	}

    public List<Course> getAllCourses() {

        List<Course> courseList = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM courses");

            while (rs.next()) {
                Course course = new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_name"),
                    rs.getString("duration"),
                    rs.getDouble("fees"),
                    rs.getString("trainer_name")
                );

                courseList.add(course);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return courseList;
    }
    
    public Course getCourseById(int courseId) {

        Course course = null;

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "SELECT * FROM courses WHERE course_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, courseId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                course = new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_name"),
                    rs.getString("duration"),
                    rs.getDouble("fees"),
                    rs.getString("trainer_name")
                );
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return course;
    }


    public void updateCourse(Course course) {

        try {

            Connection connection = DBConnection.getConnection();

            String sql = "UPDATE courses " +
                    	"SET course_name=?, duration=?, fees=?, trainer_name=? " +
                    	"WHERE course_id=?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, course.getName());
            ps.setString(2, course.getDuration());
            ps.setDouble(3, course.getFees());
            ps.setString(4, course.getTrainerName());
            ps.setInt(5, course.getCourseId());

            ps.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException exception) {

			throw new RuntimeException("Course already exists.");

		} catch (Exception exception) {

			exception.printStackTrace();

			throw new RuntimeException("Database error.");
		}
	}

    public boolean isCourseRegistered(int courseId) {

        boolean isRegistered = false;

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "SELECT * FROM registrations WHERE course_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, courseId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isRegistered = true;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return isRegistered;
    }


    public void deleteCourse(int courseId) {

        try {
            Connection connection = DBConnection.getConnection();

            String sql = "DELETE FROM courses WHERE course_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, courseId);

            ps.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}