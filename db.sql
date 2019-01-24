
create table users (
    id int,
    username varchar(50) not null, 
    password varchar (50) not null,
    email varchar (50) not null,
    dob date not null,
    primary key (id)
);
