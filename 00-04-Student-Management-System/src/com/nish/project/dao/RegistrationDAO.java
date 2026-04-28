package com.nish.project.dao;

import java.sql.*;

import com.nish.project.exception.DAOException;
import com.nish.project.util.DBUtil;

public class RegistrationDAO {
	public boolean registerStudent(int studentId, int courseId, double fees, Connection connection) throws DAOException {
		String query = "insert into registration (student_id, course_id, fees_paid) values (?, ?, ?)";

		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setInt(1, studentId);
			ps.setInt(2, courseId);
			ps.setDouble(3, fees);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			String msg = e.getMessage().toLowerCase();
			if (msg.contains("duplicate")) {
				throw new DAOException("Student already registered for this course", e);
			} else if (msg.contains("foreign key")) {
				throw new DAOException("Invalid student ID or course ID.", e);
			} else {
				throw new DAOException("Failed to register student.", e);
			}
		}
	}

	public void getAllStudentsWithRegistration() throws DAOException {

		String query = "select s.name, c.course_name, r.fees_paid " + 
					   "from student s " + 
					   "left join registration r on s.id = r.student_id " + 
					   "left join course c on r.course_id = c.course_id";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ResultSet rs = ps.executeQuery();

			boolean found = false;

			while (rs.next()) {
				found = true;
				System.out.println(
						rs.getString("name") + " | " + 
						rs.getString("course_name") + " | " + 
						rs.getDouble("fees_paid"));
			}

			if (!found) {
				System.out.println("No registrations found");
			}

		} catch (SQLException e) {
			throw new DAOException("Error fetching student registration", e);
		}
	}
	
	public void getStudentRegistrationById(int studentId) throws DAOException {

	    String query = "SELECT c.course_name, r.fees_paid " +
	                   "FROM registration r " +
	                   "JOIN course c ON r.course_id = c.course_id " +
	                   "WHERE r.student_id = ?";

	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {
	    	
	    	ps.setInt(1, studentId);
	        ResultSet rs = ps.executeQuery();

	        boolean found = false;

	        while (rs.next()) {
	            found = true;

	            System.out.println(
	                rs.getString("course_name") + " | " +
	                rs.getDouble("fees_paid")
	            );
	        }

	        if (!found) {
	            System.out.println("No courses registered");
	        }

	    } catch (SQLException e) {
	    	System.out.println(e.getMessage()); 
	        throw new DAOException("Error fetching student courses", e);
	    }
	}
	
	public boolean updateFee(int studentId, int courseId, double fee) throws DAOException {

        String query = "update registration set fees_paid = ? where student_id = ? and course_id = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setDouble(1, fee);
            ps.setInt(2, studentId);
            ps.setInt(3, courseId);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new DAOException("Registration not found for fee update");
            }

            return true;

        } catch (SQLException e) {
            throw new DAOException("Error updating fee", e);
        }
    }

	public boolean cancelCourseRegistration(int studentId, int courseId) throws DAOException {

		String query = "delete from registration where student_id = ? and course_id = ?";

		try (Connection connection = DBUtil.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setInt(1, studentId);
			ps.setInt(2, courseId);

			int rows = ps.executeUpdate();

			if (rows == 0) {
				throw new DAOException("Registration not found");
			}

			return true;

		} catch (SQLException e) {
			throw new DAOException("Error deleting registration", e);
		}
	}
	
	public void getHighPayingStudents(double amount) throws DAOException {

        String query = "select s.name, c.course_name, r.fees_paid " +
                     "from student s " +
                     "join registration r ON s.id = r.student_id " +
                     "join course c ON r.course_id = c.course_id " +
                     "where r.fees_paid > ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setDouble(1, amount);
            ResultSet rs = ps.executeQuery();

            boolean found = false;
            
            while (rs.next()) {
            	found = true;
                System.out.println(
                        rs.getString("name") + " | " +
                        rs.getString("course_name") + " | " +
                        rs.getDouble("fees_paid")
                );
            }
            
            if(!found) {
            	System.out.println("No students found with fee greater than " + amount);
            }

        } catch (SQLException e) {
            throw new DAOException("Error fetching high paying students", e);
        }
    }

    public void getCourseWiseCount() throws DAOException {

        String query = "select c.course_name, count(r.student_id) as total " +
                     "from course c " +
                     "left join registration r on c.course_id = r.course_id " +
                     "group by c.course_name";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("course_name") + " -> " +
                        rs.getInt("total")
                );
            }

        } catch (SQLException e) {
            throw new DAOException("Error generating course-wise report", e);
        }
    }
    
    // EXTRA DAO METHODS FOR SERVICE LAYER
    
    public boolean isAlreadyRegistered(int studentId, int courseId, Connection connection) throws DAOException {

        String sql = "SELECT * FROM registration WHERE student_id = ? AND course_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();
            
            if (exists) {
                System.out.println("Student is already registered for this course");
            } 
//            else {
//                System.out.println("No existing registration found");
//            }
            return exists;

        } catch (SQLException e) {
            throw new DAOException("Error checking existing registration", e);
        }
    }
       
    public boolean existsById(int id, Connection connection) throws DAOException {

        String sql = "SELECT id FROM student WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            if (exists) {
                System.out.println("Student exists");
            } else {
                System.out.println("Student does not exist");
            }
            return exists;

        } catch (SQLException e) {
            throw new DAOException("Error checking if student exists", e);
        }
    }
    
    public void deleteRegistrationsByStudent(int studentId, int courseId, Connection connection) throws DAOException {

		String query = "delete from registration where student_id = ?";

		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setInt(1, studentId);
			ps.executeUpdate();
//
//			if (rows == 0) {
//				throw new DAOException("Registration not found");
//			}
//
//			return true;

		} catch (SQLException e) {
			throw new DAOException("Error deleting all registrations", e);
		}
	}
    
}
