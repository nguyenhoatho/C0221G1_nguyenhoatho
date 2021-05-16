use furama;
-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được
--  Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu as dv,hop_dong as hd,loai_dich_vu as ldv
where dv.id_dich_vu=ldv.id_loai_dich_vu
and dv.id_dich_vu=hd.id_dich_vu
and hd.ngay_hop_dong not in 
 (
	select hop_dong.ngay_hop_dong
	from hop_dong
	where year(ngay_hop_dong)=2019 and
 (	month(ngay_hop_dong)=1 or month(ngay_hop_dong)=2 or month(ngay_hop_dong)=3));
 --  7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các 
 -- loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa 
 -- từng được Khách hàng đặt phòng  trong năm 2019.
select dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.so_nguoi_toi_da,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu as dv,loai_dich_vu as ldv,hop_dong as hd
where dv.id_loai_dich_vu=ldv.id_loai_dich_vu
and hd.id_dich_vu=dv.id_dich_vu
and   year(hd.ngay_hop_dong)=2018 
and year(hd.ngay_ket_thuc)=2018 
and hd.id_dich_vu not in 
(
select hd.id_dich_vu
from hop_dong as hd
where  year(hd.ngay_hop_dong)=2019 and year(hd.ngay_ket_thuc)=2019
);
-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
 -- cach 1
select distinct kh.ho_ten
from khach_hang as kh;
-- cach 2
select  kh.ho_ten
from khach_hang as kh
group by kh.ho_ten;
-- cach 3
select  kh.ho_ten
from khach_hang as kh
union 
select ho_ten from khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi
 -- tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng
select month(hd.ngay_hop_dong) as `thang` ,sum((dv.chi_phi_thue + (dvdk.gia * hdct.so_luong))) as "tong tien"
from hop_dong as hd, dich_vu as dv,hop_dong_chi_tiet as hdct,dich_vu_di_kem as dvdk ,khach_hang as kh,loai_khach as lk
where hd.id_dich_vu=dv.id_dich_vu
and  hd.id_hop_dong= hdct.id_hop_dong
and hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
and kh.id_loai_khach=lk.id_loai_khach
and hd.id_khach_hang=kh.id_khach_hang
and dv.id_dich_vu=hd.id_dich_vu
and year(hd.ngay_hop_dong) =2019
group by hd.ngay_hop_dong;


