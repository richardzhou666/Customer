CREATE TABLE contacts_tbl(
   contactID INT NOT NULL AUTO_INCREMENT,
   contact_name VARCHAR(100) NOT NULL,
   contact_lastname VARCHAR(40) NOT NULL,
   contact_phoneNume VARCHAR(15),
   contact_email VARCHAR(40),
   PRIMARY KEY ( contactID )
);
