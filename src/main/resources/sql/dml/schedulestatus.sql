select * from omnistore.schedulestatus;
delete from omnistore.schedulestatus;
commit;
insert into omnistore.schedulestatus values ("1", "1", "Task Assigned", "raghu", now());
insert into omnistore.schedulestatus values ("2", "1", "Customer is Arriving", "raghu", now());
insert into omnistore.schedulestatus values ("3", "1", "Customer has arrived and has parked  vehicle in parking slot #A-1", "raghu", now());
insert into omnistore.schedulestatus values ("4", "1", "Task complete", "raghu", now());
insert into omnistore.schedulestatus values ("5", "2", "Task Assigned", "raghu", now());
insert into omnistore.schedulestatus values ("6", "2", "Customer is Arriving", "raghu", now());
insert into omnistore.schedulestatus values ("7", "2", "Customer has arrived and has parked vehicle in parking slot #A-2", "raghu", now());
insert into omnistore.schedulestatus values ("8", "2", "Task complete", "raghu", now());
insert into omnistore.schedulestatus values ("9", "3", "Task Assigned", "raghu", now());
insert into omnistore.schedulestatus values ("10", "3", "Customer is Arriving", "raghu", now());
insert into omnistore.schedulestatus values ("11", "3", "Customer has arrived and has parked vehicle in parking slot #A-3", "raghu", now());
insert into omnistore.schedulestatus values ("12", "3", "Task complete", "raghu", now());
insert into omnistore.schedulestatus values ("13", "4", "Task Assigned", "raghu", now());
insert into omnistore.schedulestatus values ("14", "4", "Customer is Arriving", "raghu", now());
insert into omnistore.schedulestatus values ("15", "4", "Customer has arrived and has parked vehicle in parking slot #A-4", "raghu", now());
insert into omnistore.schedulestatus values ("16", "4", "Task complete", "raghu", now());
insert into omnistore.schedulestatus values ("17", "5", "Task Assigned", "raghu", now());
insert into omnistore.schedulestatus values ("18", "5", "Customer is Arriving", "raghu", now());
insert into omnistore.schedulestatus values ("19", "5", "Customer has arrived and has parked vehicle in parking slot #A-5", "raghu", now());
insert into omnistore.schedulestatus values ("20", "6", "Task Assigned", "raghu", now());
insert into omnistore.schedulestatus values ("21", "6", "Customer is Arriving", "raghu", now());
insert into omnistore.schedulestatus values ("22", "7", "Task Assigned", "raghu", now());
insert into omnistore.schedulestatus values ("23", "8", "Task Assigned", "raghu", now());
insert into omnistore.schedulestatus values ("24", "9", "Task Assigned", "raghu", now());
commit;
select * from omnistore.schedulestatus;