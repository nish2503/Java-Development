package com.nish.project.model;

public class Course {

    private int id;
    private String name;
    private String duration;
    private double fees;
    private String trainerName;

    public Course() {}

    public Course(int courseId, String name, String duration, double fees, String trainerName) {
        this.id = courseId;
        this.name = name;
        this.duration = duration;
        this.fees = fees;
        this.trainerName = trainerName;
    }

    public Course(String name, String duration, double fees, String trainerName) {
        this.name = name;
        this.duration = duration;
        this.fees = fees;
        this.trainerName = trainerName;
    }

    public int getCourseId() { return id; }
    public String getName() { return name; }
    public String getDuration() { return duration; }
    public double getFees() { return fees; }
    public String getTrainerName() { return trainerName; }
}