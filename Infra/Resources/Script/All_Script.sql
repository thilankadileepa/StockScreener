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


drop table IF EXISTS CATEGORY_FILTER;
drop table IF EXISTS FILTER;
drop table IF EXISTS CATEGORY_MODULE;
drop table IF EXISTS MODULE;
drop table IF EXISTS USER_CATEGORY;
drop table IF EXISTS USER;
drop table IF EXISTS ANNUAL_SHARE_DATA;
drop table IF EXISTS QUARTERLY_SHARE_DATA;
drop table IF EXISTS DAILY_SECTOR_DATA;
drop table IF EXISTS DAILY_SHARE_DATA;
drop table IF EXISTS INTRADAY_SECTOR_DATA;
drop table IF EXISTS INTRADAY_SHARE_DATA;
drop table IF EXISTS SECTOR;
drop table IF EXISTS COMPANY;


Create table COMPANY (
	ID Int NOT NULL AUTO_INCREMENT,
	SECTOR_ID Int NOT NULL,
	CODE Varchar(20),
	NAME Varchar(200),
 Primary Key (ID)) ENGINE = InnoDB;

Create table SECTOR (
	ID Int NOT NULL AUTO_INCREMENT,
	CODE Varchar(20),
	NAME Varchar(150),
 Primary Key (ID)) ENGINE = InnoDB
COMMENT = 'Already defined sectors.
Ex. ASI, S&P20';

Create table INTRADAY_SHARE_DATA (
	ID Int NOT NULL AUTO_INCREMENT,
	COMPANY_ID Int NOT NULL,
	TIME Datetime,
	TRADE_VOLUME Double,
	SHARE_VOLUME Double,
	TURNOVER Double,
	LAST_TRADED_PRICE Double,
	CLOSING_PRICE Double,
	VALUE_CHANGE Double,
	PERCENTAGE_CHANGE Double,
 Primary Key (ID)) ENGINE = InnoDB;

Create table INTRADAY_SECTOR_DATA (
	ID Int NOT NULL AUTO_INCREMENT,
	SECTOR_ID Int NOT NULL,
	TIME Datetime,
	VALUE Double,
	VALUE_CHANGE Double,
	PERCENTAGE_CHANGE Double,
	SEQUENCE Int COMMENT 'this number has to be sent with each request. if not, the system will send the historical data as well',
 Primary Key (ID)) ENGINE = InnoDB;

Create table DAILY_SHARE_DATA (
	ID Int NOT NULL AUTO_INCREMENT,
	COMPANY_ID Int NOT NULL,
	DATE Date,
	SHARE_PRICE Double,
	HIGH Double,
	LOW Double,
	TURNOVER Double,
	VOLUME Double,
	NO_OF_TRADES Double,
	OPENING_PRICE Double,
	Primary Key (ID)) ENGINE = InnoDB;

Create table DAILY_SECTOR_DATA (
	ID Int NOT NULL AUTO_INCREMENT,
	SECTOR_ID Int NOT NULL,
	DATE Date,
	CLOSING_VALUE Double,
	NUMBER_OF_TRADES Double,
	VOLUME Double,
	TURNOVER Double,
 Primary Key (ID)) ENGINE = InnoDB;

Create table QUARTERLY_SHARE_DATA (
	ID Int NOT NULL AUTO_INCREMENT,
	COMPANY_ID Int NOT NULL,
	QUARTER_CODE Varchar(20),
	PROFIT Double,
	WEIGHTED_AVERAGE Double,
	AVERAGE_EQUITY Double,
	AVERAGE_TOTAL_ASSERTS Double,
	PROFIT_AFTER_TAX Double,
	REVENUES Double,
	EBITDA Double,
	CASH Double,
	PERCENT_OWNBY_INSIDERS Double,
	INST_OWNERSHIP Double,
	SHARES_IN_FREEFLOAT Double,
	DEBT Double,
 Primary Key (ID)) ENGINE = InnoDB;

