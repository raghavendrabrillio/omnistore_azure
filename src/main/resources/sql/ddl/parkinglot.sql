drop table omnistore.parkinglot;

create table omnistore.parkinglot (
	id varchar(100),
	parking_lot_num varchar(20),
	status varchar(50), 
    created_date datetime, 
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id)
	);