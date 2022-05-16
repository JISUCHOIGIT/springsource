package com.study.service;

import java.util.List;

import com.study.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> getList();
	public boolean insert(BoardDTO insertDto);
	public boolean update(BoardDTO updateDto);
	public boolean delete(int bno);
	public BoardDTO read(int bno);
}
