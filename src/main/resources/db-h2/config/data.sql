DELETE FROM QUOTE;
DELETE FROM AUTHOR;
DELETE FROM CATEGORY;

INSERT INTO AUTHOR VALUES (-1, 'Джейсон Стетхем', 'stethem.png');

INSERT INTO CATEGORY VALUES (-1, 'Жиза', 'live.png');

INSERT INTO QUOTE VALUES (-1, 'Дайте ходу параходу - распустите паруса. Дайте пацанам свободу за красивые глаза!', 'Жиза', 'live', '2018', -1, -1);

COMMIT;