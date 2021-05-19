use furama;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019
SET FOREIGN_KEY_CHECKS=0;
delete from nhan_vien 
where nhan_vien.id_nhan_vien  not in
 (select tmp.nvid from (select distinct  distinct nhan_vien.id_nhan_vien as nvid
	from nhan_vien 
	inner join hop_dong on nhan_vien.id_nhan_vien=hop_dong.id_nhan_vien
	where year( hop_dong.ngay_hop_dong) in (2017,2018,2019)
    ) as tmp);

    -- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với
--  tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ

update khach_hang
set khach_hang.id_loai_khach = 5
where khach_hang.id_khach_hang in
( select kh.id_kh from(select khach_hang.id_khach_hang as id_kh
	from khach_hang 
    join hop_dong on hop_dong.id_khach_hang=khach_hang.id_khach_hang
    where khach_hang.id_loai_khach = 4 and year(hop_dong.ngay_hop_dong) =2019
    group by khach_hang.id_loai_khach,hop_dong.id_khach_hang
    having sum(hop_dong.tong_tien) >10000000
    )as kh
 );
 -- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
 delete from khach_hang 
where khac_hang.id_khach_hang in (
	  select hd.id_khach_hang
      from hop_dong as hd
	  where year(hd.ngay_hop_dong)<2016)
;

 
 