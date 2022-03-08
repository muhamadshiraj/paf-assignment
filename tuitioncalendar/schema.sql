drop database if exists calendar;
create database calendar;
use calendar;

create table lessons (
	lesson_id int not null auto_increment,
	name varchar(64) not null,
    level varchar(64) not null,
	subject varchar(64) not null,
    lesson_date timestamp not null,
    duration time not null,
	last_update timestamp default current_timestamp on update current_timestamp,
	primary key(lesson_id)
);

