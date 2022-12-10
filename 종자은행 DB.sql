ALTER session set "_ORACLE_SCRIPT"=true;
DROP USER bank CASCADE; -- 기존 사용자 삭제(현재 접속되어 있으면 삭제 안 됨)
	-- CASCADE option : 관련 스키마 개체들도 함께 삭제.  Default는 No Action
CREATE USER bank IDENTIFIED BY 1234  -- 사용자 ID : suser, 비밀번호 : 1234
    DEFAULT TABLESPACE USERS
    TEMPORARY TABLESPACE TEMP;
GRANT connect, resource, dba TO bank; -- 권한 부여

CREATE TABLE 회원 (
	회원아이디  VARCHAR(20)	 NOT NULL,
	비밀번호    VARCHAR(20)	 NOT NULL,
	이름	    VARCHAR(30),
	나이	    NUMBER(3) NOT NULL,
	주소    VARCHAR(50) NOT NULL,
	회원소속 VARCHAR(40),
	PRIMARY KEY(회원아이디)
);

CREATE TABLE  종자 (
	자원번호 NUMBER(5) NOT NULL,
    자원명 VARCHAR(30),
    수량 number(10),
    원산지 VARCHAR(30),
    수집지 VARCHAR(30),
    자원구분 VARCHAR(30),
    평균수명 NUMBER(2),
    공급직원번호 VARCHAR(10) NOT NULL,
    공급일자 DATE,
    공급량 NUMBER(30),
	PRIMARY KEY(자원번호),
    FOREIGN KEY(공급직원번호) references 직원(직원번호)
);

CREATE TABLE  직원 (
	직원번호 VARCHAR(10) NOT NULL,
	직원명 VARCHAR(10),
    직원소속 VARCHAR(20),
    주소 VARCHAR(50) NOT NULL,
    전화번호 VARCHAR(20) NOT NULL,
    담당분야 VARCHAR(20),
	PRIMARY KEY(직원번호)
);

insert into 직원 values ('001','김현수','대한종자','부산','010-1234-5678','-');

CREATE TABLE  분양 (
	회원아이디  VARCHAR(20) NOT NULL,
    자원번호 NUMBER(5) NOT NULL,
	분양번호  NUMBER(10),
    자원명 VARCHAR(30),
    분양신청인 VARCHAR(10),
    분양수령유무 VARCHAR(1),
    담당자 VARCHAR(10),
    FOREIGN KEY (회원아이디) references 회원(회원아이디),
    FOREIGN KEY (자원번호) references 종자(자원번호),
    PRIMARY KEY (회원아이디,자원번호)
);

INSERT INTO 종자 VALUES (1, '고시히카리',500,'일본', '-', '식용작물', 3, '001', '21/01/03', 500);

INSERT INTO 종자 VALUES (2, '인디카',1000,'태국','-','식용작물', 3, '001','21/01/03', 300);
INSERT INTO 종자 VALUES (3, '보리', 650, '대한민국','-','식용작물',3,'001','21/01/03',600);
INSERT INTO 종자 VALUES (4, '밀', 3000, '미국','-', '식용작물',4,'001','21/01/03',1000);
INSERT INTO 종자 VALUES (5, '옥수수',4500,'멕시코','-','식용작물',3,'001','21/01/03',800);
INSERT INTO 종자 VALUES (6, '수수',700,'대한민국','-','식용작물',4,'001','21/04/21', 300);
INSERT INTO 종자 VALUES (7 ,'조', 600, '대한민국','-', '식용작물',5,'001','21/04/21', 200);
INSERT INTO 종자 VALUES (8, '기장', 800, '대한민국','-', '식용작물',4,'001','21/04/21', 100);

INSERT INTO 종자 VALUES (9, '메밀', 500, '대한민국','-', '식용작물',2,'002','21/04/21',100);
INSERT INTO 종자 VALUES (10, '콩',1200,'대한민국','-','식용작물',10,'002','21/04/21',300);

INSERT INTO 종자 VALUES (11, '강낭콩',800,'멕시코','-','식용작물',3,'002','21/06/29',50);
INSERT INTO 종자 VALUES (12, '완두',750,'우즈베키스탄','-','식용작물',3,'002','21/06/29',50);
INSERT INTO 종자 VALUES (13, '팥',600,'인도','-','식용작물',3,'002','21/06/29',50);
INSERT INTO 종자 VALUES (14, '녹두',300,'대한민국','-','식용작물',10,'002','21/06/29',30);
INSERT INTO 종자 VALUES (15, '감자',3000,'대한민국','-','식용작물',2,'002','21/06/29',600);
INSERT INTO 종자 VALUES (16, '고구마',2300,'대한민국','-','식용작물',2,'002','21/06/29',450);
INSERT INTO 종자 VALUES (17, '귀리',600,'대한민국','-','식용작물',5,'002','21/06/29',150);
INSERT INTO 종자 VALUES (18, '율무',1500,'대한민국','-','식용작물',4,'002','21/08/13',150);
INSERT INTO 종자 VALUES (19, '잠두',1000,'대한민국','-','식용작물',5,'002','21/08/13',150);
INSERT INTO 종자 VALUES (20, '땅콩',800,'브라질','-','식용작물',4,'002','21/08/13',200);

