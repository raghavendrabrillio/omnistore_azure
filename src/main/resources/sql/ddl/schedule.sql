drop table omnistore.schedule;

create table omnistore.schedule (
	id varchar(100),
	user_id varchar(20),
	parking_lot_id varchar(100),
	orderitem_id varchar(20),
    scheduled_time datetime,
    status varchar(50),
    schedule_type varchar(50),
    exchange_orderitem_id varchar(20),
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id),
    CONSTRAINT fk_orderitem_schedule FOREIGN KEY (orderitem_id) REFERENCES omnistore.orderitem(id),
    CONSTRAINT fk_user_schedule FOREIGN KEY (user_id) REFERENCES omnistore.user(id),
    CONSTRAINT fk_parking_lot_schedule FOREIGN KEY (parking_lot_id) REFERENCES omnistore.parkinglot(id)
	);