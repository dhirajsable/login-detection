create database contactlogin;
create user contactlogin with encrypted password 'root';
grant all privileges on database contactlogin to contactlogin;

CREATE TABLE if not exists DATASOURCECONFIG (
	id bigint PRIMARY KEY,
	driverclassname VARCHAR(255),
	url VARCHAR(255),
	name VARCHAR(255),
	username VARCHAR(255),
	password VARCHAR(255),
	initialize BOOLEAN
);

create schema if not exists account_1000;
create schema if not exists account_1001;

CREATE SEQUENCE "account_1".hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
CREATE SEQUENCE "account_2".hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
INSERT INTO DATASOURCECONFIG VALUES (5, 'org.postgresql.Driver', 'jdbc:postgresql://localhost:5432/contactlogin?currentSchema=account_1000&ApplicationName=login-detection', 'account_1000', 'contactlogin', 'root', true);
INSERT INTO DATASOURCECONFIG VALUES (6, 'org.postgresql.Driver', 'jdbc:postgresql://localhost:5432/contactlogin?currentSchema=account_1001&ApplicationName=login-detection', 'account_1001', 'contactlogin', 'root', true);

create table account_1000.devicemetadata
(
	id serial not null,
	userid int not null,
	devicedetails jsonb,
	location jsonb,
	lastloggedin timestamp,
	createddate timestamp default Now(),
	updatedat timestamp default now()
);

comment on column account_1000.devicemetadata.createddate is 'now()';

create unique index devicemetadata_id_uindex
	on account_1000.devicemetadata (id);

alter table account_1000.devicemetadata
	add constraint devicemetadata_pk
		primary key (id);