INSERT INTO 종자 VALUES (21, '토마토',1150,'칠레','-', '식용작물',2,'003','21/08/13',140);
INSERT INTO 종자 VALUES (22, '사과',1200,'대한민국','-', '식용작물',3,'003','21/08/13',210);
INSERT INTO 종자 VALUES (23, '당근',1150,'대한민국','-', '식용작물',1,'003','21/08/13',180);
INSERT INTO 종자 VALUES (24, '호박',1150,'멕시코','-', '식용작물',6,'003','21/08/13',240);
INSERT INTO 종자 VALUES (25, '애호박',1150,'멕시코','-', '식용작물',5,'003','21/08/13',100);
INSERT INTO 종자 VALUES (26, '마늘',1150,'대한민국','-', '식용작물',2,'003','21/08/13',300);
INSERT INTO 종자 VALUES (27, '양파',1400,'대한민국','-', '식용작물',2,'003','21/08/13',400);
INSERT INTO 종자 VALUES (28, '대파',1800,'대한민국','-', '식용작물',1,'003','21/09/11',550);
INSERT INTO 종자 VALUES (29, '브로콜리',1150,'미국','-', '식용작물',3,'003','21/09/11',300);
INSERT INTO 종자 VALUES (30, '배추',2400,'대한민국','-', '식용작물',3,'003','21/09/11',600);

INSERT INTO 종자 VALUES (31, '수박',1500,'대한민국','-', '식용작물',2,'004','21/09/11',450);
INSERT INTO 종자 VALUES (32, '토란',1600,'대한민국','-', '식용작물',2,'004','21/09/11',400);
INSERT INTO 종자 VALUES (33, '미나리',1800,'대한민국','-', '식용작물',2,'004','21/09/11',350);
INSERT INTO 종자 VALUES (34, '고추',2400,'중국','-', '식용작물',3,'004','21/09/11',800);
INSERT INTO 종자 VALUES (35, '감귤',1500,'일본','-', '식용작물',2,'004','21/10/22',450);
INSERT INTO 종자 VALUES (36, '매실',1000,'중국','-', '식용작물',3,'004','21/10/22',200);
INSERT INTO 종자 VALUES (37, '자두',700,'대한민국','-','식용작물',3,'004','21/10/22',150);
INSERT INTO 종자 VALUES (38, '복분자',1800,'대한민국','-','식용작물',2,'004','21/10/22',600);
INSERT INTO 종자 VALUES (39, '석류',300,'이란','-','식용작물',3,'004','21/10/22',50);
INSERT INTO 종자 VALUES (40, '참외',600,'중국','-','식용작물',3,'004','21/10/22',250);

INSERT INTO 종자 VALUES (41, '천혜향',800,'일본','-','식용작물',2,'005','21/10/22',300);
INSERT INTO 종자 VALUES (42, '딸기',700,'일본','-','식용작물',2,'005','21/10/22',300);
INSERT INTO 종자 VALUES (43, '한라봉',600,'일본','-','식용작물',3,'005','21/11/01',250);
INSERT INTO 종자 VALUES (44, '샤인머스켓',1300,'일본','-','식용작물',3,'005','21/11/01',620);
INSERT INTO 종자 VALUES (45, '복숭아',850,'중국','-','식용작물',2,'005','21/11/01',350);
INSERT INTO 종자 VALUES (46, '배',900,'대한민국','-','식용작물',2,'005','21/11/01',250);
INSERT INTO 종자 VALUES (47, '블루베리',1500,'미국','-','식용작물',3,'005','21/11/01',450);
INSERT INTO 종자 VALUES (48, '유자',600,'중국','-','식용작물',2,'005','21/11/01',150);
INSERT INTO 종자 VALUES (49, '무화과',700,'튀르키예','-','식용작물',3,'005','21/11/01',250);
INSERT INTO 종자 VALUES (50, '감',550,'대한민국','-','식용작물',2,'005','21/11/01',150);

