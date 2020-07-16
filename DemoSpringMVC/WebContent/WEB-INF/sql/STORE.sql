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
`img` TEXT,
`price` DOUBLE DEFAULT 10000,
`discount_percent` INT DEFAULT 0,
PRIMARY KEY (`id`)
);

CREATE TABLE `category_item` (
`category_id` INT(11) NOT NULL,
`item_id` INT(11) NOT NULL,
PRIMARY KEY (`category_id`, `item_id`)
);

CREATE TABLE `TOP_SALE` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`item_id` INT(11) NOT NULL,
`amount` INT DEFAULT 1,
PRIMARY KEY (`id`)
);

CREATE TABLE `CART` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`user_name` NVARCHAR(50) NOT NULL,
`item_id` INT(11) NOT NULL,
`amount` INT DEFAULT 1,
PRIMARY KEY (`id`, `user_name`)
);

-- ALTER TABLE --------
ALTER TABLE category_item ADD CONSTRAINT FK_CATEGORY_ID FOREIGN KEY(category_id) REFERENCES category(id);
ALTER TABLE category_item ADD CONSTRAINT FK_ITEM_ID FOREIGN KEY(item_id) REFERENCES ITEM(id);
ALTER TABLE top_sale ADD CONSTRAINT FK_TOP_SALE_ITEM_ID FOREIGN KEY(item_id) REFERENCES ITEM(id);

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

INSERT INTO TOP_SALE(ITEM_ID, AMOUNT) 
VALUES (1,10),
		(2,10),
        (3,17),
        (4,11),
        (5,14),
        (6,20),
        (7,12),
        (8,15),
        (10,22);

-- UPDATE ----------------------------------
UPDATE item set img = 'img/ca_chua.jpg' where id = 1;
UPDATE item set img = 'img/ca_tim.jpg' where id = 2;
UPDATE item set img = 'img/cu_cai.jpg' where id = 3;
UPDATE item set img = 'img/xa_lach.jpg' where id = 4;
UPDATE item set img = 'img/nhan_long.jpg' where id = 5;
UPDATE item set img = 'img/xoai_thai.jpg' where id = 6;
UPDATE item set img = 'img/thanh_long.jpg' where id = 7;
UPDATE item set img = 'img/nam_huong.jpg' where id = 8;
UPDATE item set img = 'img/nam_rom.jpg' where id = 9;
UPDATE item set img = 'img/nam_dai.jpg' where id = 10;
UPDATE item set img = 'img/default_img.png' where id = 11;
UPDATE item set img = 'img/default_img.png' where id = 12;
UPDATE item set img = 'img/default_img.png' where id = 13;

-- SELECT --------------
SELECT * FROM CATEGORY ORDER BY ID;
SELECT * FROM ITEM ORDER BY ID;
SELECT * FROM CATEGORY_ITEM;

SELECT IT.ID, IT.NAME, IT.IMG, TS.AMOUNT
	FROM ITEM IT JOIN TOP_SALE TS ON IT.ID = TS.ITEM_ID
	ORDER BY IT.ID
	LIMIT 9;
    
select * from item


#ALTER TABLE CATEGORY AUTO_INCREMENT = 1
#SET SQL_SAFE_UPDATES = 0;
#DELETE FROM CATEGORY;