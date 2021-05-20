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
expense int
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