INSERT INTO 종자 VALUES (51, '참깨', 50, '대한민국', '-', '유료작물', 4, '001', '22/11/10', 50);
INSERT INTO 종자 VALUES (52, '들깨', 55, '대한민국', '-', '유료작물', 1, '001', '22/11/11', 55);
INSERT INTO 종자 VALUES (53, '해바라기', 100, '대한민국', '-', '향료작물', 1, '001', '22/11/10', 100);
INSERT INTO 종자 VALUES (54, '목화', 30, '중국', '-', '섬유료작물', 1, '001', '22/09/10', 30);
INSERT INTO 종자 VALUES (55, '사탕무', 25, '러시아', '-', '당료작물', 5, '001', '22/05/25', 25);
INSERT INTO 종자 VALUES (56, '올리브', 60, '이탈리아', '-', '유료작물', 4, '001', '21/11/10', 60);
INSERT INTO 종자 VALUES (57, '야자', 10, '인도네시아', '-', '유료작물', 1, '001', '21/10/01', 10);
INSERT INTO 종자 VALUES (58, '대마', 20, '미국', '-', '유료작물', 5, '001', '20/07/10', 20);
INSERT INTO 종자 VALUES (59, '피마자', 90, '인도', '-', '유료작물', 6, '001', '18/10/10', 90);
INSERT INTO 종자 VALUES (60, '아주까리', 10, '인도', '-', '유료작물', 3, '001', '21/11/16', 10);

INSERT INTO 종자 VALUES (61, '생강', 10, '대한민국', '-', '향료작물', 2, '002', '21/10/10', 10);
INSERT INTO 종자 VALUES (62, '계피', 50, '대한민국', '-', '향료작물', 3, '002', '22/06/11', 50);
INSERT INTO 종자 VALUES (63, '후추', 70, '대한민국', '-', '향료작물', 5, '002', '19/02/05', 70);
INSERT INTO 종자 VALUES (64, '샤프란', 15, '미국', '-', '향료작물', 5, '002', '20/04/10', 15);
INSERT INTO 종자 VALUES (65, '흑겨자', 30, '대한민국', '-', '향료작물', 3, '002', '22/03/02', 30);
INSERT INTO 종자 VALUES (66, '백겨자', 30, '대한민국', '-', '향료작물', 3, '002', '22/01/10', 30);
INSERT INTO 종자 VALUES (67, '동양박하', 20, '중국', '-', '향료작물', 2, '002', '22/02/26', 20);
INSERT INTO 종자 VALUES (68, '세이지', 90, '중국', '-', '향료작물', 5, '002', '20/05/25', 90);
INSERT INTO 종자 VALUES (69, '산초', 80, '중국', '-', '향료작물', 5, '002', '22/07/28', 80);
INSERT INTO 종자 VALUES (70, '라일락', 26, '중국', '-', '향료작물', 3, '002', '22/10/17', 26);

INSERT INTO 종자 VALUES (71, '사탕수수', 20, '대한민국', '-', '당료작물', 5, '003', '22/11/10', 20);
INSERT INTO 종자 VALUES (72, '스테비아', 20, '대한민국', '-', '당료작물', 3, '003', '22/11/10', 20);
INSERT INTO 종자 VALUES (73, '카사바', 30, '대한민국', '-', '당료작물', 3, '003', '22/11/10', 30);
INSERT INTO 종자 VALUES (74, '뚱딴지', 60, '대한민국', '-', '당료작물', 3, '003', '22/11/10', 60);
INSERT INTO 종자 VALUES (75, '사탕야자', 60, '대한민국', '-', '당료작물', 5, '003', '22/11/10', 60);
INSERT INTO 종자 VALUES (76, '사탕단풍', 20, '대한민국', '-', '당료작물', 5, '003', '20/07/05', 20);
INSERT INTO 종자 VALUES (77, '단수수', 10, '대한민국', '-', '당료작물', 2, '003', '22/06/25', 10);
INSERT INTO 종자 VALUES (78, '인삼', 100, '대한민국', '-', '약료작물', 5, '003', '22/10/10', 100);
INSERT INTO 종자 VALUES (79, '감초', 70, '대한민국', '-', '약료작물', 5, '003', '20/12/12', 70);
INSERT INTO 종자 VALUES (80, '박하', 70, '대한민국', '-', '약료작물', 5, '003', '20/11/11', 70);

INSERT INTO 종자 VALUES (81, '당귀', 10, '중국', '-', '약료작물', 2, '004', '21/12/15', 10);
INSERT INTO 종자 VALUES (82, '천궁', 10, '중국', '-', '약료작물', 2, '004', '21/12/15', 10);
INSERT INTO 종자 VALUES (83, '양귀비', 10, '중국', '-', '약료작물', 3, '004', '21/10/09', 10);
INSERT INTO 종자 VALUES (84, '제충국', 20, '중국', '-', '약료작물', 3, '004', '21/12/15', 20);
INSERT INTO 종자 VALUES (85, '황련', 30, '중국', '-', '약료작물', 5, '004', '20/04/14', 30);
INSERT INTO 종자 VALUES (86, '데리스', 70, '중국', '-', '약료작물', 5, '004', '20/04/25', 70);
INSERT INTO 종자 VALUES (87, '목단', 20, '중국', '-', '약료작물', 1, '004', '22/11/26', 20);
INSERT INTO 종자 VALUES (88, '작약', 20, '중국', '-', '약료작물', 1, '004', '22/11/25', 20);
INSERT INTO 종자 VALUES (89, '대황', 30, '중국', '-', '약료작물', 2, '004', '22/11/25', 30);
INSERT INTO 종자 VALUES (90, '맥 문동', 40, '중국', '-', '약료작물', 5, '004', '20/04/17', 40);

