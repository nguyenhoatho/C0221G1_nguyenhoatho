-- 1.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên
select *
from instructor;
-- 2.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’
select instructor_id,instructor_name,faculty_name
from instructor
join faculty on faculty.faculty_id=instructor.faculty_id
where faculty_name like "khoa dien" or faculty_name like "khoa co khi"
group by instructor_id;

-- 3.	Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’
select count(student.student_id)
from student
join faculty on faculty.
