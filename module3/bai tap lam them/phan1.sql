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
select count(student.student_id) as so_luong
from student
join faculty on faculty.faculty_id=student.faculty_id
where faculty.faculty_name ="khoa dien";
-- 4.	Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên khoa ‘TOAN’
select student.student_id,student.student_name, round(datediff(now(),student.date_of_birth)/365) as tuoi
from student
join faculty on faculty.faculty_id=student.faculty_id
where faculty_name="khoa dtvt";

-- 5.	Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC

select count(instructor_id) as so_luong
from instructor
join faculty on faculty.faculty_id=instructor.faculty_id
where faculty_name="khoa co khi gt";

-- 6.	Cho biết thông tin về sinh viên không tham gia thực tập
select *
from student
join instructor_student on student.student_id= instructor_student.student_id
where student.student_id not in
(select student_id
from instructor_student
);

-- 7.	Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa

select faculty.faculty_id,faculty.faculty_name,count(instructor.instructor_id) as so_luong_giang_vien
from faculty
join instructor on faculty.faculty_id=instructor.faculty_id
group by faculty_id;

-- 8.	Cho biết số điện thoại của khoa mà sinh viên có tên ‘Le van son’ đang theo học
select faculty.phone
from faculty
join student on faculty.faculty_id=student.faculty_id
where student.student_name="tho";


