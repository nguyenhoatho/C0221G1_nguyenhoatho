drop database if exists Internship;
create database Internship;
use Internship;
create table faculty(
faculty_id varchar(55) not null primary key ,
faculty_name varchar(55),
phone varchar(55)
);
create table instructor(
instructor_id int not null primary key ,
instructor_name varchar(55),
salary float,
faculty_id varchar(10),
foreign key (faculty_id) references faculty(faculty_id) 
);
create table student(
student_id int not null primary key,
student_name varchar(55),
faculty_id varchar(55),
date_of_birth date,
place_of_birth varchar(30),
foreign key (faculty_id) references faculty(faculty_id)
);

create table project(
project_id varchar(10) not null primary key,
project_name varchar(30),
expense int,
place_of_intern varchar(55)
);
create table instructor_student(
student_id int,
project_id varchar(10),
instructor_id int,
grade int,
primary key (student_id,project_id,instructor_id),
foreign key (project_id) references project(project_id),
foreign key (instructor_id) references instructor(instructor_id),
foreign key (student_id) references student(student_id)
);

INSERT INTO `internship`.`project` (`project_id`, `project_name`, `expense`, `place_of_intern`) VALUES ('1', 'dien', '12115128541', 'quang nam');
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `expense`, `place_of_intern`) VALUES ('2', 'co khi', '5566565', 'da nang');
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `expense`, `place_of_intern`) VALUES ('3', 'xe don rac', '656565', 'quang nam');
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `expense`, `place_of_intern`) VALUES ('4', 'he thong dien', '565655656', 'hue');
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `expense`, `place_of_intern`) VALUES ('5', 'truyen song 5g', '6656565', 'quan nam');
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `expense`, `place_of_intern`) VALUES ('6', 'he thong mang trong ai', '9889566', 'quang nam');

INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('1', '1', '1', '10');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('2', '2', '2', '11');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('3', '3', '3', '12');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('4', '4', '4', '13');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('5', '5', '5', '14');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('6', '6', '6', '15');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('7', '2', '7', '16');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('8', '3', '8', '17');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('9', '4', '9', '18');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('10', '5', '10', '19');
