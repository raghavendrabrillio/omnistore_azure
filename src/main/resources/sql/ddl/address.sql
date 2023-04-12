drop table omnistore.address;

create table omnistore.address (
	id varchar(20), 
	zip varchar(50), 
    city varchar(100), 
    street varchar(100),
    tel varchar(50),
    country varchar(100),
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id)
	);