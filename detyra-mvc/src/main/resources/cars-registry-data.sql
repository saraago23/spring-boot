create database car_registry;

use car_registry;

CREATE TABLE car_wheels (
                            id int NOT NULL AUTO_INCREMENT,
                            size varchar(255) NOT NULL,
                            wheel_type varchar(255) NOT NULL,
                            PRIMARY KEY (id)
) ;

CREATE TABLE car_engines (
                             id int NOT NULL AUTO_INCREMENT,
                             engine_power int NOT NULL,
                             engine_type varchar(255) NOT NULL,
                             PRIMARY KEY (id)
) ;


CREATE TABLE cars (
                      id int NOT NULL AUTO_INCREMENT,
                      car_name varchar(255) NOT NULL,
                      from_year int NOT NULL,
                      to_year int NOT NULL,
                      engine_id int NOT NULL,
                      wheels_id int NOT NULL,
                      PRIMARY KEY (id),
                      CONSTRAINT car_car_wheels_PK FOREIGN KEY (wheels_id) REFERENCES car_wheels(id),
                      CONSTRAINT car_car_engines_PK FOREIGN KEY (engine_id) REFERENCES car_engines(id)
) ;

INSERT INTO car_wheels(id,size,wheel_type)
VALUES (1,'R15','STEEL'),
       (2,'R16','STEEL'),
       (3,'R17','ALLOW');


INSERT INTO car_engines(id,engine_power,engine_type)
VALUES (4,1200,'DIESEL'),
       (5,1400,'GAS'),
       (6,1600,'GASOLINE');


INSERT INTO cars(id,car_name,from_year,to_year,wheels_id,engine_id)
VALUES (7,'Aspire',2000,2005,1,4),
       (8,'BMW S3',2008,2015,2,5),
       (9,'Mercedes C220',2000,2009,3,6);