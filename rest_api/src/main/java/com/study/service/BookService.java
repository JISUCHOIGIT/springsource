package com.study.service;

import java.util.List;

import com.study.dto.BookDTO;



public interface BookService {
	public BookDTO select(int code);
	public List<BookDTO> getList();
	public boolean bookInsert(BookDTO insertDto);
	public boolean bookUpdate(int code, int price);
	public boolean bookDelete(int code);
	public List<BookDTO> searchList(String criteria, String keyword);
}
