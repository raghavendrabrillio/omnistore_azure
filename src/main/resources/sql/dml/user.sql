select * from omnistore.user;
delete from omnistore.user;
commit;
insert into omnistore.user values ("1", "Admin", "istrator", "1","1", "Admin", "raghu", now());
insert into omnistore.user values ("2", "Raghavendra", "Muniramaiah", "2","2", "Associate", "raghu", now());
insert into omnistore.user values ("3", "Keerthi", "LNU", "3","3", "Customer", "raghu", now());
insert into omnistore.user values ("4", "Shailesh", "Choudhari", "4","4", "Admin", "raghu", now());
insert into omnistore.user values ("5", "Anoop", "Kumar", "5","5", "Associate", "raghu", now());
insert into omnistore.user values ("6", "Hari", "Kishan", "6","6", "Admin", "raghu", now());
insert into omnistore.user values ("7", "Nikhita", "D", "7","7", "Customer", "raghu", now());
insert into omnistore.user values ("8", "Sravya", "Polamraju", "8","8", "Associate", "raghu", now());
insert into omnistore.user values ("9", "Chandra", "Kanth", "9","9", "Customer", "raghu", now());
commit;
select * from omnistore.user;