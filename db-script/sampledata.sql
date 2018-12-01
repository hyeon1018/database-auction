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
insert into Category values ("식품");
insert into Category values ("완구");
insert into Category values ("취미");
insert into Category values ("레저");
insert into Category values ("미용");

-- User		-- user insert data만 수정함.
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("rlaehgus", md5("qwerty"), "김도현", "24", "Male", "01012345678");
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("tjwldnjs", md5("123456"), "서지원", "24", "Male", "01092275415");
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("rladmsgml", md5("000000"), "김은희", "28", "Female", "01037825853");
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("wkdtmddnjs", md5("000001"), "장승원", "24", "Male", "01031972134");
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("rkdwjdah", md5("000002"), "강정모", "26", "Male", "01019735218");
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("wjddbghks", md5("000003"), "정유환", "25", "Male", "01094416793");
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("tlstkdlaekd", md5("000004"), "신사임당", "99", "Female", "01077912131");
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("dltn", md5("000005"), "이수", "37", "Male", "01066452115");
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("wkdejrcjf", md5("000006"), "장덕철", "40", "Male", "01044459132");
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("dlackdwjd", md5("000007"), "임창정", "44", "Male", "01067189975");
insert into User (user_id, user_pw, name, age, gender, phone_number)
values("test", md5("test"), "테스트용", "30", "Female", "01012345678");

-- Address
INSERT INTO Address (user_id, address_alias, address) VALUES('dlackdwjd', '기본배송지', '26420 강원도 원주시 백간길 80 벽산아파트');
INSERT INTO Address (user_id, address_alias, address) VALUES('dltn', '기본배송지', '06280 서울시 강남구 남부순환로 2909 여천빌딩');
INSERT INTO Address (user_id, address_alias, address) VALUES('rkdwjdah', '기본배송지', '48257 부산광역시 수영구 장대골로57번가길 16 광안리치빌 A동');
INSERT INTO Address (user_id, address_alias, address) VALUES('rladmsgml', '기본배송지', '05693 서울시 송파구 가락로 221 금송빌딩');
INSERT INTO Address (user_id, address_alias, address) VALUES('rlaehgus', '기본배송지', '01717 서울시 노원구 대림아파트');
INSERT INTO Address (user_id, address_alias, address) VALUES('rlaehgus', '학교', '05029 서울시 광진구 능동로 120 건국대학교');
INSERT INTO Address (user_id, address_alias, address) VALUES('test', '근무지', '서울시 학동로 168 1101호');
INSERT INTO Address (user_id, address_alias, address) VALUES('test', '기본배송지', '제주도 서귀포시');
INSERT INTO Address (user_id, address_alias, address) VALUES('test', '학교', '서울시 광진구 건국대학교');
INSERT INTO Address (user_id, address_alias, address) VALUES('tjwldnjs', '기본배송지', '05029 서울시 광진구 능동로 120 건국대학교');
INSERT INTO Address (user_id, address_alias, address) VALUES('tlstkdlaekd', '기본배송지', '15831 경기도 군포시 당산로 129 안양빌딩');
INSERT INTO Address (user_id, address_alias, address) VALUES('wjddbghks', '기본배송지', '06267 서울시 강남구 강남대로 238 스카이솔라빌딩');
INSERT INTO Address (user_id, address_alias, address) VALUES('wkdejrcjf', '기본배송지', '01011 서울시 강북구 4.19로 4 심플렉스빌딩');
INSERT INTO Address (user_id, address_alias, address) VALUES('wkdtmddnjs', '기본배송지', '02253 서울시 동대문구 사가정로 65 래미안아파트');


-- Account
insert into Account values("rlaehgus", "신한은행", "110412123456");
insert into Account values("rlaehgus", "신한은행", "123456123456");
insert into Account values("rlaehgus", "하나은행", "75691000589105");
insert into Account values("rladmsgml", "하나은행", "75891000293843");
insert into Account values("tjwldnjs", "국민은행", "69100837419");
insert into Account values("wkdtmddnjs", "기업은행", "943210061154");
insert into Account values("rkdwjdah", "부산은행", "7702125210058");
insert into Account values("wjddbghks", "씨티은행", "321008578004");
insert into Account values("tlstkdlaekd", "외환은행", "900124806408");
insert into Account values("dltn", "우리은행", "7765040093017");
insert into Account values("wkdejrcjf", "농협은행", "4618132001575");
insert into Account values("dlackdwjd", "대구은행", "367013205846");

