drop table omnistore.product;

create table omnistore.product (
	id varchar(20), 
	name varchar(100), 
    quantity double, 
    price double,
    category varchar(50),
    manufacturer varchar(50),
    manufacturing_date datetime,
    description varchar(100),
    picture blob,
    updated_by varchar(50), 
    updated_date datetime,
    sku varchar(100),
    size varchar(20),
    PRIMARY KEY (id)
	);