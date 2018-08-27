

/* Create Sequences */

CREATE SEQUENCE SEQ_Sales_sales_no INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE Car
(
	car_no number NOT NULL,
	car_kind varchar2(10) NOT NULL,
	car_name nvarchar2(10) NOT NULL,
	PRIMARY KEY (car_no)
);


CREATE TABLE Customer
(
	Customer_id varchar2(10) NOT NULL,
	name nvarchar2(10) NOT NULL,
	tel char(13) NOT NULL,
	PRIMARY KEY (Customer_id)
);


CREATE TABLE Sales
(
	sales_no number NOT NULL,
	Customer_id varchar2(10) NOT NULL,
	car_no number NOT NULL,
	sales_date date DEFAULT SYSDATE,
	PRIMARY KEY (sales_no)
);


CREATE TABLE Scrap
(
	sales_no number NOT NULL,
	Scrap_date date DEFAULT SYSDATE,
	PRIMARY KEY (sales_no)
);



/* Create Foreign Keys */

ALTER TABLE Sales
	ADD FOREIGN KEY (car_no)
	REFERENCES Car (car_no)
;


ALTER TABLE Sales
	ADD FOREIGN KEY (Customer_id)
	REFERENCES Customer (Customer_id)
;


ALTER TABLE Scrap
	ADD FOREIGN KEY (sales_no)
	REFERENCES Sales (sales_no)
;



