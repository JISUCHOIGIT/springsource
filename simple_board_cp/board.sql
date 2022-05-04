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

--5.3일 댓글작성

--댓글
create table spring_reply(
	rno number(10,0),			-- 댓글 번호
	bno number(10,0) not null,  -- 원본글 번호
	reply varchar2(1000) not null, -- 댓글 내용
	replyer varchar2(50) not null, -- 댓글작성자
	replydate date default sysdate, -- 댓글작성날짜
	updatedate date default sysdate -- 댓글수정날짜
);

drop table spring_reply;

-- 댓글 시퀀스
create sequence seq_reply;

-- 댓글 테이블 pk 설정 후 이름 지정
alter table spring_reply add constraint pk_reply primary key(rno);

-- 외래키 제약
alter table spring_reply add constraint fk_reply_board foreign key(bno)
references spring_board(bno);