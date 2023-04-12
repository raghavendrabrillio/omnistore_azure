drop table omnistore.user;

create table omnistore.user (
	id varchar(20), 
	first_name varchar(100), 
    last_name varchar(100), 
    login_id varchar(20),
    address_id varchar(20),
    type varchar(20),
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id),
    CONSTRAINT fk_login FOREIGN KEY (login_id) REFERENCES omnistore.login(id),
    CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES omnistore.address(id)
	);