Create table ANNUAL_SHARE_DATA (
	ID Int NOT NULL AUTO_INCREMENT,
	COMPANY_ID Int NOT NULL,
	YEAR Int,
	NET_PROFIT Double,
	NUMBER_OF_SHARES Double,
	REVENUES Double,
	EBITDA Double,
	DIVIDENTS Int,
 Primary Key (ID)) ENGINE = InnoDB;

Create table USER (
	ID Int NOT NULL AUTO_INCREMENT,
	OWER_ID Int NOT NULL,
	CATEGORY_ID Int NOT NULL,
	USER_NAME Varchar(150),
	PASSWORD Varchar(30),
	EMAIL Varchar(100),
	TELEPHONE Varchar(20),
	ADDRESS Varchar(400),
 Primary Key (ID)) ENGINE = InnoDB;

Create table USER_CATEGORY (
	ID Int NOT NULL AUTO_INCREMENT,
	NAME Varchar(100),
 Primary Key (ID)) ENGINE = InnoDB;

Create table MODULE (
	ID Int NOT NULL AUTO_INCREMENT,
	NAME Varchar(50),
 Primary Key (ID)) ENGINE = InnoDB
COMMENT = 'MODULES ARE LIKE STOCK SCREENER';

Create table CATEGORY_MODULE (
	ID Int NOT NULL AUTO_INCREMENT,
	USER_CATEGORY_ID Int NOT NULL,
	MODULE_ID Int NOT NULL,
 Primary Key (ID)) ENGINE = InnoDB;

Create table FILTER (
	ID Int NOT NULL AUTO_INCREMENT,
	MODULE_ID Int NOT NULL,
	FILTER_VALUES Varchar(500) COMMENT 'COMMA SEPERATED
',
 Primary Key (ID)) ENGINE = InnoDB;

Create table CATEGORY_FILTER (
	ID Int NOT NULL AUTO_INCREMENT,
	FILTER_ID Int NOT NULL,
	CATEGORY_ID Int NOT NULL,
 Primary Key (ID)) ENGINE = InnoDB;


Alter table INTRADAY_SHARE_DATA add Foreign Key (COMPANY_ID) references COMPANY (ID) on delete  restrict on update  restrict;
Alter table DAILY_SHARE_DATA add Foreign Key (COMPANY_ID) references COMPANY (ID) on delete  restrict on update  restrict;
Alter table QUARTERLY_SHARE_DATA add Foreign Key (COMPANY_ID) references COMPANY (ID) on delete  restrict on update  restrict;
Alter table ANNUAL_SHARE_DATA add Foreign Key (COMPANY_ID) references COMPANY (ID) on delete  restrict on update  restrict;
Alter table COMPANY add Foreign Key (SECTOR_ID) references SECTOR (ID) on delete  restrict on update  restrict;
Alter table INTRADAY_SECTOR_DATA add Foreign Key (SECTOR_ID) references SECTOR (ID) on delete  restrict on update  restrict;
Alter table DAILY_SECTOR_DATA add Foreign Key (SECTOR_ID) references SECTOR (ID) on delete  restrict on update  restrict;
Alter table USER add Foreign Key (OWER_ID) references USER (ID) on delete  restrict on update  restrict;
Alter table USER add Foreign Key (CATEGORY_ID) references USER_CATEGORY (ID) on delete  restrict on update  restrict;
Alter table CATEGORY_MODULE add Foreign Key (USER_CATEGORY_ID) references USER_CATEGORY (ID) on delete  restrict on update  restrict;
Alter table CATEGORY_FILTER add Foreign Key (CATEGORY_ID) references USER_CATEGORY (ID) on delete  restrict on update  restrict;
Alter table CATEGORY_MODULE add Foreign Key (MODULE_ID) references MODULE (ID) on delete  restrict on update  restrict;
Alter table FILTER add Foreign Key (MODULE_ID) references MODULE (ID) on delete  restrict on update  restrict;
Alter table CATEGORY_FILTER add Foreign Key (FILTER_ID) references FILTER (ID) on delete  restrict on update  restrict;


commit;