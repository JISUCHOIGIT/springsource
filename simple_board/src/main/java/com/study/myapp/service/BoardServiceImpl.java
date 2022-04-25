package com.study.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myapp.dao.BoardDAO;
import com.study.myapp.dto.BoardDTO;


// return 값
@Service("service")
public class BoardServiceImpl implements BoardSerivce {
	
	@Autowired
	private BoardDAO dao;


	@Override
	public List<BoardDTO> getList() {
		return dao.select(); //List
	}

	@Override
	public BoardDTO getRow(int bno) {
		return dao.selectOne(bno); 	//BoardDTO
	}

	@Override
	public boolean boardUpdate(BoardDTO updateDto) {
		
		return dao.update(updateDto)==1?true:false; //Boolean
	}

	@Override
	public boolean boardInsert(BoardDTO insertDto) {
		return dao.insert(insertDto)==1?true:false; //Boolean
	}

	@Override
	public boolean boardDelete(int bno) {
		return dao.delete(bno)==1?true:false; //Boolean
	}

}
