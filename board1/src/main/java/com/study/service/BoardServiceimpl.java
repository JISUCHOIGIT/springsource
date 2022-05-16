package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.BoardDTO;
import com.study.mapper.BoardMapper;

@Service
public class BoardServiceimpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardDTO> getList() {
		return mapper.list();
	}

	@Override
	public boolean insert(BoardDTO insertDto) {
		return mapper.insert(insertDto)==1?true:false;
	}

	@Override
	public boolean update(BoardDTO updateDto) {
		return mapper.update(updateDto)==1?true:false;
	}

	@Override
	public boolean delete(int bno) {
		return mapper.delete(bno)==1?true:false;
	}

	@Override
	public BoardDTO read(int bno) {
		return mapper.read(bno);
	}


}
