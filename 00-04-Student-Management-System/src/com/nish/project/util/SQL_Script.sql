CREATE DATABASE student_management;
USE student_management;

CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT CHECK (age > 0),
    branch VARCHAR(50)
);

CREATE TABLE registration (
    reg_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_name VARCHAR(50),
    fees_paid DOUBLE CHECK (fees_paid > 0),

    FOREIGN KEY (student_id)
    REFERENCES student(id)
 
);

ALTER TABLE registration
ADD CONSTRAINT fk_student
FOREIGN KEY (student_id) REFERENCES student(id)
ON DELETE CASCADE;

ALTER TABLE registration DROP FOREIGN KEY fk_student;
ALTER TABLE registration
ADD CONSTRAINT fk_student
FOREIGN KEY (student_id)
REFERENCES student(id);

CREATE TABLE branch (
    branch_id INT PRIMARY KEY,
    branch_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE course (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(50) NOT NULL,
    branch_id INT,
    FOREIGN KEY (branch_id) REFERENCES branch(branch_id)
);

ALTER TABLE student 
ADD COLUMN branch_id INT,
ADD CONSTRAINT fk_branch
FOREIGN KEY (branch_id)
REFERENCES branch(branch_id);

ALTER TABLE registration 
ADD COLUMN course_id INT,
ADD CONSTRAINT fk_course
FOREIGN KEY (course_id)
REFERENCES course(course_id);

ALTER TABLE registration
ADD CONSTRAINT unique_registration
UNIQUE (student_id, course_id);

SELECT * FROM registration;
ALTER TABLE registration DROP COLUMN course_name;

ALTER TABLE student DROP COLUMN branch;

INSERT INTO branch (branch_id, branch_name) VALUES
(1, 'Computer Science'),
(2, 'Electronics'),
(3, 'Mechanical'),
(4, 'Civil');

INSERT INTO course (course_id, course_name, branch_id) VALUES
(101, 'Java', 1),
(102, 'Data Structures', 1),
(103, 'Operating Systems', 1),

(201, 'Digital Electronics', 2),
(202, 'Microprocessors', 2),

(301, 'Thermodynamics', 3),
(302, 'Fluid Mechanics', 3),

(401, 'Structural Engineering', 4);

INSERT INTO student (id, name, age, branch_id) VALUES
(1, 'Krishn', 21, 1),
(2, 'Radha', 20, 2),
(3, 'Priya', 20, 1),
(4, 'Arjun', 23, 3);

INSERT INTO registration (student_id, course_id, fees_paid) VALUES
(1, 101, 5000),
(1, 102, 7000),
(2, 201, 6000),
(2, 202, 8000),
(3, 101, 7200),
(3, 103, 6500),
(4, 301, 5500);

SHOW CREATE TABLE registration;

ALTER TABLE registration
DROP INDEX unique_registration;

ALTER TABLE registration
ADD CONSTRAINT unique_registration 
UNIQUE (student_id, course_id);

DROP TABLE registration;

CREATE TABLE registration (
    reg_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT,
    fees_paid DOUBLE,

    CONSTRAINT fk_student
    FOREIGN KEY (student_id) REFERENCES student(id)
    ON DELETE CASCADE,

    CONSTRAINT fk_course
    FOREIGN KEY (course_id) REFERENCES course(course_id),

    CONSTRAINT unique_registration
    UNIQUE (student_id, course_id)
);

INSERT INTO registration (student_id, course_id, fees_paid) VALUES
(1, 101, 5000),
(1, 102, 7000),
(2, 201, 6000),
(2, 202, 8000),
(3, 101, 7200),
(3, 103, 6500),
(4, 301, 5500);

SELECT * FROM registration WHERE student_id = 4;