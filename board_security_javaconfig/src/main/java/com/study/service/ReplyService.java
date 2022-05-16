package com.study.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.dto.Criteria;
import com.study.dto.ReplyDTO;
import com.study.dto.ReplyPageDTO;

public interface ReplyService {
	public boolean replyInsert(ReplyDTO inserDto);
	public ReplyDTO replySearch(int rno);
	public boolean replyUpdate(ReplyDTO updateDto);
	public boolean replyDelete(int rno);
	public ReplyPageDTO getList(Criteria cri, int bno);

	
}
