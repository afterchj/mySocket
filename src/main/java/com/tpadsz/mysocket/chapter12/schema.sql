drop database if exists STOREDB;
create database STOREDB;
use STOREDB;
create table CUSTOMERS (
  ID bigint not null auto_increment primary key,
  NAME varchar(16) not null,
  AGE INT,
  ADDRESS varchar(255)
);

create table ORDERS (
  ID bigint not null auto_increment primary key,
  ORDER_NUMBER varchar(16) not null,
  PRICE FLOAT,
  CUSTOMER_ID bigint,
  foreign key(CUSTOMER_ID) references CUSTOMERS(ID)
);

create table ACCOUNTS (
   ID bigint not null,
   NAME varchar(15),
   BALANCE decimal(10,2),
   primary key (ID) 
)  type=INNODB;

insert into CUSTOMERS(ID,NAME,AGE,ADDRESS) values(1, 'xiaozhang',23, 'BJ');
insert into CUSTOMERS(ID,NAME,AGE,ADDRESS) values(2,'xiaohong',29, 'TJ');
insert into CUSTOMERS(ID,NAME,AGE,ADDRESS) values(3,'xiaodong',33, 'SD');

insert into ORDERS(ID,ORDER_NUMBER,PRICE,CUSTOMER_ID) values(1, 'XZ_001',100.12, 1);
insert into ORDERS(ID,ORDER_NUMBER,PRICE,CUSTOMER_ID) values(2, 'XZ_002',200.32, 1);
insert into ORDERS(ID,ORDER_NUMBER,PRICE,CUSTOMER_ID) values(3, 'XH_001',88.44, 2);

select * from CUSTOMERS;
select * from ORDERS;