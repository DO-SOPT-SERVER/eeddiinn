INSERT INTO MEMBER(ID, NICKNAME, NAME, AGE, PART, GENERATION)
VALUES (1, '에딘', '현예진', 21, 'SERVER', 33),
       (2, '딘에', '진예현', 12, 'SERVER', 1);


INSERT INTO POST(POST_ID, TITLE, CONTENT, MEMBER_ID)
VALUES
    (1, '안녕하세요 제목1', '안녕하세요 내용1', 1),
    (2, '안녕하세요 제목2', '안녕하세요 내용2', 1),
    (3, '안녕하세요 제목3', '안녕하세요 내용3', 1),
    (4, '반갑습니다 제목4', '반갑습니다', 2),
    (5, '안녕하세요 제목5', '안녕하세요', 3);