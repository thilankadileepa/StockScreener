/*
CREATED		3/5/2014
MODIFIED		3/6/2014
PROJECT		
MODEL		
COMPANY		
AUTHOR		
VERSION		
DATABASE		MYSQL 5 
*/

drop database if exists stock;
create database stock;

use stock;


DROP TABLE IF EXISTS CATEGORY_FILTER;
DROP TABLE IF EXISTS FILTER;
DROP TABLE IF EXISTS CATEGORY_MODULE;
DROP TABLE IF EXISTS MODULE;
DROP TABLE IF EXISTS USER_CATEGORY;
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS ANNUAL_SHARE_DATA;
DROP TABLE IF EXISTS QUARTERLY_SHARE_DATA;
DROP TABLE IF EXISTS DAILY_SECTOR_DATA;
DROP TABLE IF EXISTS DAILY_SHARE_DATA;
DROP TABLE IF EXISTS INTRADAY_SECTOR_DATA;
DROP TABLE IF EXISTS INTRADAY_SHARE_DATA;
DROP TABLE IF EXISTS SECTOR;
DROP TABLE IF EXISTS COMPANY;


CREATE TABLE COMPANY (
	ID INT NOT NULL,
	SECTOR_ID INT NOT NULL,
	CODE VARCHAR(20),
	NAME VARCHAR(200),
 PRIMARY KEY (ID)) ENGINE = InnoDB;

CREATE TABLE SECTOR (
	ID INT NOT NULL,
	CODE VARCHAR(20),
	NAME VARCHAR(150),
 PRIMARY KEY (ID)) ENGINE = InnoDB
COMMENT = 'ALREADY DEFINED SECTORS.
EX. ASI, S&P20';

CREATE TABLE INTRADAY_SHARE_DATA (
	ID INT NOT NULL,
	COMPANY_ID INT NOT NULL,
	TIME DATETIME,
	TRADE_VOLUME DOUBLE,
	SHARE_VOLUME DOUBLE,
	TURNOVER DOUBLE,
	LAST_TRADED_PRICE DOUBLE,
	CLOSING_PRICE DOUBLE,
	VALUE_CHANGE DOUBLE,
	PERCENTAGE_CHANGE DOUBLE,
 PRIMARY KEY (ID)) ENGINE = InnoDB;

CREATE TABLE INTRADAY_SECTOR_DATA (
	ID INT NOT NULL,
	SECTOR_ID INT NOT NULL,
	TIME DATETIME,
	VALUE DOUBLE,
	VALUE_CHANGE DOUBLE,
	PERCENTAGE_CHANGE DOUBLE,
	SEQUENCE INT COMMENT 'THIS NUMBER HAS TO BE SENT WITH EACH REQUEST. IF NOT, THE SYSTEM WILL SEND THE HISTORICAL DATA AS WELL',
 PRIMARY KEY (ID)) ENGINE = InnoDB;

CREATE TABLE DAILY_SHARE_DATA (
	ID INT,
	COMPANY_ID INT NOT NULL,
	DATE DATE,
	SHARE_PRICE DOUBLE,
	HIGH DOUBLE,
	LOW DOUBLE,
	TURNOVER DOUBLE,
	VOLUME DOUBLE,
	NO_OF_TRADES DOUBLE,
	OPENING_PRICE DOUBLE) ENGINE = InnoDB;

CREATE TABLE DAILY_SECTOR_DATA (
	ID INT NOT NULL,
	SECTOR_ID INT NOT NULL,
	DATE DATE,
	CLOSING_VALUE DOUBLE,
	NUMBER_OF_TRADES DOUBLE,
	VOLUME DOUBLE,
	TURNOVER DOUBLE,
 PRIMARY KEY (ID)) ENGINE = InnoDB;

