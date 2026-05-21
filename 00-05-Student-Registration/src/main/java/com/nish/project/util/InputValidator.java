package com.nish.project.util;

public class InputValidator {

    public static String validateName(String name)
            throws Exception {

        name = name.trim().replaceAll("\\s+", " ");

        if(name.isEmpty()) {
            throw new Exception("Name cannot be empty.");
        }

        if(!name.matches("[a-zA-Z ]+")) {
            throw new Exception(
                    "Invalid name. Only alphabets allowed.");
        }

        return name;
    }


    public static String validateEmail(String email)
            throws Exception {

        email = email.trim().replaceAll("\\s+", " ");

        if(email.isEmpty()) {
            throw new Exception("Email cannot be empty.");
        }

        String regex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if(!email.matches(regex)) {
            throw new Exception("Invalid email format.");
        }

        return email;
    }


    public static String validatePhone(String phone)
            throws Exception {

        phone = phone.trim();

        if(!phone.matches("^[6-9][0-9]{9}$")) {
            throw new Exception(
                    "Phone number must contain valid 10 digits.");
        }

        return phone;
    }


    public static String validateCity(String city)
            throws Exception {

        city = city.trim().replaceAll("\\s+", " ");

        if(city.isEmpty()) {
            throw new Exception("City cannot be empty.");
        }

        if(!city.matches("[a-zA-Z ]+")) {
            throw new Exception(
                    "Invalid city name.");
        }

        return city;
    }


    public static int validateAge(int age)
            throws Exception {

        if(age < 18 || age > 100) {
            throw new Exception(
                    "Age must be between 18 and 100.");
        }

        return age;
    }


    public static String validateCourseName(String courseName)
            throws Exception {

        courseName =
                courseName.trim().replaceAll("\\s+", " ");

        if(courseName.isEmpty()) {
            throw new Exception(
                    "Course name cannot be empty.");
        }

        return courseName;
    }


    public static String validateDuration(String duration)
            throws Exception {

        duration =
                duration.trim().replaceAll("\\s+", " ");

        if(!duration.matches("^[0-9]+ [A-Za-z]+$")) {

            throw new Exception(
                    "Duration should be like: 3 Months");
        }

        return duration;
    }


    public static double validateFees(double fees)
            throws Exception {

        if(fees <= 0) {
            throw new Exception(
                    "Fees must be greater than 0.");
        }

        return fees;
    }


    public static String validateTrainer(String trainer)
            throws Exception {

        trainer =
                trainer.trim().replaceAll("\\s+", " ");

        if(!trainer.matches("[a-zA-Z ]+")) {

            throw new Exception(
                    "Invalid trainer name.");
        }

        return trainer;
    }


    public static String validateStatus(String status)
            throws Exception {

        status = status.trim();

        if(!(status.equals("ACTIVE")
                || status.equals("COMPLETED")
                || status.equals("CANCELLED"))) {

            throw new Exception("Invalid status.");
        }

        return status;
    }
}