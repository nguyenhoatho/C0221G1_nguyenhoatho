use quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *,max(sub.credit)
from `subject` sub
group by sub.sub_id
having max(sub.credit) >= all (
		select max(sub.credit)
		from `subject` sub
		group by sub.sub_id)
;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select sub.sub_id,sub.sub_name,max(m.mark)
from `subject` sub
join mark m on sub.sub_id = m.sub_id
group by m.sub_id
having max(m.mark) >= all (
		select max(m.mark)
		from `subject` sub
		join mark m on sub.sub_id = m.sub_id
		group by m.sub_id)
;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.student_id,s.student_name,avg(m.mark)
from student s
left join mark m on m.student_id = s.student_id
group by m.student_id
order by m.student_id desc,s.student_name;