package com.study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> getList();
	
}
