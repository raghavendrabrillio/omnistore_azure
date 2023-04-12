select * from omnistore.login;
delete from omnistore.login;
commit;
insert into omnistore.login values ("1", "admin", "$2a$10$TCVVXRS8BlKmWWVswHgc9uETie22JWvPVntsUXQN9I92fX4gZdZJK", now(), "raghu", now());
insert into omnistore.login values ("2", "raghav", "$2a$10$lNBX5wxVWzvaZ1CnMMUoqOp6cTnOJKV2dOVrGEkjZzhPq84d1P8nW", now(), "raghu", now());
insert into omnistore.login values ("3", "keerthi", "$2a$10$iAQh0U8cOCOihbylKNRiSOLkJdvhLTosNBgcvNC3YI00x5kHNIGgG", now(), "raghu", now());
insert into omnistore.login values ("4", "Shaliesh", "$2a$10$nPN8NW2.vJmFGw2/q5Pu8O4nTUpeb8xrae2PtwWSeNS2xwcrctLDy", now(), "raghu", now());
insert into omnistore.login values ("5", "Anoop", "$2a$10$T9mGySvDYggFZ00uCrFRIOOe5MVhVXmHnPUOmNF4d5NY0QQ1y8n6C", now(), "raghu", now());
insert into omnistore.login values ("6", "Hari", "$2a$10$7rDX4n98Or74LjthhUSpQ.czCs/7GtasMkuQCeDCo3J8ibLA.FhYi", now(), "raghu", now());
insert into omnistore.login values ("7", "Nikhita", "$2a$10$PB.mifaSTatH5oIyyEN0XesjwT4aAf8VHl52NOZe8oL.csjldEonC", now(), "raghu", now());
insert into omnistore.login values ("8", "Sravya", "$2a$10$vYpW9bDgsJxbFCBcd0PwsuiP39mYl0YTqOOzjzKWDtolr08CwqEza", now(), "raghu", now());
insert into omnistore.login values ("9", "Chandra", "$2a$10$LkPkkwSFztdFZWGeqjnKcuaPmv26OsMzf0RsGAc0TUF7FA8pY.e2W", now(), "raghu", now());
commit;
select * from omnistore.login;









--
--Admin@Omnistore --> $2a$10$TCVVXRS8BlKmWWVswHgc9uETie22JWvPVntsUXQN9I92fX4gZdZJK
--Raghav@Omnistore --> $2a$10$lNBX5wxVWzvaZ1CnMMUoqOp6cTnOJKV2dOVrGEkjZzhPq84d1P8nW
--Keerthi@Omnistore --> $2a$10$iAQh0U8cOCOihbylKNRiSOLkJdvhLTosNBgcvNC3YI00x5kHNIGgG 
--Shaliesh@Omnistore --> $2a$10$nPN8NW2.vJmFGw2/q5Pu8O4nTUpeb8xrae2PtwWSeNS2xwcrctLDy
--Anoop@Omnistore --> $2a$10$T9mGySvDYggFZ00uCrFRIOOe5MVhVXmHnPUOmNF4d5NY0QQ1y8n6C
--Hari@Omnistore --> $2a$10$7rDX4n98Or74LjthhUSpQ.czCs/7GtasMkuQCeDCo3J8ibLA.FhYi
--Nikhita@Omnistore --> $2a$10$PB.mifaSTatH5oIyyEN0XesjwT4aAf8VHl52NOZe8oL.csjldEonC
--Sravya@Omnistore --> $2a$10$vYpW9bDgsJxbFCBcd0PwsuiP39mYl0YTqOOzjzKWDtolr08CwqEza
--Chandra@Omnistore --> $2a$10$LkPkkwSFztdFZWGeqjnKcuaPmv26OsMzf0RsGAc0TUF7FA8pY.e2W