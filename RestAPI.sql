CREATE DATABASE restapi;
USE restapi;
CREATE TABLE contact (
  email VARCHAR(500) NOT NULL PRIMARY KEY,
  name VARCHAR(500) NOT NULL,
  phonenumber VARCHAR(20) NOT NULL
);

CREATE INDEX idx ON contact (email, name);

CREATE TABLE userdata (
  email VARCHAR(500) NOT NULL ,
  usernamepassword VARCHAR(500) NOT NULL PRIMARY KEY,
  password VARCHAR(500) NOT NULL
);