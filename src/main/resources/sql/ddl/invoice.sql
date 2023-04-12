drop table omnistore.invoice;

create table omnistore.invoice (
	id varchar(20), 
	total_amount double, 
    payment_method varchar(50),
    created_date datetime, 
    order_id varchar(50),
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_invoice FOREIGN KEY (order_id) REFERENCES omnistore.purchaseorder(id)
	);