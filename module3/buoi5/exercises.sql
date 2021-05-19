create database products;
use products;
create table product(
id int,
product_code varchar(255),
product_name varchar(255),
product_price float,
product_amount float,
product_description varchar(255),
product_status varchar(255)

);

insert into product_exercise
values (1,"a001","kem",2560,666000,"usa","con"),
(2,"a002","ga",20002,200000,"usa","con"),
(3,"a003","vit",20500,200005,"usa","con"),
(4,"a004","bo",20050,205000,"usa","con");

explain select * from product_exercise where product_Code = "a001";

alter table product_exercise
add index idx_product_code(product_code);

alter table product_exercise
add index idx_full(product_name,product_price);

explain select * from product_exercise where product_name = "ga" or product_Price =20002 ;

create view view_products as
select product_code,product_name,product_price,product_status
from product_exercise;

alter view view_products as
select * from product_exercise
where product_Price >= 20002;

SET SQL_SAFE_UPDATES = 0;

update view_products
set product_Price = 3000
where id = 2;

drop view view_products;

DELIMITER //
create procedure proc_products()
begin
	select * from product_exercise;
 end //
 DELIMITER ;
 
  call proc_products();
  
  
  DELIMITER //
 create procedure insert_procedure(
	IN id int , 
    proc_code varchar(45),
    proc_name varchar(45),
    proc_price float,
    proc_amount float,
    proc_des varchar (45),
    proc_status varchar (45)
 )
 begin
	insert into product_exercise
    values(id,proc_code,proc_name,proc_price,proc_amount,proc_des,proc_status) ;
end //
DELIMITER ;    

call insert_procedure(5,"a005","keo con cho",3000,30000,"china","con");

call proc_products();

DELIMITER //
create procedure update_procedure( 
IN id_proc int,
proc_code varchar(45),
proc_name varchar(45),
proc_price float)

begin 
	update product_exercise
    set product_Code = proc_code,
		product_Name = proc_name,
		product_Price = proc_price 
    where id = id_proc;
end //

DELIMITER ;

SET SQL_SAFE_UPDATES = 0;
call update_procedure(4,"a005","can sa","5000");

call proc_products();

DELIMITER //
 create procedure delete_procedure(IN id_proc int)
 begin 
	delete from product_exercise
    where id = id_proc ;
    end //
DELIMITER ;

call delete_procedure(5);

call proc_products();





