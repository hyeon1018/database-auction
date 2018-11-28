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


-- User
insert into User values("rlaehgus", md5("qwerty"), "김도현", "24", "Male", "01012345678");
insert into User values("tjwldnjs", md5("123456"), "서지원", "24", "Male", "01092275415");
insert into User values("rladmsgml", md5("000000"), "김은희", "28", "Female", "01037825853");
insert into User values("wkdtmddnjs", md5("000001"), "장승원", "24", "Male", "01031972134");
insert into User values("rkdwjdah", md5("000002"), "강정모", "26", "Male", "01019735218");
insert into User values("wjddbghks", md5("000003"), "정유환", "25", "Male", "01094416793");
insert into User values("tlstkdlaekd", md5("000004"), "신사임당", "99", "Female", "01077912131");
insert into User values("dltn", md5("000005"), "이수", "37", "Male", "01066452115");
insert into User values("wkdejrcjf", md5("000006"), "장덕철", "40", "Male", "01044459132");
insert into User values("dlackdwjd", md5("000007"), "임창정", "44", "Male", "01067189975");

-- Address
insert into Address values("rlaehgus", "집", "01717 서울시 노원구 대림아파트");
insert into Address values("rlaehgus", "학교", "05029 서울시 광진구 능동로 120 건국대학교");
insert into Address values("tjwldnjs", "기숙사", "05029 서울시 광진구 능동로 120 건국대학교");
insert into Address values("rladmsgml", "집", "05693 서울시 송파구 가락로 221 금송빌딩");
insert into Address values("wkdtmddnjs", "집", "02253 서울시 동대문구 사가정로 65 래미안아파트");
insert into Address values("rkdwjdah", "집", "48257 부산광역시 수영구 장대골로57번가길 16 광안리치빌 A동");
insert into Address values("wjddbghks", "집", "06267 서울시 강남구 강남대로 238 스카이솔라빌딩");
insert into Address values("tlstkdlaekd", "집", "15831 경기도 군포시 당산로 129 안양빌딩");
insert into Address values("dltn", "집", "06280 서울시 강남구 남부순환로 2909 여천빌딩");
insert into Address values("wkdejrcjf", "집", "01011 서울시 강북구 4.19로 4 심플렉스빌딩");
insert into Address values("dlackdwjd", "집", "26420 강원도 원주시 백간길 80 벽산아파트");

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
insert into Favorite values("rlaehgus", "rnlcksgdk");

insert into Favorite values("rladmsgml", "rlaehgus");

insert into Favorite values("wkdtmddnjs", "rkdwjdah");
insert into Favorite values("wkdtmddnjs", "wjddbghks");
insert into Favorite values("wkdtmddnjs", "dltn");

insert into Favorite values("tjwldnjs", "rlaehgus");
insert into Favorite values("tjwldnjs", "wkdejrcjf");

insert into Favorite values("wjddbghks", "tlstkdlaekd");

insert into Favorite values("wkdejrcjf", "dltn");
insert into Favorite values("wkdejrcjf", "dlackdwjd");

insert into Favorite values("rlaehgus", "rnlcksgdk");

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

-- Item
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("rlaehgus", "가전", "1000000", "Sell", "0", "맥북 프로 i7");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("rlaehgus", "가전", "500000", "Bid", "0", "맥북 프로 i7");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("rladmsgml", "가구", "150000", "Bid", "0", "듀오백 의자 DK 2500GI");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("tjwldnjs", "도서", "9000", "Bid", "0", "노인과 바다");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("wkdtmddnjs", "의류", "130000", "Bid", "0", "유니클로 라이더자켓 95M");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("rkdwjdah", "잡화", "5000", "Bid", "0", "전기 파리채");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("wjddbghks", "식품", "50000", "Bid", "0", "상주전통곶감 2kg");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("tlstkdlaekd", "완구", "35000", "Bid", "0", "요술공주 미미인형");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("dltn", "취미", "17000", "Bid", "0", "초보자용 뜨개질세트");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("wkdejrcjf", "레저", "6200000", "Bid", "0", "트렉 산악자전거 REMEDY");
insert into Item (user_id, category, price, deal_type, delivery_fee, item_info)
values("dlackdwjd", "미용", "5000", "Bid", "0", "양면 손거울");


-- Image
insert into Image select item_id, "macbook.jpg" From Item
Where Item.user_id = "rlaehgus" AND Item.price = "1000000";

insert into Image select item_id, "macbook.jpg" From Item
Where Item.user_id = "rlaehgus" AND Item.price = "500000";
insert into Image select item_id, "duoback.jpg" From Item
Where Item.user_id = "rladmsgml" AND Item.price = "150000";
insert into Image select item_id, "oldmanandthesea.jpg" From Item
Where Item.user_id = "tjwldnjs" AND Item.price = "9000";
insert into Image select item_id, "uniqlorider.jpg" From Item
Where Item.user_id = "wkdtmddnjs" AND Item.price = "130000";
insert into Image select item_id, "flyswatter.jpg" From Item
Where Item.user_id = "rkdwjdah" AND Item.price = "5000";
insert into Image select item_id, "persimmon.jpg" From Item
Where Item.user_id = "wjddbghks" AND Item.price = "50000";
insert into Image select item_id, "mimidoll.jpg" From Item
Where Item.user_id = "tlstkdlaekd" AND Item.price = "35000";
insert into Image select item_id, "knitkit.jpg" From Item
Where Item.user_id = "dltn" AND Item.price = "17000";
insert into Image select item_id, "trekbike.jpg" From Item
Where Item.user_id = "wkdejrcjf" AND Item.price = "6200000";
insert into Image select item_id, "handmirror.jpg" From Item
Where Item.user_id = "dlackdwjd" AND Item.price = "5000";


-- Bid
insert into Bid
select item_id, "rnlcksgdk", now(), 600000
From Item
Where Item.user_id = "rlaehgus"
AND Item.price = "1000000";

-- Deal
insert into Deal (user_id, address_alias, item_id, time, state)
select "rnlcksgdk", "집", item_id, now(), "Paid"
From Item
Where Item.user_id = "rlaehgus"
AND Item.price = "1000000";
