DROP TABLE IF EXISTS employee;

CREATE TABLE employee
{  id             SERIAL        NOT NULL PRIMARY KEY,
   firstName      VARCHAR(100)  NOT NULL,
   lastName       VARCHAR(100)  NOT NULL,
   age            INTEGER       NOT NULL,
   phoneNumber    VARCHAR(100)  NOT NULL,
   emailAddress   VARCHAR(100)  NOT NULL,
   username       VARCHAR(100)  NOT NULL,
   password       VARCHAR(100)  NOT NULL

};