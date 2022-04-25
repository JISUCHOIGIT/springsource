package com.study.myapp.service;

import java.util.List;

import com.study.myapp.dto.BoardDTO;

// dao저장소
public interface BoardSerivce {
	public List<BoardDTO> getList();
	public BoardDTO getRow(int bno);
	public boolean boardUpdate(BoardDTO updateDto);
	public boolean boardInsert(BoardDTO insertDto);
	public boolean boardDelete(int bno);
}
