-- Clean table
delete from Deal;
delete from Bid;
delete from Image;
delete from Item;
delete from Card;
delete from Favorite;
delete from Account;
delete from Address;
delete from User;
delete from Category;

-- Category
insert into Category values ("가전");
insert into Category values ("가구");
insert into Category values ("도서");
insert into Category values ("의류");
insert into Category values ("잡화");

-- User
insert into User values("abc123", "qwerty", "김도현", "24", "Male", "01012345678");
insert into User values("tjwldnjs", "123456", "서지원", "24", "Male", "01092275415");
insert into User values("rnlcksgdk", "000000", "김은희", "28", "Female", "01037825853");

-- Address
insert into Address values("abc123", "집", "", "01717", "서울시 노원구", "대림아파트");
insert into Address values("abc123", "학교", "", "05029", "서울시 광진구", "능동로 120 건국대학교");
insert into Address values("tjwldnjs", "기숙사", "", "05029", "서울시 광진구", "능동로 120 건국대학교");
insert into Address values("rnlcksgdk", "집", "", "05008", "서울시 광진구", "아차산로 355 아크로텔");

-- Account
insert into Account values("abc123", "신한은행", "110412123456");
insert into Account values("abc123", "신한은행", "123456123456");
insert into Account values("abc123", "하나은행", "75691000589105");
insert into Account values("rnlcksgdk", "하나은행", "75891000293843");
insert into Account values("tjwldnjs", "국민은행", "69100837419");

-- Favorite
insert into Favorite values("abc123", "tjwldnjs");
insert into Favorite values("abc123", "rnlcksgdk");

-- Card
insert into Card values("abc123", "하나카드", "4499148132801234");
insert into Card values("rnlcksgdk", "삼성카드", "377969004866711");
insert into Card values("abc123", "삼성카드", "1234567890123456");
insert into Card values("tjwldnjs", "신한카드", "1010101010101010");

-- Item
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("abc123", "가전", "1000000", "Sell", "0", "맥북 프로 i7");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("abc123", "가전", "500000", "Bid", "0", "맥북 프로 i7");

-- Image
insert into Image
select item_id, "macbook.jpg"
From Item
Where Item.user_id = "abc123"
AND Item.price = "1000000";

-- Bid
insert into Bid
select item_id, "rnlcksgdk", now(), 600000
From Item
Where Item.user_id = "abc123"
AND Item.price = "1000000";

-- Deal
insert into Deal (user_id, address_alias, item_id, time, state)
select "rnlcksgdk", "집", item_id, now(), "Paid"
From Item
Where Item.user_id = "abc123"
AND Item.price = "1000000";
