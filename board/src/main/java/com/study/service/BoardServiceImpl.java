package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;
import com.study.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

//	@Override
//	public List<BoardDTO> getList() {
//		return mapper.list(null)
//	}

	@Override
	public boolean register(BoardDTO insertDto) {
		return mapper.register(insertDto)==1?true:false;
	}

	@Override
	public BoardDTO read(int bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(int bno) {
		return mapper.modify(bno)==1?true:false;
	}

	@Override
	public boolean modifyUpdate(BoardDTO updateDto) {
		return mapper.modifyUpdate(updateDto)==1?true:false;
	}

	@Override
	public boolean delete(int bno) {
		return mapper.delete(bno)==1?true:false;
	}

	@Override
	public List<BoardDTO> getList(Criteria cri) {
		return mapper.list(cri);
	}

	@Override
	public int getTotalCnt() {
		return mapper.totalCnt();
	}



}
