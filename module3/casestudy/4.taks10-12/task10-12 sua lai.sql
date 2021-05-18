-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
--  Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).
select  hd.id_hop_dong,hd.ngay_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc,hdct.so_luong,count(hdct.id_hop_dong_chi_tiet)
from hop_dong as hd,hop_dong_chi_tiet as hdct,dich_vu_di_kem as dvdk
where hd.id_hop_dong=hdct.id_hop_dong
and dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
group by hdct.id_hop_dong_chi_tiet;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang
--  là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,lk.ten_loai_khach,kh.dia_chi
from dich_vu dv
join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
where lk.ten_loai_khach = "Diamond" and (kh.dia_chi in ("vinh","quang ngai"))
group by dv.ten_dich_vu;

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, 
-- SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng
--  được khách hàng đặt vào 3 tháng 
-- cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select hd.id_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dt ,dv.ten_dich_vu,hdct.so_luong,hd.tien_dat_coc
from hop_dong as hd
join nhan_vien as nv on hd.id_nhan_vien=nv.id_nhan_vien
join khach_hang as kh on hd.id_khach_hang=kh.id_khach_hang
join dich_vu as dv on hd.id_dich_vu=dv.id_dich_vu
join hop_dong_chi_tiet as hdct on hd.id_hop_dong=hdct.id_hop_dong
where year(hd.ngay_hop_dong)=2019 and
month(hd.ngay_hop_dong) in (10,11,12)
group by hd.id_hop_dong;
