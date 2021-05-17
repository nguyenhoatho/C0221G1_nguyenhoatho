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