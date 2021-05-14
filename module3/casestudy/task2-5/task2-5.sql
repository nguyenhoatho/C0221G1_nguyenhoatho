use furama;
-- task2
-- do nhap du lieu sai nen em lam theo du lieu cua em
select *from furama.nhan_vien
where ho_ten like "h%" or ho_ten like "t%" or ho_ten like "k%";
-- task3
select *from furama.khach_hang
where ((year(curdate())-year(ngay_sinh))<=53 and (year(curdate())-year(ngay_sinh))>=18)
 and (dia_chi like "da nang" or dia_chi like "quang tri");
SET SQL_SAFE_UPDATES = 0;
-- task 4
select hop_dong.id_khach_hang, khach_hang.ho_ten,loai_khach.ten_loai_khach, count(hop_dong.id_dich_vu) as dem_sohd
from hop_dong join khach_hang on hop_dong.id_khach_hang = khach_hang.id_khach_hang
join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
group by hop_dong.id_khach_hang
having loai_khach.ten_loai_khach = "Diamond"
order by dem_sohd;
-- task 5
select kh.id_khach_hang, kh.ho_ten,lk.ten_loai_khach,hd.id_hop_dong,dv.ten_dich_vu,
hd.ngay_hop_dong,hd.ngay_ket_thuc, (dv.chi_phi_thue + (dvdk.gia * hdct.so_luong)) as tong_tien
from khach_hang 
as kh left join loai_khach as lk on kh.id_loai_khach = lk.id_loai_khach
					left join hop_dong as hd on kh.id_khach_hang = hd.id_khach_hang
                    left join dich_vu as dv on hd.id_dich_vu = dv.id_dich_vu
                    left join hop_dong_chi_tiet as hdct on hd.id_hop_dong = hdct.id_hop_dong
                    left join dich_vu_di_kem as dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem;

