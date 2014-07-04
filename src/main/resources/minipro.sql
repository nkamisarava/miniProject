CREATE DATABASE minipro;

CREATE TABLE USER (id INT (20),first_name VARCHAR(20), last_name VARCHAR(20),
                     password VARCHAR(20),role ENUM ('ANONYMOUS',
                                                     'USER',
                                                     'ADMIN'), phone_number VARCHAR(20), login VARCHAR(20),email VARCHAR (20)
  ,PRIMARY KEY (id)
);
