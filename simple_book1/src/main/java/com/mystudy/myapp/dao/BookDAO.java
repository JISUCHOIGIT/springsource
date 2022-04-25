package com.mystudy.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import static com.mystudy.myapp.dao.JdbcUtil.*;

import com.mystudy.myapp.dto.BookDTO;

@Repository // 객체 생성
public class BookDAO {
	
	private Connection con;
	
	public List<BookDTO> select(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookDTO> list = new ArrayList<BookDTO>();
		String sql = "select * from booktbl";
		
		try {
			con = getConnection();
			
			pstmt = con.prepareCall(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getInt("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return list;
	}
}