-- Favorite
insert into Favorite values("rlaehgus", "tjwldnjs");
insert into Favorite values("rlaehgus", "rladmsgml");

insert into Favorite values("rladmsgml", "rlaehgus");

insert into Favorite values("wkdtmddnjs", "rkdwjdah");
insert into Favorite values("wkdtmddnjs", "wjddbghks");
insert into Favorite values("wkdtmddnjs", "dltn");

insert into Favorite values("tjwldnjs", "rlaehgus");
insert into Favorite values("tjwldnjs", "wkdejrcjf");

insert into Favorite values("wjddbghks", "tlstkdlaekd");

insert into Favorite values("wkdejrcjf", "dltn");
insert into Favorite values("wkdejrcjf", "dlackdwjd");

INSERT INTO Favorite VALUES('dltn', 'test');
INSERT INTO Favorite VALUES('rlaehgus', 'test');


-- Card
insert into Card values("rlaehgus", "신한카드", "4499148132801234");
insert into Card values("rlaehgus", "하나카드", "377969004866711");
insert into Card values("rladmsgml", "하나카드", "1234567890123456");
insert into Card values("tjwldnjs", "국민카드", "1010101010101010");
insert into Card values("wkdtmddnjs", "마스터카드", "1010101010101010");
insert into Card values("rkdwjdah", "비자카드", "1010101010101010");
insert into Card values("wjddbghks", "비씨카드", "1010101010101010");
insert into Card values("tlstkdlaekd", "롯데카드", "1010101010101010");
insert into Card values("dltn", "우리카드", "1010101010101010");
insert into Card values("wkdejrcjf", "현대카드", "1010101010101010");
insert into Card values("dlackdwjd", "아메리칸익스프레스", "1010101010101010");
INSERT INTO Card (user_id, card_company, card_number) VALUES('test', '신한카드', '1234567890123456');


-- Item
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(34, 'rlaehgus', '가전', 1000000, 'Sell', '0', '맥북 프로 i7', NULL, NULL, NULL);
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(35, 'rlaehgus', '가전', 500000, 'Bid', '0', '맥북 프로 i7', NULL, NULL, '2018-11-30 12:56:52.000');
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(36, 'rladmsgml', '가구', 150000, 'Bid', '0', '듀오백 의자 DK 2500GI', NULL, NULL, '2018-12-05 12:56:52.000');
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(37, 'tjwldnjs', '도서', 9000, 'Sell', '0', '노인과 바다', NULL, NULL, NULL);
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(38, 'wkdtmddnjs', '의류', 130000, 'Bid', '0', '유니클로 라이더자켓 95M', NULL, NULL, '2018-12-05 12:56:52.000');
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(39, 'rkdwjdah', '잡화', 5000, 'Bid', '0', '전기 파리채', NULL, NULL, '2018-12-05 12:56:52.000');
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(40, 'wjddbghks', '식품', 50000, 'Sell', '0', '상주전통곶감 2kg', NULL, NULL, NULL);
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(41, 'tlstkdlaekd', '완구', 35000, 'Sell', '0', '요술공주 미미인형', NULL, NULL, NULL);
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(42, 'dltn', '취미', 17000, 'Sell', '0', '초보자용 뜨개질세트', NULL, NULL, NULL);
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(43, 'wkdejrcjf', '레저', 6200000, 'Sell', '0', '트렉 산악자전거 REMEDY', NULL, NULL, NULL);
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(44, 'dlackdwjd', '미용', 5000, 'Bid', '0', '양면 손거울', NULL, NULL, '2018-11-30 12:56:52.000');
INSERT INTO auction.Item (item_id, user_id, category, price, deal_type, delivery_fee, item_info, total_item_point, report_count, expire_time)
VALUES(45, 'test', '잡화', 50000, 'Sell', '5000', '격파용 벽돌 금이 있어서 잘 부숴짐', NULL, NULL, NULL);



