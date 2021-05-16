use student_management;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select sb.sub_id, sb.sub_name,max(sb.credit)as max_credit,sb.`Status`
from `subject` as sb;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất
select sb.sub_id ,sb.sub_name,sb.credit,sb.`status`,max(mark.mark)as max_mark
from `subject` as sb
join mark on sb.sub_id=mark.sub_id;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.student_id,student.student_name,student.address,student.Phone,student.class_id, avg(mark.mark) as "diem trung binh"
from student
join mark on student.student_id=mark.student_id
group by student.student_id
order by avg(mark.mark) desc;