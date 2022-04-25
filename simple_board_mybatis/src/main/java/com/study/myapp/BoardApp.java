package com.study.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.myapp.dto.BoardDTO;
import com.study.myapp.service.BoardSerivce;

public class BoardApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BoardSerivce service = (BoardSerivce) ctx.getBean("service");
		
		//게시글 등록
//		BoardDTO insertDto = new BoardDTO();
//		insertDto.setTitle("스프링 게시판5");
//		insertDto.setContent("스프링 게시판 작성하기5");
//		insertDto.setWriter("홍길동5");				
//		
//		System.out.println(service.boardInsert(insertDto)?"삽입성공":"삽입실패");
		
		//게시글 수정
//		BoardDTO updateDto = new BoardDTO();
//		updateDto.setBno(22);
//		updateDto.setTitle("스프링 게시판 수정하기");
//		updateDto.setContent("스프링 게시판 작성하기 수정완료");
//		System.out.println(service.boardUpdate(updateDto)?"수정성공":"수정실패");
		
		//게시글 삭제
//		System.out.println(service.boardDelete(22)?"삭제성공":"삭제실패");
		
//		//게시글 조회
		System.out.println(service.getRow(2));
		
		List<BoardDTO> list = service.getList();
		for(BoardDTO dto:list) {
			System.out.println(dto);
		}
	}

}
