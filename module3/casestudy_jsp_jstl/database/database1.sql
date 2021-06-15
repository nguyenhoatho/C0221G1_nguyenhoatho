create database if not exists case_study_furama_database
CHARACTER SET utf8 COLLATE utf8_general_ci;
use case_study_furama_database;

create table `position`(
position_id int not null primary key auto_increment,
position_name varchar(45)
);

create table education_degree(
education_degree_id int not null primary key auto_increment,
education_degree_name varchar(45)
);

create table division(
division_id int not null primary key auto_increment,
division_name varchar(45)
);

create table `role`(
role_id int not null primary key auto_increment,
role_name varchar(255)
);

create table `user`(
username varchar(255) not null primary key,
`password` varchar(255) not null
);

create table user_role(
role_id int not null,
username varchar(255) not null,
foreign key (role_id) references `role`(role_id) ON DELETE CASCADE,
foreign key (username) references `user`(username) ON DELETE CASCADE,
primary key (role_id,username)
);

create table employee(
employee_id int not null primary key auto_increment,
employee_name varchar(45) not null,
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(255),
employee_address varchar(255),
position_id int not null,
education_degree_id int not null,
division_id int not null,
username varchar(255),
foreign key (position_id) references `position`(position_id) ON DELETE CASCADE,
foreign key (education_degree_id) references education_degree(education_degree_id) ON DELETE CASCADE,
foreign key (division_id) references division(division_id) ON DELETE CASCADE,
foreign key (username) references `user`(username) ON DELETE CASCADE
);

create table customer_type(
customer_type_id int not null primary key auto_increment,
customer_type_name varchar(45) not null
);

create table customer(
customer_id varchar(45) not null primary key,
customer_type_id int not null ,
foreign key (customer_type_id) references customer_type(customer_type_id) ON DELETE CASCADE,
customer_name varchar(45) not null,
customer_birthday date,
customer_gender varchar(45),
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(255),
customer_address varchar(255)
);

create table rent_type(
rent_type_id int not null primary key auto_increment,
rent_type_name varchar(45) not null,
rent_type_cost double
);

create table service_type(
service_type_id int not null primary key auto_increment,
service_type_name varchar(45) not null
);

create table service(
service_id varchar(45) not null primary key,
service_name varchar(45) not null,
service_area int,
service_cost double,
service_max_people int,
rent_type_id int not null,
foreign key (rent_type_id) references rent_type(rent_type_id) ON DELETE CASCADE,
service_type_id int not null,
foreign key (service_type_id) references service_type(service_type_id) ON DELETE CASCADE,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int
);

create table contract(
contract_id int not null primary key auto_increment,
contract_start_date date,
contract_end_date date,
contract_deposit double default 0,
contract_total_money double default 0,
employee_id int not null,
foreign key (employee_id) references employee(employee_id) ON DELETE CASCADE, 
customer_id nvarchar(45) not null,
foreign key (customer_id) references customer(customer_id) ON DELETE CASCADE,
service_id nvarchar(45) not null,
foreign key (service_id) references service(service_id) ON DELETE CASCADE
);


create table attach_service(
attach_service_id int not null primary key auto_increment,
attach_service_name varchar(45) not null,
attach_service_cost double default 0,
attach_service_unit int default 0,
attach_service_status varchar(45)
);

create table contract_detail(
contract_detail_id int not null primary key auto_increment,
contract_id int not null,
foreign key (contract_id) references contract(contract_id) ON DELETE CASCADE,
attach_service_id int,
foreign key (attach_service_id) references attach_service(attach_service_id) ON DELETE CASCADE,
quantity int default 0
);


-- THÊM DỮ LIỆU
insert into `position`(position_name) 
values("Receptionist"),
("Service"),
("Specialist"),
("Supervisor"),
("Director")
;

insert into education_degree(education_degree_name)
values("Intermediate"),
("College"),
("University"),
("Graduate")
;

insert into division(division_name) 
values("Sales-Marketing Department"),
("Administrative Department"),
("Service Department"),
("Management Department")
;

insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id)
values("nguuyen van teo","1995-01-01","0606060606","100000000","0966666666","ducdoan@gmail.com","Hue",5,4,4),
("le van sai","1994-02-02","0808080808","50000000","0922222222","toandang@gmail.com","Da Nang",4,3,3),
("nguyen van teo","1997-07-07","0707070707","2000000","0977777777","ducminh@gmail.com","Quang Nam",3,2,2),
("tran van be","1998-08-08","0808080808","1000000","0988888888","nhattruong@gmail.com","Da Nang",2,1,1),
("nguyen thi sau","1999-09-09","0909090909","9000000","0999999999","thonguyen@gmail.com","Quang Ngai",1,1,1)
;
insert into customer_type(customer_type_name)
values("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("Member")
;

insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)
values(1,"Nguyen Van hua","1990-02-05","0","111111111","0101010101","havan@gmail.com","Binh Duong"),
(2,"Nguyen Thi seo","1993-05-01","1","222222222","0202020202","thapnguyen@gmail.com","Cu Chi"),
(3,"hua minh dat","1985-10-10","1","333333333","0303030303","tranbanh@gmail.com","Can Gio"),
(4,"Truong Thi teo","1988-03-04","1","444444444","0404040404","maytruong@gmail.com","Ha Noi"),
(5,"lua van heo","1998-08-08","0","555555555","0505050505","nguyendoan@gmail.com","Can Tho")
;

insert into rent_type(rent_type_name,rent_type_cost)
values("Year","500000000"),
("Month","50000000"),
("Day","1700000"),
("Hour","100000")
;

insert into service_type(service_type_name)
values("Villa"),
("House"),
("Room")
;

insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)
values ("Villa 01",500,50000000,20,1,1,"VIP","Incluede All",100,5),
("Villa 02",400,40000000,15,2,1,"Normal","Incluede All",100,4),
("House 01",200,20000000,10,3,2,"Normal","Free Food",0,3),
("House 02",150,15000000,5,4,2,"VIP","Free Massage",0,2),
("Room 01",80,8000000,3,3,3,"VIP","Free Massage",0,1),
("Room 02",60,6000000,2,4,3,"Normal","Free Water",0,1)
;

insert into attach_service(attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
values("Massage","200000","1","Available"),
("Karaoke","80000","1","Available"),
("Food","100000","1","Available"),
("Water","50000","1","Available"),
("Car Forent","500000","1","Available")
;
create view customer_using_service as
select cus.customer_id,cus.customer_name,
ctr.contract_id,ctr.contract_start_date,ctr.contract_end_date,
ser.service_name,att.attach_service_id,att.attach_service_name,cd.quantity
from contract ctr
left join customer cus on ctr.customer_id = cus.customer_id
left join contract_detail cd on ctr.contract_id = cd.contract_id
left join service ser on ctr.service_id = ser.service_id
left join attach_service att on cd.attach_service_id = att.attach_service_id
where (now() between ctr.contract_start_date and ctr.contract_end_date)
group by ctr.customer_id;

select *from customer_using_service;

create view attach_service_using as
select ct.contract_id,att.attach_service_id,att.attach_service_name,sum(cd.quantity)
from attach_service att 
join contract_detail cd on att.attach_service_id = cd.attach_service_id
join contract ct on cd.contract_id = ct.contract_id
group by att.attach_service_id , ct.contract_id;
