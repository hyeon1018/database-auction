DROP VIEW item_list;

ALTER TABLE `Address`
DROP FOREIGN KEY address_FK;

ALTER TABLE `Deal`
DROP FOREIGN KEY deal_FK;

ALTER TABLE `Bid`
DROP FOREIGN KEY bid_FK;

ALTER TABLE `Item`
DROP FOREIGN KEY item_FK;

ALTER TABLE `Favorite`
DROP FOREIGN KEY favorite_FK;

ALTER TABLE `Favorite`
DROP FOREIGN KEY favorite_FK1;

ALTER TABLE `Account`
DROP FOREIGN KEY Account_FK;

ALTER TABLE `Card`
DROP FOREIGN KEY Card_FK;

DROP TABLE `User`;

CREATE TABLE `User`
(
    `user_id`    VARCHAR(20) NOT NULL
 COMMENT 'user_id'
 CHECK(`user_id` REGEXP '^[a-zA-z0-9]+$'),
    `user_pw`    VARCHAR(40)
 COMMENT 'user_pw',
    `name`    VARCHAR(25)
 COMMENT 'name',
    `age`    INTEGER(3)
 COMMENT 'age'
 CHECK (`age` > 0 ),
    `gender`    VARCHAR(6)
 COMMENT 'gender'
 CHECK (`gender` in ("Male", "Female")),
    `phone_number`    VARCHAR(20) NOT NULL
 COMMENT 'phone_number'
)
 COMMENT = 'User';

ALTER TABLE `User`
 ADD CONSTRAINT `엔터티1_PK1` PRIMARY KEY ( `user_id` );

DROP TABLE `Favorite`;

CREATE TABLE `Favorite`
(
    `seller_user_id`    VARCHAR(20) NOT NULL
 COMMENT 'seller_user_id',
    `user_id`    VARCHAR(20) NOT NULL
 COMMENT 'user_id',
 CONSTRAINT `not_equal` CHECK (`seller_user_id` != `user_id`)
)
 COMMENT = 'Favorite';

ALTER TABLE `Favorite`
 ADD CONSTRAINT `엔터티1_PK9` PRIMARY KEY ( `user_id`,`seller_user_id` );

ALTER TABLE `Favorite`
 ADD CONSTRAINT `favorite_FK` FOREIGN KEY ( `seller_user_id` )
 REFERENCES User (`user_id` );

ALTER TABLE `Favorite`
 ADD CONSTRAINT `favorite_FK1` FOREIGN KEY ( `user_id` )
 REFERENCES User (`user_id` );


DROP TABLE `Account`;

CREATE TABLE `Account`
(
    `user_id`    VARCHAR(20) NOT NULL
 COMMENT 'user_id',
    `bank`    VARCHAR(25) NOT NULL
 COMMENT 'bank',
    `account`    VARCHAR(20) NOT NULL
 COMMENT 'account'
)
 COMMENT = 'Account';

ALTER TABLE `Account`
 ADD CONSTRAINT `엔터티1_PK11` PRIMARY KEY ( `bank`,`account` );

ALTER TABLE `Account`
 ADD CONSTRAINT `Account_FK` FOREIGN KEY ( `user_id` )
 REFERENCES User (`user_id` );


DROP TABLE `Card`;

CREATE TABLE `Card`
(
    `user_id`    VARCHAR(20) NOT NULL
 COMMENT 'user_id',
    `card_company`    VARCHAR(25) NOT NULL
 COMMENT 'card_company',
    `card_number`    VARCHAR(16) NOT NULL
 COMMENT 'card_number'
)
 COMMENT = 'Card';

ALTER TABLE `Card`
 ADD CONSTRAINT `엔터티1_PK12` PRIMARY KEY ( `card_company`,`card_number` );

ALTER TABLE `Card`
 ADD CONSTRAINT `Card_FK` FOREIGN KEY ( `user_id` )
 REFERENCES User (`user_id` );

ALTER TABLE `Deal`	-- 추가함.
DROP FOREIGN KEY deal_FK2;
 
DROP TABLE `Address`;

CREATE TABLE `Address`
(
    `user_id`    VARCHAR(20) NOT NULL
 COMMENT 'user_id',
    `address_alias`    VARCHAR(25) NOT NULL
 COMMENT 'address_alias',
    `address`    VARCHAR(100)
 COMMENT 'address'
)
 COMMENT = 'Address';

ALTER TABLE `Address`
 ADD CONSTRAINT `엔터티1_PK6` PRIMARY KEY ( `user_id`,`address_alias` );

ALTER TABLE `Address`
 ADD CONSTRAINT `address_FK` FOREIGN KEY ( `user_id` )
 REFERENCES User (`user_id` );


ALTER TABLE `Item`
DROP FOREIGN KEY item_FK1;

DROP TABLE `Category`;

CREATE TABLE `Category`
(
    `category`    VARCHAR(25) NOT NULL
 COMMENT 'category'
)
 COMMENT = 'Category';

ALTER TABLE `Category`
 ADD CONSTRAINT `엔터티1_PK7` PRIMARY KEY ( `category` );


