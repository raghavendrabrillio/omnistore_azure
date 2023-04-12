drop table omnistore.purchaseorder;

create table omnistore.purchaseorder (
	id varchar(20), 
	creation_date datetime, 
    notes varchar(500),
    created_by varchar(500), 
    order_type varchar(500), 
    user_id varchar(50),
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_order FOREIGN KEY (user_id) REFERENCES omnistore.user(id)
	);