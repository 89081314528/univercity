CREATE TABLE cars (id bigserial primary key, make varchar(255), model varchar(255), price integer);
CREATE TABLE human (id bigserial primary key,
 					name varchar(255),
 					age integer,
 					haslicense boolean,
 					car_id bigint REFERENCES cars (id));
