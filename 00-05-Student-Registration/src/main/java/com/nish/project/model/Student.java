package com.nish.project.model;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private int age;
    private String phone;
    private String city;

    public Student() {}

    public Student(int studentId, String name, String email, int age, String phone, String city) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.city = city;
    }

    public Student(String name, String email, int age, String phone, String city) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.city = city;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int id) { this.studentId = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}