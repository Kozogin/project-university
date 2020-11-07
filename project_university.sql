#project_university

drop database if exists project_university;
create database project_university char set utf8;
use project_university;
select database();

select * from user;
select * from applicant;
select * from faculty;
select * from name_of_lesson;
select * from faculty_lesson;
select * from point;

#insert into user(user_id , assigned_id, password, password_confirm, email, first_name, last_name, role) values	
#    (20,'admin20','$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by',
#				'$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by',
#    'admin@mail.com',
#    "Edik", "Kotovuch", "ROLE_ADMIN"
#);




