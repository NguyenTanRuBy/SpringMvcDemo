use store;

-- CREATE TABLE --------------
CREATE TABLE `category` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`name` NVARCHAR(100) NOT NULL UNIQUE,
PRIMARY KEY (`id`)
);

CREATE TABLE `item` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`name` NVARCHAR(100) NOT NULL UNIQUE,
`price` DOUBLE DEFAULT 10000,
`discount_percent` INT DEFAULT 0,
PRIMARY KEY (`id`)
);

CREATE TABLE `category_item` (
`category_id` INT(11) NOT NULL,
`item_id` INT(11) NOT NULL,
PRIMARY KEY (`category_id`, `item_id`)
);

-- ALTER TABLE --------
ALTER TABLE category_item ADD CONSTRAINT FK_CATEGORY_ID FOREIGN KEY(category_id) REFERENCES category(id);
ALTER TABLE category_item ADD CONSTRAINT FK_ITEM_ID FOREIGN KEY(ITEM_id) REFERENCES ITEM(id);

-- INSERT -------------
INSERT INTO category(name) VALUES (N'RAU CỦ'), (N'TRÁI CÂY'), (N'NẤM'), (N'CÂY KIỂNG');
INSERT INTO item(name, price, discount_percent) 
VALUES (N'CÀ CHUA', '20000', '10'), 
		(N'CÀ TÍM', '50000', '0'), 
		(N'CỦ CẢI', '30000', '10'), 
		(N'XÀ LÁCH', '20000', '10'),
		(N'NHÃN LỒNG', '50000', '10'),
		(N'XOÀI THÁI', '45000', '10'),
		(N'THANH LONG', '15000', '10'),
		(N'NẤM HƯƠNG', '20000', '10'),
		(N'NẤM RƠM', '70000', '10'),
		(N'NẤM DAI', '80000', '10'),
		(N'CẤY SỨ BONSAI', '200000', '10'),
		(N'CÂY ỚT KIỂNG', '300000', '10'),
		(N'CÂY TÙNG', '800000', '10');
INSERT INTO CATEGORY_ITEM (ITEM_ID, CATEGORY_ID)
VALUES (1,1), 
		(2,1), 
        (3,1), 
        (4,1),
        (5,2),
        (6,2),
        (7,2),
        (8,3),
        (9,3),
        (10,3),
        (11,4),
        (12,4),
        (13,4);

-- SELECT --------------
SELECT * FROM CATEGORY ORDER BY ID;
SELECT * FROM ITEM ORDER BY ID;
SELECT * FROM CATEGORY_ITEM;


ALTER TABLE ITEM ADD COLUMN IMG TEXT

#ALTER TABLE CATEGORY AUTO_INCREMENT = 1
#SET SQL_SAFE_UPDATES = 0;
#DELETE FROM CATEGORY;