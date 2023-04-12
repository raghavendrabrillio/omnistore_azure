drop table omnistore.schedulestatus;

create table omnistore.schedulestatus (
	id varchar(100),
	schedule_id varchar(100),
    status varchar(500),
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id),
    CONSTRAINT fk_schedule_schedulestatus FOREIGN KEY (schedule_id) REFERENCES omnistore.schedule(id)
	);