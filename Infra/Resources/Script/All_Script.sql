/*
Created		3/5/2014
Modified		3/29/2014
Project		
Model		
Company		
Author		
Version		
Database		mySQL 5 
*/

DROP DATABASE STOCK;
CREATE DATABASE STOCK;
USE STOCK;

drop table IF EXISTS SUB_SECTOR;
drop table IF EXISTS FILTER_CATEGORY;
drop table IF EXISTS DIVIDEND;
drop table IF EXISTS BANNER;
drop table IF EXISTS PAYMENT;
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
	LARGE_CAP_COMPANY Char(1),
	ASI Char(1) COMMENT 'Is it an ASI company',
	SANDPP Char(1) COMMENT 'Is it an S&PP company ',
	STATUS Char(1),
 Primary Key (ID)) ENGINE = InnoDB
COMMENT = 'To mark as a large cap company.';

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
	YEAR_CODE Int,
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
	FILTER_CATEGORY_ID Int NOT NULL,
 Primary Key (ID)) ENGINE = InnoDB;

Create table CATEGORY_FILTER (
	ID Int NOT NULL AUTO_INCREMENT,
	FILTER_ID Int NOT NULL,
	CATEGORY_ID Int NOT NULL,
 Primary Key (ID)) ENGINE = InnoDB;

Create table PAYMENT (
	ID Int NOT NULL AUTO_INCREMENT,
	USER_ID Int NOT NULL,
	MER_ID Varchar(50),
	ACQ_ID Varchar(50),
	ORDER_ID Varchar(50),
	RESPONSE_CODE Varchar(20),
	REASON_CODE Varchar(20),
	REASON_CODE_DESC Varchar(100),
	REFERENCE_NO Varchar(20),
	PADDEDCARD_NO Varchar(20),
	AUTH_CODE Varchar(20),
	SHIPTOTOFIRSTNAME Varchar(20),
	SIGNATURE Varchar(20),
	SIGNATUREMETHOD Varchar(20),
	ADDED_DATE Date,
	UNIQUE (ID),
 Primary Key (ID)) ENGINE = InnoDB;

Create table BANNER (
	ID Int NOT NULL,
	POSITION_CODE Varchar(10) COMMENT 'The position of the site is identified with this code.',
	START_DATE Date,
	EXPIRE_DATE Date,
	BANNER_NAME Varchar(150),
 Primary Key (ID)) ENGINE = InnoDB;

Create table DIVIDEND (
	ID Int NOT NULL AUTO_INCREMENT,
	COMPANY_ID Int NOT NULL,
	UPDATED_DATE Date,
	EFFECTIVE_DATE Date,
	AMOUNT Double,
 Primary Key (ID)) ENGINE = InnoDB;

Create table FILTER_CATEGORY (
	ID Int NOT NULL AUTO_INCREMENT,
	FILTER_TYPE Varchar(20),
 Primary Key (ID)) ENGINE = InnoDB
COMMENT = 'Fundamental, most use, advanced, etc...';

Create table SUB_SECTOR (
	ID Int NOT NULL AUTO_INCREMENT,
	SECTOR_ID Int NOT NULL,
	NAME Varchar(20),
	CODE Varchar(20),
 Primary Key (ID)) ENGINE = MyISAM;


