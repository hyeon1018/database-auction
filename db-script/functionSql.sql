-- **ȸ�� ���� ����
-- ȸ�� ����
INSERT INTO User (user_id, user_pw, name, age, gender, phone_number)
VALUES("function", md5('function'), "���SQL", 29, "Male", "01158391823");

-- �α���
SELECT COUNT(user_id)
FROM `User`
WHERE user_id = "function"
AND user_pw = md5("function")

-- ����� ���� ��ȸ
SELECT  user_id, name, age, gender, phone_number
FROM User
WHERE user_id = "function";

-- ����� ���� ����
UPDATE User
Set age = "30",
	phone_number = "010584123154",
	user_pw = md5('function2')
WHERE user_id = "function";

-- *�ּ� ����
-- �ּ� �߰�
INSERT INTO Address
VALUES ("function", "�⺻�����", "function�� �ּ�")

-- �ּ� ����
UPDATE Address
SET address = "function�� �� �ּ�"
WHERE user_id = "function"
AND address_alias = "�⺻�����";

-- �ּ� ��ȸ
SELECT address_alias, Address
FROM Address
WHERE user_id = "function";

-- *������� ����
-- ī�� �߰�
INSERT INTO Card
VALUES ("function", "����ī��", "1234517890123456");

-- ī�� ����
DELETE FROM Card
WHERE user_id = "function"
AND card_company = "����ī��"
AND card_number = "1234517890123456";

-- ���� �߰�
INSERT INTO Account
VALUES ("function", "��������", "1104161843234");

-- ���� ����
DELETE FROM Account
WHERE user_id = "function";
AND bank = "��������"
AND account = "1104161843234"

-- ������� ��ȸ
WITH payments(user_id, company, id_no) AS
	(SELECT * FROM Card
	UNION
	SELECT * FROM Account)
SELECT company, id_no
FROM payments
WHERE user_id = "function";


-- ** ��ǰ ����
-- ī�װ� ��� ��ȸ
SELECT category
FROM Category;

-- ��ǰ ��� ��ȸ �� �˻�
SELECT deal_type, item_id, category, price, delivery_fee, item_info, user_id, expire_time, seller_rate
FROM item_list LEFT OUTER JOIN (
	SELECT Item.user_id, avg(item_point) as seller_rate
	FROM Deal JOIN Item USING(item_id)
	GROUP BY Item.user_id) rate USING(user_id)
WHERE price >= 0 -- ������ ����
AND price >= 0 -- �ְ� ����
AND deal_type = "Bid" -- �ŷ� ��� ����
AND category = "����" -- ��ǰ ī�װ� ����
AND item_info LIKE "%Ű����%" -- Ű����� �˻�
AND user_id = "dltn" -- �Ǹ��� ���̵�� �˻�
AND expire_time < "2018-12-18" -- ����� ��� ������ �������� �˻�
AND (expire_time > now() OR expire_time is null); -- �������� ���� ��ǰ�� ��Ͽ� ���

-- ��ǰ ���� ��ȸ
SELECT deal_type, item_id, category, price, delivery_fee, item_info, user_id, expire_time, seller_rate
FROM item_list LEFT OUTER JOIN (
	SELECT Item.user_id, avg(item_point) as seller_rate
	FROM Deal JOIN Item USING(item_id)
	GROUP BY Item.user_id) rate USING(user_id)
WHERE item_id = "34"; -- ��ȸ�Ϸ��� ��ǰ�� ��ȣ

-- ��ǰ �̹��� ��ȸ
SELECT dir
FROM Image
WHERE item_id = "34";

-- ��ǰ ���
INSERT INTO Item(user_id, category, price, deal_type, delivery_fee, item_info, expire_time)
VALUES("function", "����", 10000, "Sell", 1000, "�� �۵��ϴ� ����Ŀ", NULL);
-- Bid �� ��쿡�� expire_tiem�� DATE_ADD(NOW(), INTERVAL 7 DAY)�� �̿��Ͽ� 7�� �ķ� �����Ѵ�.

-- �̹��� ���
INSERT INTO Image
VALUES (LAST_INSERT_ID(), "speaker.jpg");


-- **��ǰ �ŷ�
-- ��ǰ ����
INSERT INTO Deal (user_id, address_alias, item_id, time)
VALUES ("function","�⺻�����","34",now());

-- ���� ��� ��ȸ
WITH my_address AS(SELECT address, address_alias FROM Address WHERE user_id = "function"),
	my_deal AS (SELECT time, item_id, state, address_alias, deal_id FROM Deal WHERE user_id = "function"),
	item_dealer AS (SELECT item_id, user_id, name, phone_number, price FROM Item JOIN User USING (user_id))
SELECT time, deal_id, user_id, name, phone_number, item_id, price, address, state
FROM item_dealer JOIN (my_deal JOIN my_address USING (address_alias)) USING (item_id);

-- �Ǹ� ��� ��ȸ
WITH item_deal (time, user_id, item_id, item_price, address_alias, state, deal_id) AS (
		SELECT time, Deal.user_id, item_id, price, address_alias, state, deal_id
		FROM Deal Join Item USING (item_id) WHERE Item.user_id = "function"),
	user_address AS (SELECT user_id, name, phone_number, address, address_alias FROM Address JOIN User USING(user_id))
SELECT time, deal_id, user_id, name, phone_number, item_id, item_price, address, state
FROM item_deal JOIN user_address USING(user_id, address_alias)

-- ��ǰ �ŷ� ���� ����
UPDATE Deal
SET state = '�����' -- �ŷ� ���� = (���� �Ϸ�, �����, ���� Ȯ��)
WHERE Deal_id = 0 -- �ŷ� ��ȣ.

-- �ŷ� ��� ����
DELETE FROM Deal
WHERE deal_id = 0 -- ������ �ŷ� ��ȣ.

-- �ŷ� ���� ��
UPDATE Deal
SET item_point = 3.0
WHERE deal_id = 17;


-- ** ���
-- ��� ����
INSERT INTO Bid
VALUES ("39", "function", 100000, now());

-- ���� ��ǰ ��ȸ
SELECT Item.user_id, Item.item_id, join_price
FROM Bid JOIN Item USING (item_id)
WHERE join_price >= ALL (SELECT join_price FROM Bid)
AND item_id NOT IN (SELECT item_id FROM Deal)
AND expire_time < now()
AND Bid.user_id = "function";


-- ** ���ã��
-- ���ã�� ��� ��ȸ
SELECT seller_user_id
FROM Favorite
WHERE user_id = "function";

-- ���ã�� ����
DELETE FROM Favorite
WHERE user_id = "function"
AND seller_user_id = "dltn";

-- ��� ã�� �߰�
INSERT INTO Favorite
VALUES ("dltn", "function");


