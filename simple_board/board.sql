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



--oracle 페이지 나누기
-- 더미 데이터
insert into spring_board(bno,title,content,writer)
(select seq_board.nextval,title,content,writer from spring_board);

select count(*) from spring_board;


-- 댓글

