package com.study.myapp.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.myapp.dto.BookDTO;


@Repository //객체 생성
public class BookDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BookDTO> select(){
		// 어디에 담을지 알려주기
		
		String sql = "select * from booktbl";
		
		return jdbcTemplate.query(sql, new BookRowMapper());
	}
	
	//jdbcTemplate.update
	public int insert(BookDTO insertDto) {

		String sql = "insert into booktbl values(?,?,?,?)";
		
	
			int result = jdbcTemplate.update(sql,insertDto.getCode(),
					insertDto.getTitle(),insertDto.getWriter(),insertDto.getPrice());

			
		return result;
	}
	//도서 정보 업데이트
	//jdbcTemplate.update
	public int update(int code, int price) {

		String sql = "update booktbl set price=? where code=?";
		
			int result = jdbcTemplate.update(sql,price,code);

		return result;
	}
	
	//도서 정보 삭제
	//jdbcTemplate.update
	public int delete(int code) {

		String sql = "delete from booktbl where code=?";
			
			int result = jdbcTemplate.update(sql,code);

		return result;
	}
	
	
}
