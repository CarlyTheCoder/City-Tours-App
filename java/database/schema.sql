BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS landmarks;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE landmarks (
	id SERIAL,
	name varchar(100) NOT NULL,
	category varchar(50),
	address varchar (100),
	latitude float,
	longitude float,
    sunday_open time NOT NULL,
    sunday_close time NOT NULL,
	monday_open time NOT NULL,
    monday_close time NOT NULL,
    tuesday_open time NOT NULL,
    tuesday_close time NOT NULL,
    wednesday_open time NOT NULL,
    wednesday_close time NOT NULL,
    thursday_open time NOT NULL,
    thursday_close time NOT NULL,
    friday_open time NOT NULL,
    friday_close time NOT NULL,
    saturday_open time NOT NULL,
    saturday_close time NOT NULL,
	image varchar(200),
	CONSTRAINT PK_landmark PRIMARY KEY (id)
);




INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
