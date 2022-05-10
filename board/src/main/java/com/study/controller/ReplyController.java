package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.dto.Criteria;
import com.study.dto.ReplyDTO;
import com.study.dto.ReplyPageDTO;
import com.study.service.ReplyService;

import lombok.extern.slf4j.Slf4j;


//jsp를 띄우고자 만든 컨트롤러가 아님
//데이터만 보내는 작업을 하는 컨트롤러
@RestController
@Slf4j
@RequestMapping("/replies/*")
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	//댓글 삽입 - /replies/new + POST + body + json 처리
	//성공 시 success + 200, 실패시 fail + 500
	@PostMapping(path="/new", consumes = "application/json",produces= MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ReplyDTO insertDto) {
		log.info("댓글 작성 요청"+ insertDto);
		
		return service.replyInsert(insertDto)? new ResponseEntity<String>("success",HttpStatus.OK):
			new ResponseEntity<String>("fail",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//댓글 하나 가져오기 - /replies/rno + GET
	//성공시 ReplyDTO + 200
	@GetMapping("/{rno}")
	public ResponseEntity<ReplyDTO> select(@PathVariable("rno") int rno) {
		log.info("댓글 가져오기" + rno);
		
		return new ResponseEntity<ReplyDTO>(service.replySearch(rno),HttpStatus.OK);
	}
	
	// 댓글 수정 - /replies/rno + PUT + body(수정내용-json)
	// 성공 시 success + 200, 실패시 fail + 500
	
	//@RequestMapping(path="/{rno}", method = RequestMethod.PUT)
	
	@PutMapping("/{rno}")
	public ResponseEntity<String> update(@RequestBody ReplyDTO updateDto, @PathVariable("rno") int rno){ //@pathVariable : 주소줄
		log.info("댓글 수정요청" + updateDto);
		
		updateDto.setRno(rno);
		
		return service.replyUpdate(updateDto)? new ResponseEntity<String>("success",HttpStatus.OK) 
				: new ResponseEntity<String>("fail",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글 삭제 : replies/rno + Delete
	// 성공 시 success + 200, 실패시 fail + 500
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> delete(@PathVariable("rno") int rno) {
		log.info("댓글 삭제요청"+rno);
		
		return service.replyDelete(rno)?new ResponseEntity<String>("suceess",HttpStatus.OK):
			new ResponseEntity<String>("fail",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//댓글 리스트 : /replies/pages/bno + GET
	// 성공시 댓글 리스트
	// http://localhost:9090/replies/pages/500/1
	
	@GetMapping("/pages/{bno}/{page}")
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("bno") int bno, @PathVariable("page") int page){
		log.info("댓글 리스트 요청 bno=" + bno +", page = " + page);
		
		Criteria cri = new Criteria(page, 10);
		
		//cri : page 번호 
		//bno : 500 
		// -> service로 이동
		return new ResponseEntity<ReplyPageDTO>(service.getList(cri, bno), HttpStatus.OK);
	
	}
	

}
