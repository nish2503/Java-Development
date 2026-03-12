package com.nish.ExceptionHandling.Assignment;

public class StudentGradingSystem {

    public static void main(String[] args) {

//        String name = "Nishtha";
        String name = null;
        int marks = 105;          

        try {
            validateStudent(name, marks);

            System.out.println("Student Name: " + name);
            System.out.println("Marks: " + marks);
            System.out.println("Grade: " + calculateGrade(marks));
        }
        catch (NullPointerException e) {
            System.out.println("Error: Student name cannot be null.");
        }
        catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Grading process completed.");
        }
    }

    public static void validateStudent(String name, int marks)
            throws InvalidMarksException {

        if (name == null) {
            throw new NullPointerException();
        }

        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException(
                    "Marks must be between 0 and 100.");
        }
    }

    public static String calculateGrade(int marks) {

        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }
}