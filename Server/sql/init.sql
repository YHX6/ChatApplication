DROP DATABASE IF exists `healthc`;

create database `healthc`;
use `healthc`;


create table user(
	UserID INT NOT NULL auto_increment,
    UserName varchar(255),
    Password varchar(255),
    primary key(UserID)
);

create table user_account (
	UserID int,
    UserName varchar(255),
    Gender char(1) not null default "",
    Image longblob,
    ImageString varchar(255) not null default "",
    Status char(1) not null default "1",
    primary key (UserID)

);