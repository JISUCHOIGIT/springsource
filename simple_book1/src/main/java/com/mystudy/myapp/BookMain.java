package com.mystudy.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mystudy.myapp.dto.BookDTO;
import com.mystudy.myapp.service.BookService;

public class BookMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BookService service = (BookService) ctx.getBean("service");
		List<BookDTO> list = service.getList();
		
		for(BookDTO dto : list) {
			System.out.println(dto);
		}
		
		
		

	}

}
