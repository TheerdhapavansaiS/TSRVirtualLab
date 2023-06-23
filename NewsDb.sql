create database 75691db;
use 75691db;
create table Admin(
adminId varchar(10) primary key,
adminName varchar(30) not null,
adminMail varchar(50) unique not null,
adminPhone bigint unique not null,
adminPassword varchar(20) not null
);

create table User(
userId varchar(10) primary key,
userName varchar(30) not null,
userAddress varchar(100) not null,
userMail varchar(50) unique not null,
userPhone bigint unique not null,
userPassword varchar(20) not null
);

create table Category(
catName varchar(25) primary key
);

create table Article(
artId varchar(10) primary key,
artTitle varchar(200) not null,
artDesc varchar(1000) not null,
artDate date not null,
artCatName varchar(35) not null
);

alter table article add constraint fk_artcatname foreign key (artCatName) references category(catName);

select * from admin;