    drop table if exists employee_details
    create table employee_details (
        id integer not null auto_increment,
        branch varchar(255),
        country varchar(255),
        deptName varchar(255),
        designation varchar(255),
        dop varchar(255),
        email varchar(255),
        empNo varchar(255),
        firstName varchar(255),
        gender varchar(255),
        lastName varchar(255),
        password varchar(255),
        phone varchar(255),
        salary double precision,
        primary key (id)
    )