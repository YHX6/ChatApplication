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

create table files (
	FileID int not null auto_increment,
    FileExtension varchar(255),
    BlurHash varchar(255),
    Status char(1) not null default '0',
    primary key (FileID)
);

create table messages(
	FromUserID int not null,
    ToUserID int not null,
    MessageType int,
    Content varchar(1000),
    Time varchar(150)
);