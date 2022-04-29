package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;

public interface BoardMapper {
	public List<BoardDTO> list(Criteria cri);
	public int register(BoardDTO insertDto);
	public BoardDTO read(int bno);
	public int modify(int bno);
	public int modifyUpdate(BoardDTO updateDto);
	public int delete(int bno);
	public int totalCnt();
}