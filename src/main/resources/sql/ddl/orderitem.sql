drop table omnistore.orderitem;

create table omnistore.orderitem (
	id varchar(20), 
	status varchar(50), 
    product_id varchar(20),
    created_date datetime, 
    amount double,
    original_line_item_id varchar(20),
    quantity double,
    order_id varchar(50),
    qr_code varchar(100),
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_orderitem_product FOREIGN KEY (product_id) REFERENCES omnistore.product(id),
    CONSTRAINT fk_user_orderitem_order FOREIGN KEY (order_id) REFERENCES omnistore.purchaseorder(id)
	);