package com.study.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class ReplyDTO {
	private int rno;
	private int bno;
	private String reply;
	private String replyer;
	private Date replydate;
	private Date updatedate;
}
