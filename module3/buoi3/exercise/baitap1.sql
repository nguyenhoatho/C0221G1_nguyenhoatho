-- drop database if exists student_management;
create database student_management;
use student_management;
CREATE TABLE class
(
    class_iD   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(60) NOT NULL,
    start_date DATETIME    NOT NULL,
    status    BIT
);
INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
CREATE TABLE student
(
    student_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    class_id     INT         NOT NULL,
    FOREIGN KEY (class_id) REFERENCES Class (Class_iD)
);
INSERT INTO student (student_name, address, phone, status, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (student_name, address, status, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (student_name, address, phone, status, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
CREATE TABLE `subject`
(
    sub_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( credit >= 1 ),
    Status  BIT                  DEFAULT 1
);

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);

create TABLE mark
(
    mark_id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_id     INT NOT NULL,
    student_id INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 11),
    exam_times TINYINT DEFAULT 1,
    -- UNIQUE (sub_id, student_id),
    FOREIGN KEY (sub_id) REFERENCES Subject (sub_id),
    FOREIGN KEY (student_id) REFERENCES Student (student_id)
);
INSERT INTO `student_management`.`mark` (`mark_id`, `sub_id`, `student_id`, `mark`, `exam_times`)
VALUES ('1', '1', '1', '8', '1');
INSERT INTO `student_management`.`mark` (`mark_id`, `sub_id`, `student_id`, `mark`, `exam_times`) 
VALUES ('2', '1', '2', '9', '2');
INSERT INTO `student_management`.`mark` (`mark_id`, `sub_id`, `student_id`, `mark`, `exam_times`)
VALUES ('3', '2', '1', '10', '1');
-- tim ten sinh vien co ki tụ bat dau bang H
select *from student_management.student
where student_name like "H_%";
-- hien thi ten lop ngay bat dau bang thang 12
select *from student_management.class
where month(start_date)=12;
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select *from student_management.subject
where credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
SET SQL_SAFE_UPDATES = 0;
update student
set class_id=2
where student_name like "Hung";
select *from student;
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần
select student.student_name,`subject`.sub_name,mark.mark
from mark 
join student on mark.student_id=student.student_id
join `subject` on mark.sub_id=`subject`.sub_id
order by mark.mark desc ,student.student_name asc;