CREATE TABLE QUARTERLY_SHARE_DATA (
	ID INT NOT NULL,
	COMPANY_ID INT NOT NULL,
	QUARTER_CODE VARCHAR(20),
	PROFIT DOUBLE,
	WEIGHTED_AVERAGE DOUBLE,
	AVERAGE_EQUITY DOUBLE,
	AVERAGE_TOTAL_ASSERTS DOUBLE,
	PROFIT_AFTER_TAX DOUBLE,
	REVENUES DOUBLE,
	EBITDA DOUBLE,
	CASH DOUBLE,
	PERCENT_OWNBY_INSIDERS DOUBLE,
	INST_OWNERSHIP DOUBLE,
	SHARES_IN_FREEFLOAT DOUBLE,
	DEBT DOUBLE,
 PRIMARY KEY (ID)) ENGINE = InnoDB;

CREATE TABLE ANNUAL_SHARE_DATA (
	ID INT NOT NULL,
	COMPANY_ID INT NOT NULL,
	YEAR INT,
	NET_PROFIT DOUBLE,
	NUMBER_OF_SHARES DOUBLE,
	REVENUES DOUBLE,
	EBITDA DOUBLE,
	DIVIDENTS INT,
 PRIMARY KEY (ID)) ENGINE = InnoDB;

CREATE TABLE USER (
	ID INT NOT NULL,
	OWER_ID INT NOT NULL,
	CATEGORY_ID INT NOT NULL,
	USER_NAME VARCHAR(150),
	PASSWORD VARCHAR(30),
	EMAIL VARCHAR(100),
	TELEPHONE VARCHAR(20),
	ADDRESS VARCHAR(400),
 PRIMARY KEY (ID)) ENGINE = InnoDB;

CREATE TABLE USER_CATEGORY (
	ID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(100),
 PRIMARY KEY (ID)) ENGINE = InnoDB;

CREATE TABLE MODULE (
	ID INT NOT NULL,
	NAME VARCHAR(50),
 PRIMARY KEY (ID)) ENGINE = InnoDB
COMMENT = 'MODULES ARE LIKE STOCK SCREENER';

CREATE TABLE CATEGORY_MODULE (
	USER_CATEGORY_ID INT NOT NULL,
	MODULE_ID INT NOT NULL) ENGINE = InnoDB;

CREATE TABLE FILTER (
	ID INT NOT NULL,
	MODULE_ID INT NOT NULL,
	FILTER_VALUES VARCHAR(500) COMMENT 'COMMA SEPERATED
',
 PRIMARY KEY (ID)) ENGINE = InnoDB;

CREATE TABLE CATEGORY_FILTER (
	FILTER_ID INT NOT NULL,
	CATEGORY_ID INT NOT NULL) ENGINE = InnoDB;


ALTER TABLE INTRADAY_SHARE_DATA ADD FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE DAILY_SHARE_DATA ADD FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE QUARTERLY_SHARE_DATA ADD FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE ANNUAL_SHARE_DATA ADD FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE COMPANY ADD FOREIGN KEY (SECTOR_ID) REFERENCES SECTOR (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE INTRADAY_SECTOR_DATA ADD FOREIGN KEY (SECTOR_ID) REFERENCES SECTOR (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE DAILY_SECTOR_DATA ADD FOREIGN KEY (SECTOR_ID) REFERENCES SECTOR (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE USER ADD FOREIGN KEY (OWER_ID) REFERENCES USER (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE USER ADD FOREIGN KEY (CATEGORY_ID) REFERENCES USER_CATEGORY (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE CATEGORY_MODULE ADD FOREIGN KEY (USER_CATEGORY_ID) REFERENCES USER_CATEGORY (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE CATEGORY_FILTER ADD FOREIGN KEY (CATEGORY_ID) REFERENCES USER_CATEGORY (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE CATEGORY_MODULE ADD FOREIGN KEY (MODULE_ID) REFERENCES MODULE (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE FILTER ADD FOREIGN KEY (MODULE_ID) REFERENCES MODULE (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;
ALTER TABLE CATEGORY_FILTER ADD FOREIGN KEY (FILTER_ID) REFERENCES FILTER (ID) ON DELETE  RESTRICT ON UPDATE  RESTRICT;


commit;