DROP TABLE IF EXISTS userscars;
DROP TABLE IF EXISTS cars;
DROP SEQUENCE IF EXISTS global_se8;
DROP SEQUENCE IF EXISTS global_se9;
/*DROP SEQUENCE IF EXISTS global_se10;*/

CREATE SEQUENCE global_se8 START 10000;
CREATE SEQUENCE global_se9 START 10000;
/*
CREATE SEQUENCE global_se111 START 01;
*/

CREATE TABLE userscars(
  driverid INTEGER PRIMARY KEY DEFAULT nextval('global_se8'),
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  tel VARCHAR NOT NULL
);

CREATE TABLE cars(
  carid INTEGER PRIMARY KEY DEFAULT nextval('global_se9'),
  driverid INTEGER NOT NULL,
  car VARCHAR NOT NULL,
  modeleCar VARCHAR NOT NULL,
  timeArrival TIMESTAMP,
  timeDeparture TIMESTAMP,
  /*payment INTEGER NULL,*/
  numberParking INTEGER DEFAULT nextval('global_se111')
);