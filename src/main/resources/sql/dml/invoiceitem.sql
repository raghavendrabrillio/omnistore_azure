select * from omnistore.invoiceitem;
delete from omnistore.invoiceitem;
commit;
-- admin invoices
insert into omnistore.invoiceitem values ("1", "inv-123456",1000,"1","1","2017-11-05 12:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("2", "inv-23411", 1000,"1","2","2017-10-04 13:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("3", "inv-56333", 1000,"1","3","2017-09-03 14:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("4", "inv-66441", 1000,"1","4","2017-08-02 15:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("5", "inv-78999", 1000,"1","5","2017-07-01 16:00:45","raghu", "raghu", now());
-- raghu invoices
insert into omnistore.invoiceitem values ("6", "inv-32111",1000,"2","6","2018-11-05 12:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("7", "inv-11212",1000,"2","7","2018-10-04 13:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("8", "inv-12344",1000,"2","8","2018-09-03 14:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("9", "inv-53535",1000,"2","9","2018-08-02 15:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("10", "inv-677734",1000,"2","10","2018-07-01 16:00:45","raghu", "raghu", now());
-- Keerthi invoices
insert into omnistore.invoiceitem values ("11", "inv-52324",1000,"3","11","2018-11-05 12:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("12", "inv-77454",1000,"3","12","2018-10-04 13:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("13", "inv-21211",1000,"3","13","2018-09-03 14:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("14", "inv-09981",1000,"3","14","2018-08-02 15:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("15", "inv-98655",1000,"3","15","2018-07-01 16:00:45","raghu", "raghu", now());
-- Sahilesh invoices
insert into omnistore.invoiceitem values ("16", "inv-776633",1000,"4","16","2018-11-05 12:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("17", "inv-553331",1000,"4","17","2018-10-04 13:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("18", "inv-677777",1000,"4","18","2018-09-03 14:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("19", "inv-999999",1000,"4","19","2018-08-02 15:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("20", "inv-442255",1000,"4","20","2018-07-01 16:00:45","raghu", "raghu", now());
-- Anoop invoices
insert into omnistore.invoiceitem values ("21", "inv-12121",1000,"5","21","2018-07-01 16:00:45","raghu", "raghu", now());
-- Hari invoices
insert into omnistore.invoiceitem values ("22", "inv-666333",1000,"6","22","2018-11-05 12:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("23", "inv-242161",1000,"6","23","2018-10-04 13:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("24", "inv-555326",1000,"6","24","2018-09-03 14:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("25", "inv-632118",1000,"6","25","2018-08-02 15:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("26", "inv-6664222",1000,"6","26","2018-07-01 16:00:45","raghu", "raghu", now());
-- Nikita invoices
insert into omnistore.invoiceitem values ("27", "inv-523422",1000,"7","27","2018-07-01 16:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("28", "inv-789809",1000,"7","28","2018-07-01 16:00:45","raghu", "raghu", now());
-- Sravya invoices
insert into omnistore.invoiceitem values ("29", "inv-456789",1000,"8","29","2018-07-01 16:00:45","raghu", "raghu", now());
insert into omnistore.invoiceitem values ("30", "inv-234567",1000,"8","30","2018-07-01 16:00:45","raghu", "raghu", now());
commit;
select * from omnistore.invoiceitem;