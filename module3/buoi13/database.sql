SELECT * FROM demo.users;
DELIMITER $$

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END$$

DELIMITER ;

  

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;
DELIMITER $$

CREATE PROCEDURE get_user(
)

BEGIN
	select *from users;

    END$$

DELIMITER ;
delimiter //
create procedure update_user(in p_id int,
                             in p_name varchar(120),
							 in p_email varchar(220),
                             in p_country varchar(120))
begin
update users
set `name`=p_name,
     email=p_email,
     country=p_country
where id=p_id;     
end
//delimiter ;

delimiter //
create procedure delete_user(in p_id int)
begin
delete 
from users
where id =p_id;
end
//delimiter ;