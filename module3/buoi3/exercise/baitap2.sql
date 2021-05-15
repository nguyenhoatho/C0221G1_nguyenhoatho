use quan_ly_ban_hang;

insert into customer
values(1,"Minh Quan",10),(2,"Ngoc Oanh",20),(3,"Hong Ha",50);

insert into `order`
values(1,"2006-3-21",null,1),(2,"2006-3-20",null,2),(3,"2006-3-16",null,1);

insert into product
values(1,"May Giat",3),
	(2,"Tu Lanh",5),
	(3,"Dieu Hoa",7),
	(4,"Quat",1),
    (5,"Bep Dien",2);
    
 alter table order_detail
 drop primary key;
 
 insert into order_detail
 values (1,1,3),
		 (1,3,7),
		 (1,4,2),
		 (2,1,1),
		 (3,1,8),
		 (2,5,4),
		 (2,3,3);
         
         
 select o.oid,	o.odate	,o.ototal_price
 from `order` as o ;
 
 select customer.cname , product.pname
 from order_detail join `order` on order_detail.oid= `order`.oid 
 join product on order_detail.pid = product.pid
 join customer on `order`.cid = customer.cid;
 
 
 
 
select customer.cname
from customers as c
where c.cid not in (select o.cid from `order` as o);
 
select `order`.oid,`order`.odate,sum(order_detail.odQTY*product.pprice) as tong_tien
from order_detail join `order` on order_detail.oid = `order`.oid 
join product on order_detail.pid = product.pid
join customer on `order`.cid = customer.cid
group by order_detail.oid
order by tong_tien;