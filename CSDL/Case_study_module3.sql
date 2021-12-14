USE Case_study_module3;

create table users (
 userId  varchar(20) NOT NULL,
 userName varchar(20) NOT NULL,
 status varchar(20) NOT NULL,
 role varchar(20) NOT NULL,
 phoneNumber varchar(20) NOT NULL,
 address varchar(50) NOT NULL,
 password varchar(20) NOT NULL,
 PRIMARY KEY (userId)
);

alter table users;
insert into users
values('868686868','SUPPER ADMIN','AVAILABLE','SUPER_ADMIN','0868686868','28 Nguyen Tri Phuong','Dt080796');
insert into users
values('979797979','ADMIN','AVAILABLE','ADMIN','0979797979','131 Tran Phu,Tp.Hue','979797979');
insert into users
values('987654321','ADMIN','AVAILABLE','USER','0979797979','131 Tran Phu,Tp.Hue','987654321');