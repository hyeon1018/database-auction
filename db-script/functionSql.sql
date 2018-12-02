-- **회원 정보 관리
-- 회원 가입
INSERT INTO User (user_id, user_pw, name, age, gender, phone_number)
VALUES("function", md5('function'), "기능SQL", 29, "Male", "01158391823");

-- 로그인
SELECT COUNT(user_id)
FROM `User`
WHERE user_id = "function"
AND user_pw = md5("function")

-- 사용자 정보 조회
SELECT  user_id, name, age, gender, phone_number
FROM User
WHERE user_id = "function";

-- 사용자 정보 변경
UPDATE User
Set age = "30",
	phone_number = "01012345678",
	user_pw = md5('function2')
WHERE user_id = "function";

-- *주소 관리
-- 주소 추가
INSERT INTO Address
VALUES ("function", "기본배송지", "function의 주소")

-- 주소 변경
UPDATE Address
SET address = "function의 새 주소"
WHERE user_id = "function"
AND address_alias = "기본배송지";

-- 주소 조회
SELECT address_alias, Address
FROM Address
WHERE user_id = "function";

-- *결재수단 관리
-- 카드 추가
INSERT INTO Card
VALUES ("function", "신한카드", "1234517890123456");

-- 카드 제거
DELETE FROM Card
WHERE user_id = "function"
AND card_company = "신한카드"
AND card_number = "1234517890123456";

-- 통장 추가
INSERT INTO Account
VALUES ("function", "신한은행", "1104161843234");

-- 통장 제거
DELETE FROM Account
WHERE user_id = "function"
AND bank = "신한은행"
AND account = "1104161843234";

-- 결재수단 조회
WITH payments(user_id, company, id_no) AS
	(SELECT * FROM Card
	UNION
	SELECT * FROM Account)
SELECT company, id_no
FROM payments
WHERE user_id = "function";


-- ** 물품 관리
-- 카테고리 목록 조회
SELECT category
FROM Category;

-- 물품 목록 조회 및 검색
SELECT deal_type, item_id, category, price, delivery_fee, item_info, user_id, expire_time, seller_rate
FROM item_list LEFT OUTER JOIN (
	SELECT Item.user_id, avg(item_point) as seller_rate
	FROM Deal JOIN Item USING(item_id)
	GROUP BY Item.user_id) rate USING(user_id)
WHERE price >= 0 -- 최저가 지정
AND price >= 0 -- 최고가 지정
AND deal_type = "Bid" -- 거래 방식 지정
AND category = "가구" -- 물품 카테고리 지정
AND item_info LIKE "%%" -- 키워드로 검색
AND user_id = "rladmsgml" -- 판매자 아이디로 검색
AND expire_time < "2018-12-18" -- 경매의 경우 마감일 기준으로 검색
AND (expire_time > now() OR expire_time is null); -- 마감되지 않은 제품만 목록에 띄움

-- 물품 정보 조회
SELECT deal_type, item_id, category, price, delivery_fee, item_info, user_id, expire_time, seller_rate
FROM item_list LEFT OUTER JOIN (
	SELECT Item.user_id, avg(item_point) as seller_rate
	FROM Deal JOIN Item USING(item_id)
	GROUP BY Item.user_id) rate USING(user_id)
WHERE item_id = "34"; -- 조회하려는 물품의 번호

-- 물품 이미지 조회
SELECT dir
FROM Image
WHERE item_id = "34";

-- 물품 등록
INSERT INTO Item(user_id, category, price, deal_type, delivery_fee, item_info, expire_time)
VALUES("function", "가전", 10000, "Sell", 1000, "잘 작동하는 스피커", NULL);
-- Bid 의 경우에는 expire_tiem을 DATE_ADD(NOW(), INTERVAL 7 DAY)를 이용하여 7일 후로 설정한다.

-- 이미지 등록
INSERT INTO Image
VALUES (LAST_INSERT_ID(), "speaker.jpg");


-- **물품 거래
-- 물품 구매
INSERT INTO Deal (user_id, address_alias, item_id, time)
VALUES ("function","기본배송지","34",now());

-- 구매 목록 조회
WITH my_address AS(SELECT address, address_alias FROM Address WHERE user_id = "test"),
	my_deal AS (SELECT time, item_id, state, address_alias, deal_id FROM Deal WHERE user_id = "test"),
	item_dealer AS (SELECT item_id, user_id, name, phone_number, price FROM Item JOIN User USING (user_id))
SELECT time, deal_id, user_id, name, phone_number, item_id, price, address, state
FROM item_dealer JOIN (my_deal JOIN my_address USING (address_alias)) USING (item_id);

-- 판매 목록 조회
WITH item_deal (time, user_id, item_id, item_price, address_alias, state, deal_id) AS (
		SELECT time, Deal.user_id, item_id, price, address_alias, state, deal_id
		FROM Deal Join Item USING (item_id) WHERE Item.user_id = "test"),
	user_address AS (SELECT user_id, name, phone_number, address, address_alias FROM Address JOIN User USING(user_id))
SELECT time, deal_id, user_id, name, phone_number, item_id, item_price, address, state
FROM item_deal JOIN user_address USING(user_id, address_alias)

-- 물품 거래 상태 변경
UPDATE Deal
SET state = '배송중' -- 거래 상태 = (결재 완료, 배송중, 구매 확정)
WHERE Deal_id = 11 -- 거래 번호.

-- 거래 목록 삭제
DELETE FROM Deal
WHERE deal_id = 12; -- 삭제할 거래 번호.

-- 거래 별점 평가
UPDATE Deal
SET item_point = 3.0
WHERE deal_id = 13;


-- ** 경매
-- 경매 입찰
INSERT INTO Bid
VALUES ("39", "function", now(), 100000);

-- 낙찰 물품 조회
SELECT Item.user_id, Item.item_id, join_price
FROM Bid JOIN Item USING (item_id)
WHERE join_price >= ALL (SELECT join_price FROM Bid WHERE Bid.item_id = Item.item_id)
AND item_id NOT IN (SELECT item_id FROM Deal)
AND expire_time < now()
AND Bid.user_id = "test";


-- ** 즐겨찾기
-- 즐겨찾기 목록 조회
SELECT seller_user_id
FROM Favorite
WHERE user_id = "function";

-- 즐겨찾기 삭제
DELETE FROM Favorite
WHERE user_id = "function"
AND seller_user_id = "dltn";

-- 즐겨 찾기 추가
INSERT INTO Favorite
VALUES ("dltn", "function");


