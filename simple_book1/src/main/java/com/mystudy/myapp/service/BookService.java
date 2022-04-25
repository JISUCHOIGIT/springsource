package com.mystudy.myapp.service;
import static com.mystudy.myapp.dao.JdbcUtil.*;

import java.util.List;

import com.mystudy.myapp.dto.BookDTO;

public interface BookService {
	public List<BookDTO> getList(); 
	public boolean bookinsert(BookDTO insertDto);
}
