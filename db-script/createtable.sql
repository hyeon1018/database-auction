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
    `user_id`    VARCHAR(12) NOT NULL
 COMMENT 'user_id',
    `user_pw`    VARCHAR(25)
 COMMENT 'user_pw',
    `name`    VARCHAR(25)
 COMMENT 'name',
    `age`    INTEGER(3)
 COMMENT 'age',
    `gender`    VARCHAR(6) 
 COMMENT 'gender',
    `phone_number`    DECIMAL(12) NOT NULL
 COMMENT 'phone_number'
)
 COMMENT = 'User';

ALTER TABLE `User`
 ADD CONSTRAINT `엔터티1_PK1` PRIMARY KEY ( `user_id` );
 
ALTER TABLE user
 ADD CONSTRAINT `user_ck1` CHECK (GENDER IN ('MALE', 'FEMALE'));

DROP TABLE `Favorite`;

CREATE TABLE `Favorite`
(
    `seller_user_id`    VARCHAR(12) NOT NULL
 COMMENT 'seller_user_id',
    `user_id`    VARCHAR(12) NOT NULL
 COMMENT 'user_id'
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
    `user_id`    VARCHAR(12) NOT NULL
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
    `user_id`    VARCHAR(12) NOT NULL
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


DROP TABLE `Address`;

CREATE TABLE `Address`
(
    `user_id`    VARCHAR(12) NOT NULL
 COMMENT 'user_id',
    `address_alias`    VARCHAR(25) NOT NULL
 COMMENT 'address_alias',
    `address`    VARCHAR(25)
 COMMENT 'address',
    `zip_codes`    VARCHAR(6)
 COMMENT 'zip_codes',
    `city`    VARCHAR(25)
 COMMENT 'city',
    `street`    VARCHAR(25)
 COMMENT 'street'
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
    `item_id`    INTEGER(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
 COMMENT 'item_id',
    `user_id`    VARCHAR(12) NOT NULL
 COMMENT 'user_id',
    `category`    VARCHAR(25) NOT NULL
 COMMENT 'category',
    `price`    INTEGER(20)
 COMMENT 'price',
    `deal_type`    VARCHAR(20)
 COMMENT 'deal_type',
    `delivery_fee`    VARCHAR(20)
 COMMENT 'delivery_fee',
    `item_info`    VARCHAR(2000)
 COMMENT 'item_info',
    `total_item_point`    NUMERIC(2,1)
 COMMENT 'total_item_point',
    `report_count`    INTEGER(12)
 COMMENT 'report_count',
    `expire_time`    DATETIME
 COMMENT 'expire_time'
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
    `deal_id`    INTEGER(25) NOT NULL AUTO_INCREMENT PRIMARY KEY
 COMMENT 'deal_id',
    `user_id`    VARCHAR(12)
 COMMENT 'user_id',
    `address_alias`    VARCHAR(25) NOT NULL
 COMMENT 'address_alias',
    `item_id`    INTEGER(20) NOT NULL
 COMMENT 'item_id',
    `item_point`    NUMERIC(2,1)
 COMMENT 'item_point',
    `time`    DATETIME NOT NULL
 COMMENT 'time',
    `state`    VARCHAR(20) NOT NULL
 COMMENT 'state'
)
 COMMENT = 'Deal';

ALTER TABLE `Deal`
 ADD CONSTRAINT `deal_FK` FOREIGN KEY ( `user_id` )
 REFERENCES User (`user_id` );

ALTER TABLE `Deal`
 ADD CONSTRAINT `deal_FK1` FOREIGN KEY ( `item_id` )
 REFERENCES Item (`item_id` );


DROP TABLE `Bid`;

CREATE TABLE `Bid`
(
    `item_id`    INTEGER (20) NOT NULL
 COMMENT 'item_id',
    `user_id`    VARCHAR(12) NOT NULL
 COMMENT 'user_id',
    `join_time`    DATETIME NOT NULL
 COMMENT 'join_time',
    `join_price`    INTEGER(20)
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
    `item_id`    INTEGER (20) NOT NULL
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

