-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và
--  đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ 
--  với ngày lập hợp đồng là “12/12/2019”
create view V_NHANVIEN as 
select *
from nhan_vien
where nhan_vien.id_nhan_vien in
(
select nhan_vien.id_nhan_vien
from nhan_vien 
join hop_dong on nhan_vien.id_nhan_vien=hop_dong.id_nhan_vien
where nhan_vien.dia_chi like "hue"
and  hop_dong.ngay_hop_dong="2019-03-14"
);
-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhan_vien 
set dia_chi = 'Liên Chiểu'
where id_nhan_vien in (v_nhan_vien.id_nhan_vien);

-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được
--  truyền vào như là 1 tham số của Sp_1
delimiter //
create procedure sp_1(in p_id_delete int)
begin
delete from khach_hang kh
where kh.id_khach_hang = p_id_delete;
end;
// delimiter ;
-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải
--  thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và 
-- đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
delimiter //
create procedure sp_2(p_id int, p_id_nv int, p_id_kh int,p_id_dv int, p_ngay_lam_hd date,
				       p_ngay_ket_thuc date,p_tien_dat_coc double,p_tong_tien double)
begin
	if ((p_id in (select hd.id_hop_dong from hop_dong hd ))
		or (p_id_nv not in (select nv.id_nhan_vien from nhan_vien nv))
		or (p_id_kh) not in (select kh.id_khach_hang from khach_hang kh)
		or (p_id_dv) not in (select dv.id_dich_vu from dich_vu dv))
	 then
		begin
		SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Trùng ID Hợp Đồng or Các ID khác không hợp lệ';
		end;
	else 
		begin
		insert into hop_dong 
		values(p_id,p_id_nv,p_id_kh,p_id_dv,p_ngay_lam_hd,p_ngay_ket_thuc,p_tien_dat_coc,p_tong_tien);
		end; 
	end if;
end;
// delimiter ;
call sp_2(2,2,2,2,"2021/12/03","2021/12/10","1000000","200000000");
-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng H
-- opDong ra giao diện console của database
delimiter //
create trigger tr_1 
	after delete 
    on hop_dong for each row
begin
set @count_hd = (select count(hd.id_hop_dong) from hop_dong hd);
 select concat("Số lượng bản ghi còn lại là: ",@count_hd) as log 
 into outfile "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/tr_1.log";
end;
// delimiter 
select * from hop_dong;
delete from hop_dong hd
where hd.id_hop_dong = 6
--  task26

delimiter //
create trigger tr_2 
before update 
on hop_dong for each row
begin
	if(datediff(new.ngay_ket_thuc,old.ngay_lam_hop_dong)<=2) then 
	SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = "Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày";
    end if;
end;
// delimiter ;

update hop_dong hd
set hd.ngay_ket_thuc = "2019-12-05"
where hd.id_hop_dong =4;

-- task 27
  
-- a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.

delimiter //
create function func_1()
returns int
deterministic
begin
	declare count_dv int;
    set count_dv = (select count(dv.id_dich_vu) 
		from dich_vu dv
		where id_dich_vu in (
		select dv.id_dich_vu
		from hop_dong hd
		 join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
		 join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
		 join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
		group by hd.id_dich_vu
		having sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia)>2000000));
	return count_dv;
end;
// delimiter ;

select func_1();


-- b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng
-- đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ 
-- (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, 
-- không xét trên toàn bộ các lần làm hợp đồng). Mã của Khách hàng được truyền vào như là 1 tham số của function này)

delimiter //
create function func_2(p_id_khach_hang int)
returns int
deterministic
begin
	declare max_time int;
    set max_time = (select max(`time`)
			from (select datediff(hd.ngay_ket_thuc,hd.ngay_lam_hop_dong) as `time` 
				 from hop_dong hd 
				 where hd.id_khach_hang = p_id_khach_hang)
			as tg);
	return max_time;
end;
// delimiter ;

select func_2(1);

-- task 28
-- 28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room”
--  từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) 
--  và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) 
--  và những bản liên quan khác.

delimiter //
create procedure sp_3()
begin
	delete from dich_vu 
    where dich_vu.id_dich_vu in (select tdv.id_dv from ( select dv.id_dich_vu as id_dv
from dich_vu dv 
join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
join khach_hang kh on kh.id_khach_hang = hd.id_khach_hang 
join nhan_vien nv on nv.id_nhan_vien = hd.id_nhan_vien
where dv.id_loai_dich_vu = 3
and (year(hd.ngay_lam_hop_dong) between 2015 and 2019)) as tdv) ;
end;
// delimiter ;

