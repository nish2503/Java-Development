package com.nish.project.dao;

import java.sql.*;

import com.nish.project.exception.DAOException;
import com.nish.project.model.Student;
import com.nish.project.util.DBUtil;

public class StudentDAO {
	public boolean insertStudent(Student student) throws DAOException{
		
		String query = "insert into student values (?, ?, ?, ?)";
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)){
			
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
			ps.setInt(4, student.getBranchId());
			
			return ps.executeUpdate() > 0;
		}
		catch (SQLException e){
			String message;
			if(e.getMessage().contains("Duplicate entry")) {
				message = "Student with this ID already exists.";
			} 
			else if(e.getMessage().contains("foreign key")) {
				message = "Invalid Branch ID. Branch does not exist.";
			}
			else {
				message = "Failed to insert student.";
			}
			throw new DAOException(message, e);
		}
	}
	
	public Student getStudentById(int id) throws DAOException {
		String query = "select * from student where id = ?";
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Student(rs.getInt("id"),
						rs.getString("name"),
		                rs.getInt("age"),
		                rs.getInt("branch_id"));
			}
			else {
				return null;
			}
		}
		catch(SQLException e){
			throw new DAOException("Error fetching student by ID", e);
		}
	}
	
	public boolean updateStudent(Student student) throws DAOException{
		String query = "update student set name = ?, branch_id = ? where id = ?";
		
		try(Connection connection = DBUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(query)){
			ps.setString(1, student.getName());
			ps.setInt(2, student.getBranchId());
			ps.setInt(3, student.getId());
			
			int rows = ps.executeUpdate();
			
			if(rows == 0) {
				throw new DAOException("Student id not found for updation");
			}
			
			return true;
		}
		catch(SQLException e) {
			throw new DAOException("Error updating student details", e);
		}
	}
	
	public boolean deleteStudent(int id, Connection connection) throws DAOException{
		String sql = "delete from student where id = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			
			if(rows == 0) {
				throw new DAOException("Student id not found for deletion");
			}
			return true;
		}
		catch(SQLException e) {
			throw new DAOException("Error deleting student", e);
		}
	}
	
	// EXTRA DAO METHODS FOR SERVICE LAYER
	
	public boolean existsById(int id, Connection connection) throws SQLException {

	    String sql = "SELECT id FROM student WHERE id = ?";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        return rs.next();
	    }
	}
	
	public boolean existsById(int id) throws DAOException {

	    String sql = "SELECT id FROM student WHERE id = ?";

	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        return rs.next();

	    } catch (SQLException e) {
	        throw new DAOException("Error checking student existence", e);
	    }
	}
	
}
