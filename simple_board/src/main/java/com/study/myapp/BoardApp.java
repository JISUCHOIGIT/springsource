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
		
		
		//게시글 삭제
		System.out.println(service.getRow(2));
		
		List<BoardDTO> list = service.getList();
		for(BoardDTO dto:list) {
			System.out.println(dto);
		}
	}

}
