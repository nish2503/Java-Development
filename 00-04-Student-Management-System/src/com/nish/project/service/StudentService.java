package com.nish.project.service;

import java.sql.Connection;

import com.nish.project.dao.RegistrationDAO;
import com.nish.project.dao.StudentDAO;
import com.nish.project.exception.DAOException;
import com.nish.project.model.Student;
import com.nish.project.util.DBUtil;

public class StudentService {
	private StudentDAO studentDAO = new StudentDAO();
	private RegistrationDAO registrationDAO = new RegistrationDAO();
	
	public void registerCourse(int studentId, int courseId, double fee) {
		Connection connection = null;
		
		try {
			if(fee<=0) {
				System.out.println("Fee must be greater than 0");
				return;
			}
			
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			
			if(!studentDAO.existsById(studentId, connection)) {
				connection.rollback();
				System.out.println("Student does not exist");
				return;
			}
			
			if(registrationDAO.isAlreadyRegistered(studentId, courseId, connection)) {
				connection.rollback();
				System.out.println("Student already registered for this course");
				return;
			}
			
			registrationDAO.registerStudent(studentId, courseId, fee, connection);
			connection.commit();
			System.out.println("Course registered successfully");
			
		} catch(Exception e) {
			try {
				if(connection != null) connection.rollback();
			} catch (Exception ex){
				System.out.println("Rollback failed");
			}
			System.out.println("Registration failed");
			
		} finally {
			try {
				if(connection != null) connection.setAutoCommit(true);
			} catch(Exception e) {
				System.out.println("Error resetting connection");
			}
		}
	}
	
	public void addStudent(Student student) {
		try {
			studentDAO.insertStudent(student);
			System.out.println("Student added successfully");
		} catch (DAOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void viewAllStudentsWithRegistrations() {
		try {
			System.out.println("\nname | course | fee");
			System.out.println("-----------------------");
			registrationDAO.getAllStudentsWithRegistration();
			System.out.println("\nDetails retrieved");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void searchStudentRegistrationById(int id) {
		try {
			Student s = studentDAO.getStudentById(id);
			
			if(s==null) {
				System.out.println("Student not found");
				return;
			}
			
			System.out.println("Name: " + s.getName());
			System.out.println("Age: " + s.getAge());
			System.out.println("Courses: ");
			
			registrationDAO.getStudentRegistrationById(id);
			
		} catch (DAOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void updateStudentDetails(int id, String name, int branchId) {
	    try {
	        Student student = new Student(id, name, 0, branchId);

	        studentDAO.updateStudent(student);

	        System.out.println("Student details updated successfully");

	    } catch (DAOException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public void updateCourseFee(int studentId, int courseId, double fee) {
        try {
            if (fee <= 0) {
                System.out.println("Fee must be greater than 0");
                return;
            }
            
            if (!studentDAO.existsById(studentId)) {
                System.out.println("Student does not exist");
                return;
            }

            registrationDAO.updateFee(studentId, courseId, fee);
            System.out.println("Fee updated successfully");

        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void cancelCourse(int studentId, int courseId) {
        try {
        	if(!studentDAO.existsById(studentId)) {
        		System.out.println("Student does not exist");
        		return;
        	}
        	
        	boolean deleted = registrationDAO.cancelCourseRegistration(studentId, courseId);
            
        	if(!deleted) {
        		System.out.println("Student not registered for this course");
            } else {
            	System.out.println("Course cancelled successfully");
            }

        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void deleteStudent(int studentId) {
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			
			registrationDAO.deleteRegistrationsByStudent(studentId, studentId, connection);
			
			boolean deleted = studentDAO.deleteStudent(studentId, connection);
			
			if(!deleted) {
				connection.rollback();
				System.out.println("Student not found");
				return;
			}
			connection.commit();
			System.out.println("Student deleted successfully.");
			
		} catch(Exception e) {
			try {
				if(connection != null) connection.rollback();
			} catch(Exception ex) {
				System.out.println("Rollback failed");
			}
//			System.out.println("Deletion failed. Rolled back.");
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if(connection != null) connection.setAutoCommit(true);
			} catch(Exception e) {
				System.out.println("Error resetting connection");
			}
		}
	}
	
	public void highPaying(double amount) {
        try {
            registrationDAO.getHighPayingStudents(amount);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void courseReport() {
        try {
            registrationDAO.getCourseWiseCount();
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean studentExists(int id) {
        try {
            return studentDAO.existsById(id); 
        } catch (DAOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
	
}
