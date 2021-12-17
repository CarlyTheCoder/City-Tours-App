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
	image_wide varchar(200) NOT NULL,
	image_wide_2 varchar(200) NOT NULL,
	description varchar(1000),
	CONSTRAINT PK_landmark PRIMARY KEY (id)
);

CREATE TABLE itineraries (
    id SERIAL,
    user_id int NOT NULL,
    name VARCHAR(100) NOT NULL,
    starting_point int,
    trip_date date,
    CONSTRAINT PK_itinerary PRIMARY KEY (id),
    CONSTRAINT FK_itinerary FOREIGN KEY (user_id) REFERENCES users (user_id)


);

CREATE TABLE itineraries_landmarks (

    landmark_id int REFERENCES landmarks (id),
    itinerary_id int REFERENCES itineraries (id),
    order_position int NOT NULL,
    PRIMARY KEY (landmark_id, itinerary_id)
);

CREATE TABLE landmark_likes (
    landmark_id int REFERENCES landmarks (id),
    user_id int REFERENCES users (user_id),
    PRIMARY KEY (landmark_id, user_id)
);

CREATE TABLE landmark_dislikes (
    landmark_id int REFERENCES landmarks (id),
    user_id int REFERENCES users (user_id),
    PRIMARY KEY (landmark_id, user_id)
);




INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('test123','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('test1234','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('test12345','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');


COMMIT TRANSACTION;
