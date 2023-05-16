DROP DATABASE IF exists `healthc`;

create database `healthc`;
use `healthc`;


create table user(
	UserID INT NOT NULL auto_increment,
    UserName varchar(255),
    Password varchar(255),
    primary key(UserID)
);