CREATE DATABASE student_course_db;
USE student_course_db;

create table admin(
	admin_id int auto_increment primary key,
    username varchar(50) not null unique,
    password varchar(100) not null
);

insert into admin(username, password)
values ('admin', 'admin123');
select * from students;
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    age INT NOT NULL,
    city VARCHAR(50) NOT NULL
);

CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    duration VARCHAR(50) NOT NULL,
    fees DOUBLE NOT NULL,
    trainer_name VARCHAR(100) NOT NULL
);

CREATE TABLE registrations (
    registration_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    registration_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL,

    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

ALTER TABLE registrations
ADD CONSTRAINT unique_student_course UNIQUE (student_id, course_id);

show tables;
select * from admin;

ALTER TABLE students
ADD CONSTRAINT unique_student_email
UNIQUE (email);

ALTER TABLE students
ADD CONSTRAINT unique_student_phone
UNIQUE (phone);

ALTER TABLE courses
ADD CONSTRAINT unique_course_name
UNIQUE (course_name);