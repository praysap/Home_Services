### Frontend

- Technology: React JS

### Database

```sql
-- create new database
create database home_services;
use home_services

-- tables
yarn start
--admin/user
create table admin(
    id integer primary key auto_increment,
    firstName varchar(20),
    lastName varchar(20),
    email varchar(20),
    phone varchar(10),
    password varchar(350),
    log timestamp DEFAULT CURRENT_TIMESTAMP
);

-- employee
create table employee(
     id integer primary key auto_increment,
    firstName varchar(20),
    lastName varchar(20),
     email varchar(20),
      phone varchar(10),
      branchid int,
      role default= employee,
       log timestamp DEFAULT CURRENT_TIMESTAMP
);

-- manager

```



