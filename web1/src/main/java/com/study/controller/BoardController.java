package com.study.controller;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	
	@GetMapping("/insert")
	public void insert() {
		log.info("board insert 요청");
	}
	
//	@GetMapping("/modify")
//	public void modify() {
//		log.info("board modify 요청");
//	}
//	
//	@GetMapping("/read")
//	public void read() {
//		log.info("board read 요청");
//	}
	
	// modify , read 2개 경로 동시 설정 가능
	@GetMapping(path = {"/modify","/read"})
	public void read() {
		log.info("board read or modify 요청");
	}
	
	@GetMapping("/list")
	public void list() {
		log.info("board list 요청");
	}
}