INSERT INTO 종자 VALUES (91, '담배', 30, '가나', '-', '기호료작물', 5, '005', '22/05/11', 30);
INSERT INTO 종자 VALUES (92, '차나무', 20, '가나', '-', '기호료작물', 5, '005', '20/11/10', 20);
INSERT INTO 종자 VALUES (93, '호프', 30, '인도', '-', '기호료작물', 5, '005', '20/11/10', 30);
INSERT INTO 종자 VALUES (94, '코코아', 50, '가나', '-', '기호료작물', 3, '005', '22/06/14', 50);
INSERT INTO 종자 VALUES (95, '커피', 60, '인도', '-', '기호료작물', 5, '005', '21/08/37', 60);
INSERT INTO 종자 VALUES (96, '치커리', 70, '대한민국', '-', '기호료작물', 2, '005', '22/01/11', 70);
INSERT INTO 종자 VALUES (97, '마데차', 80, '인도', '-', '기호료작물', 3, '005', '21/09/10', 80);
INSERT INTO 종자 VALUES (98, '모시풀', 90, '대한민국', '-', '섬유료작물', 5, '005', '19/10/25', 90);
INSERT INTO 종자 VALUES (99, '삼', 10, '대한민국', '-', '섬유료작물', 5, '005', '20/05/29', 10);
INSERT INTO 종자 VALUES (100, '대나무', 10, '대한민국', '-', '섬유료작물', 5, '005', '19/07/08', 10);

insert into 직원 values ('001','김현수','대한종자','부산','010-1234-5678','-');
insert into 직원 values ('002','장대윤','대한종자','부산','010-3613-6312','-');
insert into 직원 values ('003','임환섭','대한종자','부산','010-1234-5678','-');
insert into 직원 values ('004','박태억','대한종자','부산','010-1234-5678','-');
insert into 직원 values ('005','장시웅','대한종자','부산','010-1234-5678','-');

-- 일자별 공급합계 저장 프로시저

create or replace NONEDITIONABLE PROCEDURE 일자별공급량합계(
Pi_일자 in DATE,
Po_합계 out NUMBER
)AS
BEGIN
SELECT sum(공급량) into Po_합계
FROM 종자 WHERE 공급일자 = Pi_일자;
END;




분양 테이블 수정 -> 담당자를 외래키로 받음(예 : 001)
	          -> 분양수량 속성 추가

-----------------------------------------------------------

CREATE TABLE  분양 (
	회원아이디  VARCHAR(20) NOT NULL,
    자원번호 NUMBER(5) NOT NULL,
	분양번호  NUMBER(10),
    자원명 VARCHAR(30),
    분양신청인 VARCHAR(10),
    분양신청일 DATE,
    담당자 VARCHAR(10),
    분양수량 NUMBER(20),
    FOREIGN KEY (회원아이디) references 회원(회원아이디),
    FOREIGN KEY (자원번호) references 종자(자원번호),
    FOREIGN KEY (담당자) references 직원(직원번호),
    PRIMARY KEY (회원아이디,자원번호)
);

트리거
-----------------------------------------------------------

create or replace trigger t_종자량수정
after insert
on 분양
for each row
begin
    update 종자 set 수량 = 수량 - :nwe.분양수량 where 자원번호 = :new.자원번호;
end;

insert into 분양 values ('qwer',100,001,'대나무', '도널드', '2022/12/08', '김현수', 1);

-----------------------------------------------------------



저장프로시저
-----------------------------------------------------------
분양테이블의 테이블에 가장 최신에 삽입된 값에 따라감
insert into 분양 values ('qwer',100,001,'대나무', '도널드', '2022/12/08', '001', 1);
insert into 분양 values ('qwer',99,002,'삼', '도널드', '2022/12/08', '001', 1);
이러면 가장 마지막에 들어간 삼의 이름이 들어가게됨

create or replace procedure p_담당자
as
    v_담당자 VARCHAR(10);
    v_담당자원 VARCHAR(10);
cursor c is select 담당자,자원명 from 분양;
begin
    open c;
        loop
            fetch c into v_담당자, v_담당자원;
            exit when c%notfound;
            update 직원 set 담당분야 = v_담당자원 where 직원번호 = v_담당자;
        end loop;
    close c;
end p_담당자;    

execute p_담당자();