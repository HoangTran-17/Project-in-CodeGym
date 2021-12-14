USE Module3;

create table Product (
 id  int NOT NULL,
 userId int not null,
 Brand varchar(20) NOT NULL,
 Type varchar(20) NOT NULL,
 Line varchar(20) NOT NULL,
 Color varchar(10) NOT NULL,
 Year varchar(50) NOT NULL,
 KmTraved varchar(30) NOT NULL,
 Price double not null,
 Description varchar(200),
 PRIMARY KEY (id,userId),
 foreign key (userId) references Users(id)
);
