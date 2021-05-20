-- 1.	Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn

select project.project_id,project.project_name
from project
join instructor_student on project.project_id=instructor_student.project_id
join instructor on instructor_student.instructor_id=instructor.instructor_id
where instructor.instructor_name="thang"
group by project_id;

-- 2.	Cho biết tên đề tài không có sinh viên nào thực tập
select project.project_name
from project
join instructor_student on project.project_id=instructor_student.project_id
join student on instructor_student.student_id=student.student_id
where project.project_id not in
( select instructor_student.project_id
	from instructor_student
);

-- 3.	Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.
select instructor.instructor_id,instructor.instructor_name,faculty.faculty_name
from instructor
join instructor_student on instructor.instructor_id=instructor_student.instructor_id
join faculty On faculty.faculty_id=instructor.faculty_id
group by instructor_id
having count(instructor_student.project_id)>=3;

-- 4.	Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
select project.project_id ,project.project_name
from project
where project.expense in (
select max(expense)
from project
)
group by project_id;
-- 5.	Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập

select project.project_id ,project.project_name 
from project
join instructor_student on project.project_id=instructor_student.project_id
group by project_id
having count(instructor_student.project_id)>2;

-- 6.	Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘DIALY và QLTN’
select student.student_id ,student.student_name,instructor_student.grade
from student
join instructor_student on student.student_id=instructor_student.student_id
join faculty on student.faculty_id=faculty.faculty_id
where faculty.faculty_name="khoa dien" or faculty_name="khoa dtvt"
group by student_id;

-- 7.	Đưa ra tên khoa, số lượng sinh viên của mỗi khoa

select faculty.faculty_name, count(student.student_id) as so_luong_sinh_vien
from faculty
join student on faculty.faculty_id=student.faculty_id
group by faculty_name;

-- 8.	Cho biết thông tin về các sinh viên thực tập tại quê nhà
select *
from student
join instructor_student on student.student_id=instructor_student.student_id
join project on project.project_id=instructor_student.project_id
where student.place_of_birth = project.place_of_intern;

-- 9.	Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
select *
from student
join instructor_student on student.student_id=instructor_student.student_id
where instructor_student.grade=null;

-- 10.Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0
select student.student_id,student.student_name 
from student
join instructor_student on student.student_id=instructor_student.student_id
where instructor_student.grade=0
group by student_id;



