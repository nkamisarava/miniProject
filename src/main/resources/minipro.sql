DROP DATABASE minipro;
CREATE DATABASE minipro;
USE minipro;
CREATE TABLE USER (id INT (20), first_name VARCHAR(20), last_name VARCHAR(20),
                   password VARCHAR(200), role ENUM ('ANONYMOUS',
                                                     'USER',
                                                     'ADMIN'),
                   phone_number VARCHAR(20), login VARCHAR(20) UNIQUE, email VARCHAR (20) UNIQUE, PRIMARY KEY (id)
);
