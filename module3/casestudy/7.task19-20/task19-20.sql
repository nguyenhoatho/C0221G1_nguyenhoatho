use furama;

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update dich_vu_di_kem
set dich_vu_di_kem.gia = (dich_vu_di_kem.gia*2)
where dich_vu_di_kem.id_dich_vu_di_kem in
	  (select dvdk.id_dvdk from 
      ( select dvdk.id_dich_vu_di_kem as id_dvdk
	  from dich_vu_di_kem dvdk
	  join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem =dvdk.id_dich_vu_di_kem
	  join hop_dong hd on hd.id_hop_dong = hdct.id_hop_dong_chi_tiet
	  where year(hd.ngay_hop_dong)=2019
	  group by dvdk.id_dich_vu_di_kem
	  having count(dvdk.id_dich_vu_di_kem)>10
    ) as dvdk);
    
-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển 
--  bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

 select id_nhan_vien,ho_ten,email,so_dt,ngay_sinh,dia_chi
 from nhan_vien
 union  
 select id_khach_hang, ho_ten,email,so_dt,ngay_sinh,dia_chi
 from khach_hang;