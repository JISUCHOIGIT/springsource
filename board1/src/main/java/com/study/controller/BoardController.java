package com.study.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dto.BoardDTO;
import com.study.service.BoardService;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Slf4j //SLF4J(Simple Logging Facade for Java) 로깅 프레임 워크
@RequestMapping("/board/*")
//특정 uri로 요청을 보내면 Controller에서 어떠한 방식으로 처리할지 정의
/*value는 요청받을 url을 설정하게 된다.
method는 어떤 요청으로 받을지 정의하게 된다.(GET, POST, PUT, DELETE 등)
*/
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		
		//list forward해야해서 model 사용
		//보통 request나 session 내장객체에 정보를 담아 jsp에 넘겨주곤 했는데 
		//Spring에서는 Model이라는 녀석을 쓴다.
		
		List<BoardDTO> list = service.getList();
		
		model.addAttribute("list",list);
	}
	
	@GetMapping("/register") //register.jsp
	public void insertGet() {
		log.info("register 폼 요청");
	}
	
	// 글 등록을 위해서 폼에서 안으로 들어가 사용자가 작업을 하기 위해서 PostMapping 사용
	// 다시 jsp로 오기 위해서 redirect 사용
	@PostMapping("/register") //
	public String insertPost(BoardDTO insertDto) {
		log.info("글 등록 요청"+insertDto);
		
		service.insert(insertDto);
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/read","/modify"})
	public void updateGet(int bno, Model model) {
		log.info("bno 해당하는 게시물 요청"+bno);
		
		BoardDTO dto = service.read(bno);
		model.addAttribute("dto", dto);
	}
	
	
	@PostMapping("/modify")
	public String updatePoste(BoardDTO updateDto) {
		log.info("bno 해당하는 게시물 수정" + updateDto);
		
		service.update(updateDto);
		
		return "redirect:/board/read";
	}
	
	@GetMapping("/delete")
	public String deleteGet(int bno) {
		log.info("게시물 삭제 요청" + bno);
		
		service.delete(bno);
		
		return "redirect:/board/list";
	}
	
	
	
	
	
	
}
