CREATE DATABASE petwed;
use petwed;
CREATE TABLE usser (
id int auto_increment primary key,
family_name varchar(50),
surname varchar(50),
email varchar(50),
pasword varchar(20),
city varchar (100),
region varchar (100),
gender varchar (10),
birth_date date,
registration_date date,
bio varchar(1000)
);

CREATE TABLE pet (
id int auto_increment primary key,
nickname varchar(50),
city varchar (100),
region varchar (100),
gender varchar (10),
breed varchar(50),
birth_date date,
adding_date date,
bio varchar(1000),
user_id int,
foreign key(user_id) references usser(id) on delete cascade on update cascade
);

create table messages(
id  int auto_increment primary key,
from_user_id int,
to_user_id int,
message varchar(2000),
message_seen boolean default false,
when_sent timestamp,
foreign key(from_user_id) references usser(id) on update cascade on delete cascade,
foreign key(to_user_id) references usser(id) on update cascade on delete cascade
);

create table breeds(
id int  auto_increment primary key,
breed varchar(100),
parent_breed_id int,
foreign key (parent_breed_id) references breeds(id)
);

create table matching(
id int auto_increment primary key,
from_pet_id int,
to_pet_id int,
like_value bool,
seen bool default false
);

