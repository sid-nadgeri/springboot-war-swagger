create table user (
id long auto_increment primary key,
username varchar2(50),
first_name varchar2(50),
last_name varchar2(50),
email varchar2(50),
password varchar2(50),
phone varchar2(50),
user_status long
);

insert into user(username, first_name, last_name, email, password, phone, user_status)
values('sid', 'Sid', 'Nadgeri', 'sid_nadgeri@yahoo.co.in', 'sid', '+4915143441466', 1);

insert into user(username, first_name, last_name, email, password, phone, user_status)
values('donald', 'Donald', 'Duck', 'donald.duck@disney.com', 'donald', '+1234567890', 1);

insert into user(username, first_name, last_name, email, password, phone, user_status)
values('dousy', 'Dousy', 'Duck', 'donald.duck@disney.com', 'dousy', '+1234567890', 1);