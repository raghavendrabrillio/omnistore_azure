select * from omnistore.purchaseorder;
delete from omnistore.purchaseorder;
commit;
insert into omnistore.purchaseorder values ("1", "2015-04-03 14:00:45", "test note", "Raghu","Type1", "1", "raghu", now());
insert into omnistore.purchaseorder values ("2", "2015-04-03 14:00:45", "test note", "Raghu","Type1", "2", "raghu", now());
insert into omnistore.purchaseorder values ("3", "2017-06-05 16:00:45", "test note", "Raghu","Type3", "3", "raghu", now());
insert into omnistore.purchaseorder values ("4", "2018-07-06 17:00:45", "test note", "Raghu","Type4", "4", "raghu", now());
insert into omnistore.purchaseorder values ("5", "2019-08-07 18:00:45", "test note", "Raghu","Type5", "5", "raghu", now());
insert into omnistore.purchaseorder values ("6", "2020-09-08 19:00:45", "test note", "Raghu","Type5", "6", "raghu", now());
insert into omnistore.purchaseorder values ("7", "2021-10-09 20:00:45", "test note", "Raghu","Type5", "7", "raghu", now());
insert into omnistore.purchaseorder values ("8", "2022-11-10 21:00:45", "test note", "Raghu","Type5", "8", "raghu", now());
insert into omnistore.purchaseorder values ("9", "2022-12-11 21:00:45", "test note", "Raghu","Type5", "9", "raghu", now());
commit;
select * from omnistore.purchaseorder;