ALTER TABLE `Deal`
DROP FOREIGN KEY deal_FK1;

ALTER TABLE `Bid`
DROP FOREIGN KEY bid_FK1;

ALTER TABLE `Image`
DROP FOREIGN KEY image_FK;

DROP TABLE `Item`;

CREATE TABLE `Item`
(
    `item_id`    BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
 COMMENT 'item_id',
    `user_id`    VARCHAR(20) NOT NULL
 COMMENT 'user_id',
    `category`    VARCHAR(25) NOT NULL
 COMMENT 'category',
    `price`    DECIMAL(20)
 COMMENT 'price',
    `deal_type`    VARCHAR(20)
 COMMENT 'deal_type'
 CHECK (`deal_type` in ("Sell", "Bid")),
    `delivery_fee`    VARCHAR(20)
 COMMENT 'delivery_fee',
    `item_info`    VARCHAR(2000)
 COMMENT 'item_info',
    `expire_time`    DATETIME
 COMMENT 'expire_time',
 CONSTRAINT `expire_time_check` CHECK (
    (deal_type = "Bid" AND expire_time IS NOT NULL)
    OR (deal_type = "SELL" AND expire_time IS NULL))
)
 COMMENT = 'Item';

ALTER TABLE `Item`
 ADD CONSTRAINT `item_FK` FOREIGN KEY ( `user_id` )
 REFERENCES User (`user_id` );

ALTER TABLE `Item`
 ADD CONSTRAINT `item_FK1` FOREIGN KEY ( `category` )
 REFERENCES Category (`category` );


DROP TABLE `Deal`;

CREATE TABLE `Deal`
(
    `deal_id`    BIGINT(25) NOT NULL AUTO_INCREMENT PRIMARY KEY
 COMMENT 'deal_id',
    `user_id`    VARCHAR(20)
 COMMENT 'user_id',
    `address_alias`    VARCHAR(25) NOT NULL
 COMMENT 'address_alias',
    `item_id`    BIGINT(20) NOT NULL
 COMMENT 'item_id',
    `item_point`    NUMERIC(2,1)
 COMMENT 'item_point',
    `time`    DATETIME NOT NULL
 COMMENT 'time',
    `state`    VARCHAR(20) NOT NULL DEFAULT '결제 완료'
 COMMENT 'state'
)
 COMMENT = 'Deal';

ALTER TABLE `Deal`
 ADD CONSTRAINT `deal_FK` FOREIGN KEY ( `user_id` )
 REFERENCES User (`user_id` );

ALTER TABLE `Deal`
 ADD CONSTRAINT `deal_FK1` FOREIGN KEY ( `item_id` )
 REFERENCES Item (`item_id` );

ALTER TABLE `Deal`		-- 추가함.
 ADD CONSTRAINT `deal_FK2` FOREIGN KEY ( `user_id`,`address_alias`)
 REFERENCES Address (`user_id`,`address_alias`);
 
DROP TABLE `Bid`;

CREATE TABLE `Bid`
(
    `item_id`    BIGINT(20) NOT NULL
 COMMENT 'item_id',
    `user_id`    VARCHAR(20) NOT NULL
 COMMENT 'user_id',
    `join_time`    DATETIME NOT NULL
 COMMENT 'join_time',
    `join_price`    DECIMAL(20)
 COMMENT 'join_price'
)
 COMMENT = 'Bid';

ALTER TABLE `Bid`
 ADD CONSTRAINT `엔터티1_PK2` PRIMARY KEY ( `item_id`,`user_id`,`join_time` );

ALTER TABLE `Bid`
 ADD CONSTRAINT `bid_FK` FOREIGN KEY ( `user_id` )
 REFERENCES User (`user_id` );

ALTER TABLE `Bid`
 ADD CONSTRAINT `bid_FK1` FOREIGN KEY ( `item_id` )
 REFERENCES Item (`item_id` );


DROP TABLE `Image`;

CREATE TABLE `Image`
(
    `item_id`    BIGINT(20) NOT NULL
 COMMENT 'item_id',
    `dir`    VARCHAR(1000) NOT NULL
 COMMENT 'dir'
)
 COMMENT = 'Image';

ALTER TABLE `Image`
 ADD CONSTRAINT `엔터티1_PK10` PRIMARY KEY ( `dir`,`item_id` );

ALTER TABLE `Image`
 ADD CONSTRAINT `image_FK` FOREIGN KEY ( `item_id` )
 REFERENCES Item (`item_id` );

CREATE VIEW item_list AS
SELECT deal_type, item_id, category, price, delivery_fee, item_info, user_id, expire_time
FROM Item
WHERE item_id NOT IN (SELECT DISTINCT item_id FROM Bid)
UNION
SELECT deal_type, item_id, category, max_price, delivery_fee, item_info, user_id, expire_time
FROM Item Join (SELECT item_id, max(join_price) as max_price
				FROM Bid
				GROUP BY item_id) item_price USING(item_id);

SELECT Item.user_id, avg(item_point)
FROM Deal JOIN Item USING(item_id)
GROUP BY Item.user_id;
