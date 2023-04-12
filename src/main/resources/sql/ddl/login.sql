drop table omnistore.login;

create table omnistore.login (
	id varchar(20), 
	user_name varchar(50), 
    password varchar(500), 
    last_login_time datetime, 
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id)
	);