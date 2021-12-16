use examination_module3;
create table product(
productId int not null auto_increment,
productName varchar(255) not null,
price Double not null,
quantity int not null,
color varchar(50) not null,
description varchar(250),
category varchar(50) not null,
primary key (productId)
);


use examination_module3;
alter table product;
insert into product
values(1,"iPhone 11",799.0,12, "Purple,Yellow,Green","Apple 2019","Phone");
insert into product
values(2,"iPhone 11 Pro",1100.0,12, "Green,Black,White","Apple 2019","Phone");
insert into product
values(3,"iPhone X",749.0,13, "Coral,Black,Blue","Apple 2018","Phone");

use examination_module3;
insert into product
values(4,"Smart TV màn hình cong 4K UHD 49 inch RU7300",10000000,5, "Black","Smart TV màn hình cong 4K UHD 49 inch RU7300","Television");
insert into product
values(5,"SAMSUNG GALAXY S10 E",420.0,10, "Coral,Black,Blue","SAMSUNG 2019","Phone");
