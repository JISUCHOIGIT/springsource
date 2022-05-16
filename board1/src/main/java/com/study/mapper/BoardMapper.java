package com.study.mapper;

import java.util.List;

import com.study.dto.BoardDTO;

public interface BoardMapper {
	public List<BoardDTO> list();
	public int insert(BoardDTO insertDto);
	public int update(BoardDTO updateDto);
	public int delete(int bno);
	public BoardDTO read(int bno);
}
