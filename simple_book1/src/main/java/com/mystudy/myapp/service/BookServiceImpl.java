package com.mystudy.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.myapp.dao.BookDAO;
import com.mystudy.myapp.dto.BookDTO;

@Service("service")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO dao;
	
	@Override
	public List<BookDTO> getList() {
		return dao.select();

	}

	@Override
	public boolean bookinsert(BookDTO insertDto) {
		return dao.insert(insertDto)==1?true:false;
	}
}