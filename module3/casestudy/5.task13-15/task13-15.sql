use furama;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất 
-- bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.id_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem,dvdk.gia
from dich_vu_di_kem as dvdk
join hop_dong_chi_tiet as hdct on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
where hdct.so_luong in
( select max(hdct.so_luong)
from hop_dong_chi_tiet as hdct
)
group by dvdk.id_dich_vu_di_kem;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
--  Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select hd.id_hop_dong,dv.ten_dich_vu,dvdk.ten_dich_vu_di_kem,hdct.so_luong
from hop_dong as hd
join dich_vu as dv on hd.id_dich_vu=dv.id_dich_vu
join hop_dong_chi_tiet as hdct on hd.id_hop_dong=hdct.id_hop_dong
join dich_vu_di_kem as dvdk on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
where  so_luong=1
group by dvdk.id_dich_vu_di_kem;
-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi
--  mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select  nv.id_nhan_vien,nv.ho_ten, td.trinh_do, bp.ten_bo_phan ,nv.so_dt,nv.dia_chi
from nhan_vien as nv
join trinh_do as td on nv.id_trinh_do=td.id_trinh_do
join bo_phan as bp on nv.id_bo_phan=bp.id_bo_phan
join hop_dong as hd on nv.id_nhan_vien=hd.id_nhan_vien
where  year(hd.ngay_hop_dong) in (2018,2019)
group by nv.id_nhan_vien
having count(hd.id_nhan_vien)<=3;

