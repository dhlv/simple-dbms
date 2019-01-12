USE dlv;
/* Notice that I turned off the safe mode in mySQL 
so if mySQL is on safe mode, 
the UPDATE or DELETE would not work
*/


CREATE TABLE STOREHOUSE(
	Location			VARCHAR(25),
    Place_ID	VARCHAR(20) PRIMARY KEY NOT NULL,
    Size		VARCHAR(10)
);

INSERT INTO STOREHOUSE VALUES('Robie','1','Big');
INSERT INTO STOREHOUSE VALUES('Quinnpool','2','Big');
INSERT INTO STOREHOUSE VALUES('SpringGarden','3','Small');
INSERT INTO STOREHOUSE VALUES('Dartmouth','4','Middle');
INSERT INTO STOREHOUSE VALUES('Bedford','5','Big');
INSERT INTO STOREHOUSE VALUES('China','6','Big');
INSERT INTO STOREHOUSE VALUES('Toronto','7','Small');
INSERT INTO STOREHOUSE VALUES('Japan','8','Small');
INSERT INTO STOREHOUSE VALUES('Korea','9','Small');
INSERT INTO STOREHOUSE VALUES('USA','10','Big');


CREATE TABLE MANAGER(
	M_NAME			VARCHAR(20)	NOT NULL,
    M_ID	VARCHAR(20) PRIMARY KEY		NOT NULL,
    Sex		VARCHAR(10),
	Place_ID VARCHAR(20) NOT NULL,
      FOREIGN KEY (Place_ID) REFERENCES STOREHOUSE(Place_ID)
);

INSERT INTO MANAGER VALUES('Bob','0002','MALE','1');    
INSERT INTO MANAGER VALUES('Amy','0001','FEMALE','2');    
INSERT INTO MANAGER VALUES('Cindy','0003','FEMALE','3');    
INSERT INTO MANAGER VALUES('Daviad','0004','MALE','4');    
INSERT INTO MANAGER VALUES('Elsu','0005','MALE','5');    
INSERT INTO MANAGER VALUES('Frank','0006','MALE','6');    
INSERT INTO MANAGER VALUES('Grakk','0007','MALE','7');    
INSERT INTO MANAGER VALUES('Henry','0008','MALE','8');    
INSERT INTO MANAGER VALUES('Iris','0009','FEMALE','9');    
INSERT INTO MANAGER VALUES('Jenny','0010','FEMALE','10');    


CREATE TABLE GOODS(
	G_NAME			VARCHAR(25),
    G_ID	VARCHAR(20) PRIMARY KEY NOT NULL,
    Quantity		INT,
    Place_ID VARCHAR(20) NOT NULL,
	FOREIGN KEY (Place_ID) REFERENCES STOREHOUSE(Place_ID)

);

INSERT INTO GOODS VALUES('Wings','001','900','1');
INSERT INTO GOODS VALUES('Apples','002','900','2');
INSERT INTO GOODS VALUES('Juice','003','800','3');
INSERT INTO GOODS VALUES('Coke','004','500','4');
INSERT INTO GOODS VALUES('Oranges','005','1000','5');
INSERT INTO GOODS VALUES('Ice_cream','006','500','6');
INSERT INTO GOODS VALUES('Yogurt','007','200','7');
INSERT INTO GOODS VALUES('Milk','008','150','8');
INSERT INTO GOODS VALUES('Eggs','009','1000','9');
INSERT INTO GOODS VALUES('Bacon','010','500','10');
INSERT INTO GOODS VALUES('Coke','011','400','9');
INSERT INTO GOODS VALUES('Yogurt','012','200','7');



CREATE TABLE AUDIT(
 MESSAGE varchar(45) NOT NULL
);



/* find the goods name and quantity which goods id=2*/
SELECT G_NAME,Quantity
FROM GOODS
WHERE G_ID = 2;
/*This part of queries select all the Goods that the quantity is larger than 500*/
SELECT *
FROM GOODS
WHERE Quantity > 500;

SELECT M_NAME,M_ID,SUM(Quantity) 
FROM MANAGER LEFT JOIN 
GOODS ON MANAGER.Place_ID=GOODS.Place_ID
GROUP BY M_ID;

INSERT INTO GOODS VALUES('sausage','888','200','7');
/*delete this item*/
DELETE FROM GOODS WHERE G_NAME='sausage';



/*update the manage information*/
UPDATE MANAGER
SET Sex='Male', M_NAME='JOHN'
WHERE M_ID='1';


CREATE VIEW LEFTGOODS AS 
SELECT G_NAME,SUM(Quantity) 
FROM GOODS
GROUP BY G_NAME;


delimiter //
CREATE TRIGGER ADDINFO AFTER INSERT
ON AUDIT
FOR EACH ROW
begin
			INSERT INTO AUDIT( MESSAGE) VALUES('Add record successfully!');
END;//

/*procedure*/
CREATE PROCEDURE P()
BEGIN
SELECT Quantity
FROM Goods;
END;
CALL P();





