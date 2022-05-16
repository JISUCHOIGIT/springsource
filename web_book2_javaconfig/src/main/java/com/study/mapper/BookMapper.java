package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.dto.BookDTO;

public interface BookMapper {
	// CRUD 작업 메소드 선언
	// DAO 메소드 앞 부분만 선언
	
	//C - 삽입
	public int insert(BookDTO insertDto);
	
	//R - 전체 조희, 1개 조회
	public List<BookDTO> list();
	public BookDTO select(int code);
	public List<BookDTO> search(@Param("criteria")String criteria, @Param("keyword")String keyword);
	
	//U - 수정
	public int update(@Param("code")int code, @Param("price")int price);
	
	//D - 삭제
	public int delete(int code);
	
	
}
