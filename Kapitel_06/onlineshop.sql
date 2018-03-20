DROP TABLE item;
DROP TABLE customer;

CREATE TABLE customer (
id         NUMBER(19) PRIMARY KEY,
email      VARCHAR2(40) NOT NULL UNIQUE,
password   VARCHAR2(10) NOT NULL
           CHECK(LENGTH(password)>=6)
);
GRANT SELECT, INSERT, UPDATE, DELETE 
ON customer TO onlineshop_user; 

CREATE UNIQUE INDEX customer_index 
ON customer(
    email,
    password
);

CREATE TABLE item (
id           NUMBER(19) PRIMARY KEY,
title        VARCHAR2(40) NOT NULL,
description  VARCHAR2(1000) NOT NULL,
price        NUMBER(12,2) NOT NULL,
foto         BLOB,
seller_id    NUMBER(19) NOT NULL,
buyer_id     NUMBER(19),
sold         TIMESTAMP(3),
CONSTRAINT fk_seller 
    FOREIGN KEY (seller_id) REFERENCES customer (id),
CONSTRAINT fk_buyer 
    FOREIGN KEY (buyer_id) REFERENCES customer (id)
);
GRANT SELECT, INSERT, UPDATE, DELETE 
ON item TO onlineshop_user; 

DROP SEQUENCE seq_customer;
CREATE SEQUENCE seq_customer;
GRANT ALL ON seq_customer TO onlineshop_user;

DROP SEQUENCE seq_item;
CREATE SEQUENCE seq_item;
GRANT ALL ON seq_item TO onlineshop_user;

CREATE OR REPLACE TRIGGER tri_customer
BEFORE INSERT ON customer
FOR EACH ROW
BEGIN :NEW.id := seq_customer.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER tri_item
BEFORE INSERT ON item
FOR EACH ROW
BEGIN :NEW.id := seq_item.NEXTVAL;
END;
/

commit;
