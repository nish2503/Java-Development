package com.nish.project.model;

public class Student {

    private int id;
    private String name;
    private int age;
    private int branchId;

    public Student(int id, String name, int age, int branchId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.branchId = branchId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}