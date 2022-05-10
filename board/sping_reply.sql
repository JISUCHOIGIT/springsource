create table spring_board(
	bno number(10,0),
	title varchar2(200) not null,
	content varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
);



alter table spring_board add constraint pk_spring_board primary key(bno);

create sequence seq_board;

-- 댓글 수 컬럼 추가
alter table spring_board add(replycnt number default 0);

-- 기존 댓글 업데이트
update spring_board 
set replycnt = (select count(rno) from spring_reply where spring_board.bno = spring_reply.bno);


select * from spring_board where bno = 581;

--oracle 페이지 나누기
-- 더미 데이터
insert into spring_board(bno,title,content,writer)
(select seq_board.nextval,title,content,writer from spring_board);

select count(*) from spring_board;
select * from spring_reply;

--댓글
// rno, bno 전혀 다름
create table spring_reply(
	rno number(10,0),			-- 댓글 번호 // index = pk
	bno number(10,0) not null,  -- 원본글 번호 //외래키
	reply varchar2(1000) not null, -- 댓글 내용
	replyer varchar2(50) not null, -- 댓글작성자
	replydate date default sysdate, -- 댓글작성날짜
	updatedate date default sysdate -- 댓글수정날짜
);

select * from spring_reply;

-- 댓글 시퀀스
create sequence seq_reply;

-- 댓글 테이블 pk 설정 후 이름 지정
alter table spring_reply add constraint pk_reply primary key(rno);

-- 외래키 제약
alter table spring_reply add constraint fk_reply_board foreign key(bno)
references spring_board(bno);


select * from spring_reply where rno = 1;

select * from spring_reply where bno = 456;

-- 인덱스 생성
create index idx_reply on spring_reply(bno desc, rno asc);


--첨부파일 테이블 생성
create table spring_attach(
	uuid varchar2(100) not null,
	uploadpath varchar2(200) not null,
	filename varchar2(100) not null,
	filetype char(1) default '1',
	bno number(10,0)
);

alter table spring_attach add constraint pk_attach primary key(uuid);
alter table spring_attach add constraint fk_board_attach 
foreign key(bno) references spring_board(bno);


select * from spring_attach;




