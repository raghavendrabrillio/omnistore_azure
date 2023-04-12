drop table omnistore.invoiceitem;

create table omnistore.invoiceitem (
	id varchar(20), 
	inv_number varchar(50), 
    amount double,
    invoice_id varchar(20), 
    orderitem_id varchar(50),
    created_date datetime,
    created_by varchar(50),
    updated_by varchar(50), 
    updated_date datetime,
    PRIMARY KEY (id),
    CONSTRAINT fk_orderitem_invoiceitem FOREIGN KEY (orderitem_id) REFERENCES omnistore.orderitem(id),
    CONSTRAINT fk_invoice_invoiceitem FOREIGN KEY (invoice_id) REFERENCES omnistore.invoice(id)
	);