-- Image
INSERT INTO Image (item_id, dir) VALUES(36, 'duoback.jpg');
INSERT INTO Image (item_id, dir) VALUES(39, 'flyswatter.jpg');
INSERT INTO Image (item_id, dir) VALUES(44, 'handmirror.jpg');
INSERT INTO Image (item_id, dir) VALUES(42, 'knitkit.jpg');
INSERT INTO Image (item_id, dir) VALUES(34, 'macbook.jpg');
INSERT INTO Image (item_id, dir) VALUES(35, 'macbook.jpg');
INSERT INTO Image (item_id, dir) VALUES(41, 'mimidoll.jpg');
INSERT INTO Image (item_id, dir) VALUES(37, 'oldmanandthesea.jpg');
INSERT INTO Image (item_id, dir) VALUES(40, 'persimmon.jpg');
INSERT INTO Image (item_id, dir) VALUES(43, 'trekbike.jpg');
INSERT INTO Image (item_id, dir) VALUES(38, 'uniqlorider.jpg');
INSERT INTO auction.Image VALUES(45, '45_600.jpg');

-- Bid
INSERT INTO Bid (item_id, user_id, join_time, join_price) VALUES(35, 'rladmsgml', '2018-11-30 07:56:52.000', 550000);
INSERT INTO Bid (item_id, user_id, join_time, join_price) VALUES(35, 'tlstkdlaekd', '2018-11-30 06:56:52.000', 520000);
INSERT INTO Bid (item_id, user_id, join_time, join_price) VALUES(35, 'tjwldnjs', '2018-12-01 10:42:20', 600000);
INSERT INTO Bid (item_id, user_id, join_time, join_price) VALUES(36, 'dlackdwjd', '2018-12-02 10:42:20.000', 160000);
INSERT INTO Bid (item_id, user_id, join_time, join_price) VALUES(36, 'rlaehgus', '2018-12-02 11:22:18.000', 165000);
INSERT INTO Bid (item_id, user_id, join_time, join_price) VALUES(39, 'dlackdwjd', '2018-12-01 10:23:15.000', 10000);
INSERT INTO Bid (item_id, user_id, join_time, join_price) VALUES(39, 'wjddbghks', '2018-12-01 10:42:20.000', 11000);
INSERT INTO Bid (item_id, user_id, join_time, join_price) VALUES(39, 'wkdejrcjf', '2018-12-01 10:42:20.000', 14000);
INSERT INTO Bid (item_id, user_id, join_time, join_price) VALUES(35, 'rladmsgml', '2018-12-01 11:11:21.000', 620000);
INSERT INTO Bid (item_id, user_id, join_time, join_price) VALUES(35, 'test', '2018-12-01 13:12:20.000', 660000);



-- Deal
INSERT INTO Deal (deal_id, user_id, address_alias, item_id, item_point, `time`, state) VALUES(11, 'rladmsgml', '집', 34, NULL, '2018-12-01 17:42:20.000', '결제 완료');
INSERT INTO Deal (deal_id, user_id, address_alias, item_id, item_point, `time`, state) VALUES(12, 'rlaehgus', '집', 34, NULL, '2018-12-01 17:42:34.000', '구매 확정');
INSERT INTO Deal (deal_id, user_id, address_alias, item_id, item_point, `time`, state) VALUES(13, 'rlaehgus', '집', 34, NULL, '2018-12-01 17:48:55.000', '구매 확정');
INSERT INTO Deal (deal_id, user_id, address_alias, item_id, item_point, `time`, state) VALUES(14, 'rlaehgus', '기본배송지', 34, NULL, '2018-12-01 18:06:47.000', '구매 확정');
INSERT INTO Deal (deal_id, user_id, address_alias, item_id, item_point, `time`, state) VALUES(15, 'test', '근무지', 40, NULL, '2018-12-01 18:17:22.000', '결제 완료');
INSERT INTO Deal (deal_id, user_id, address_alias, item_id, item_point, `time`, state) VALUES(16, 'test', '근무지', 42, NULL, '2018-12-01 18:17:27.000', '배송중');
INSERT INTO Deal (deal_id, user_id, address_alias, item_id, item_point, `time`, state) VALUES(17, 'rlaehgus', '기본배송지', 45, NULL, '2018-12-01 18:19:17.000', '결제 완료');
INSERT INTO Deal (deal_id, user_id, address_alias, item_id, item_point, `time`, state) VALUES(18, 'test', '근무지', 43, NULL, '2018-12-01 18:19:40.000', '구매 확정');

