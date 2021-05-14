drop database if exists furama;
create database furama;
use furama;
create table vi_tri(
id_vi_tri int not null primary key,
ten_vi_tri varchar(45)
);
create table trinh_do(
id_trinh_do int not null primary key,
trinh_do varchar(45)
);
create table bo_phan(id_bo_phan int not null primary key,
ten_bo_phan varchar(45)
);
create table nhan_vien(
id_nhan_vien int not null primary key,
ho_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmnd varchar(45),
luong varchar(45),
so_dt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key(id_vi_tri) references vi_tri(id_vi_tri),
foreign key (id_trinh_do) references trinh_do(id_trinh_do),
foreign key(id_bo_phan) references bo_phan(id_bo_phan)
);
create table loai_khach(
id_loai_khach int not null primary key,
ten_loai_khach varchar(45)
);
create table khach_hang(
id_khach_hang int not null primary key,
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
so_dt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key(id_loai_khach) references loai_khach(id_loai_khach)
);
create table kieu_thue(
id_kieu_thue int not null  primary key,
ten_kieu_thue varchar(45),
gia int
);
create table loai_dich_vu(
id_loai_dich_vu int not null  primary key,
ten_loai_dich_vu varchar(45)
);
create table dich_vu(
id_dich_vu int not null  primary key,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai varchar(45),
foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);
create table hop_dong (
id_hop_dong int not null  primary key,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key(id_khach_hang) references khach_hang(id_khach_hang),
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);
create table dich_vu_di_kem(
id_dich_vu_di_kem int not null  primary key,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45)
);
create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int  primary key,
id_hop_dong int,
id_dich_vu_di_kem int,
foreign key(id_hop_dong) references hop_dong(id_hop_dong),
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem),
so_luong int
);
-- them vao bo phan
INSERT INTO `furama`.`bo_phan` (`id_bo_phan`, `ten_bo_phan`) VALUES ('1', 'ban hang');
INSERT INTO `furama`.`bo_phan` (`id_bo_phan`, `ten_bo_phan`) VALUES ('2', 'le tan ');
INSERT INTO `furama`.`bo_phan` (`id_bo_phan`, `ten_bo_phan`) VALUES ('3', 'phuc vu');
-- them vao vi tri
INSERT INTO `furama`.`vi_tri` (`id_vi_tri`, `ten_vi_tri`) VALUES ('1', 'dau bep');
INSERT INTO `furama`.`vi_tri` (`id_vi_tri`, `ten_vi_tri`) VALUES ('2', 'quan ly');
INSERT INTO `furama`.`vi_tri` (`id_vi_tri`, `ten_vi_tri`) VALUES ('3', 'giam doc');
-- them vao trinh do
INSERT INTO `furama`.`trinh_do` (`id_trinh_do`, `trinh_do`) VALUES ('1', 'trung cap');
INSERT INTO `furama`.`trinh_do` (`id_trinh_do`, `trinh_do`) VALUES ('2', 'cao dang');
INSERT INTO `furama`.`trinh_do` (`id_trinh_do`, `trinh_do`) VALUES ('3', 'dai hoc');
-- them nhan vien
INSERT INTO `furama`.`nhan_vien` (`id_nhan_vien`, `ho_ten`, `id_vi_tri`, `id_trinh_do`, `id_bo_phan`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dt`, `email`, `dia_chi`) VALUES ('1', 'nguyen van k', '1', '1', '1', '1996-1-12', '2006789', '4000000', '089456741', 'ngy@gmail.com', 'quang nam');
INSERT INTO `furama`.`nhan_vien` (`id_nhan_vien`, `ho_ten`, `id_vi_tri`, `id_trinh_do`, `id_bo_phan`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dt`, `email`, `dia_chi`) VALUES ('2', 'nguyen t', '2', '2', '2', '1986-10-19', '2006895', '8000000', '0789456123', 'tr@gmail.com', 'hue');
INSERT INTO `furama`.`nhan_vien` (`id_nhan_vien`, `ho_ten`, `id_vi_tri`, `id_trinh_do`, `id_bo_phan`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dt`, `email`, `dia_chi`) VALUES ('3', 'nguyen h', '3', '3', '3', '1986-10-19', '200145', '10000000', '0321456987', 'ew@gmai.com', 'quang binh');
-- loai khach
INSERT INTO `furama`.`loai_khach` (`id_loai_khach`, `ten_loai_khach`) VALUES ('1', 'khach thuong');
INSERT INTO `furama`.`loai_khach` (`id_loai_khach`, `ten_loai_khach`) VALUES ('2', 'khach quen');
INSERT INTO `furama`.`loai_khach` (`id_loai_khach`, `ten_loai_khach`) VALUES ('3', 'khach vip');
-- khach hang
INSERT INTO `furama`.`khach_hang` (`id_khach_hang`, `id_loai_khach`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `so_dt`, `email`, `dia_chi`) VALUES ('1', '1', 'nguyen van b', '1996-12-14', '2256658', '0123865479', 'qewq@gmail.com', 'da nang');
INSERT INTO `furama`.`khach_hang` (`id_khach_hang`, `id_loai_khach`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `so_dt`, `email`, `dia_chi`) VALUES ('2', '2', 'nguyen van c', '1997-11-20', '5556666', '0321896547', 'qwewc@gmail.com', 'quang binh');
INSERT INTO `furama`.`khach_hang` (`id_khach_hang`, `id_loai_khach`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `so_dt`, `email`, `dia_chi`) VALUES ('3', '3', 'nguyen van d', '1992-12-06', '6665828', '0123896547', 'qweqewr@gmail.com', 'quang tri');
-- kieu thue
INSERT INTO `furama`.`kieu_thue` (`id_kieu_thue`, `ten_kieu_thue`, `gia`) VALUES ('1', 'theo ngay', '200000');
INSERT INTO `furama`.`kieu_thue` (`id_kieu_thue`, `ten_kieu_thue`, `gia`) VALUES ('2', 'theo tuan', '1000000');
INSERT INTO `furama`.`kieu_thue` (`id_kieu_thue`, `ten_kieu_thue`, `gia`) VALUES ('3', 'theo thang', '3000000');
-- loai dich vu
INSERT INTO `furama`.`loai_dich_vu` (`id_loai_dich_vu`, `ten_loai_dich_vu`) VALUES ('1', 'kara');
INSERT INTO `furama`.`loai_dich_vu` (`id_loai_dich_vu`, `ten_loai_dich_vu`) VALUES ('2', 'xong hoi');
INSERT INTO `furama`.`loai_dich_vu` (`id_loai_dich_vu`, `ten_loai_dich_vu`) VALUES ('3', 'massage');
-- dich vu
INSERT INTO `furama`.`dich_vu` (`id_dich_vu`, `ten_dich_vu`, `dien_tich`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `id_kieu_thue`, `id_loai_dich_vu`, `trang_thai`) VALUES ('1', 'xong hoi', '45', '2', '2', '450000', '1', '1', 'ok');
INSERT INTO `furama`.`dich_vu` (`id_dich_vu`, `ten_dich_vu`, `dien_tich`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `id_kieu_thue`, `id_loai_dich_vu`, `trang_thai`) VALUES ('2', 'kara', '50', '6', '10', '200000', '2', '2', 'ok');
INSERT INTO `furama`.`dich_vu` (`id_dich_vu`, `ten_dich_vu`, `dien_tich`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `id_kieu_thue`, `id_loai_dich_vu`, `trang_thai`) VALUES ('3', 'massage', '120', '3', '2', '800000', '3', '3', 'ok');
-- hop dong
INSERT INTO `furama`.`hop_dong` (`id_hop_dong`, `id_nhan_vien`, `id_khach_hang`, `id_dich_vu`, `ngay_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) VALUES ('1', '1', '1', '1', '2016-12-03', '2017-01-02', '78000', '111111100');
INSERT INTO `furama`.`hop_dong` (`id_hop_dong`, `id_nhan_vien`, `id_khach_hang`, `id_dich_vu`, `ngay_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) VALUES ('2', '2', '2', '2', '2016-05-07', '2016-09-12', '78000', '123456789');
INSERT INTO `furama`.`hop_dong` (`id_hop_dong`, `id_nhan_vien`, `id_khach_hang`, `id_dich_vu`, `ngay_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) VALUES ('3', '3', '3', '3', '2016-05-08', '2016-07-23', '780000', '123456789');
-- dich vu di kem
INSERT INTO `furama`.`dich_vu_di_kem` (`id_dich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) VALUES ('1', 'tang them 1 em', '45000', '1', 'ok');
INSERT INTO `furama`.`dich_vu_di_kem` (`id_dich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) VALUES ('2', 'tang chai dau', '788500', '2', 'ok');
INSERT INTO `furama`.`dich_vu_di_kem` (`id_dich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) VALUES ('3', 'tang them mot ve', '7894512', '3', 'ok');
-- hop dong chi tiet
INSERT INTO `furama`.`hop_dong_chi_tiet` (`id_hop_dong_chi_tiet`, `id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('1', '1', '1', '1');
INSERT INTO `furama`.`hop_dong_chi_tiet` (`id_hop_dong_chi_tiet`, `id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('2', '2', '2', '2');
INSERT INTO `furama`.`hop_dong_chi_tiet` (`id_hop_dong_chi_tiet`, `id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('3', '3', '3', '3');


