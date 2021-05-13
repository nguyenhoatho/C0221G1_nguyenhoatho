create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
cid varchar(255) not null primary key,
cname varchar(255)not null,
cage int
);
create table `order`(
oid varchar(255) not null primary key ,
cid varchar(255),
odate date,
ototal_price int ,
foreign key (cid) references customer(cid)
);
create table product(
pid varchar(255) not null primary key,
pname varchar(255),
pprice int
);
create table order_deitail(
oid varchar(255),
pid varchar(255),
primary key(oid,pid),
foreign key (oid) references `order`(oid),
foreign key (pid) references product(pid)
);



