drop table omnistore.task;

create table omnistore.task (
	id varchar(100),
	schedule_id varchar(100),
	assigned_to varchar(20),
    status varchar(50),
    created_time datetime,
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id),
    CONSTRAINT fk_schedule_task FOREIGN KEY (schedule_id) REFERENCES omnistore.schedule(id),
    CONSTRAINT fk_user_task FOREIGN KEY (assigned_to) REFERENCES omnistore.user(id)
	);