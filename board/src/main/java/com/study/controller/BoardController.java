package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;
import com.study.dto.pageDTO;
import com.study.service.BoardService;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.GetProxy;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	// /board/list 컨트롤러 작성
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri") Criteria cri,Model model) {
		log.info("전체 리스트 요청"+cri); //pageNum,amount,type,keyword
		
		List<BoardDTO> list = service.getList(cri);
		
		//전체 게시물 개수
		int total = service.getTotalCnt(cri);
		
		
		model.addAttribute("pageDto",new pageDTO(total, cri));
		model.addAttribute("list",list);
		
	}
	
	// /board/register 컨트롤러 작성
	@GetMapping("/register")
	public void register() {
		log.info("register 폼 요청");
	}
	
	// post
	@PostMapping("/register")
	public String registPost(BoardDTO insertDto, Criteria cri, RedirectAttributes rttr) {
		log.info("글 등록 요청"+insertDto);
		
		if(!service.register(insertDto)) {
			return "redirect:/board/register";
		} 

		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());

		//addflash : 잠깐 세션에 담김
		rttr.addFlashAttribute("result",insertDto.getBno());
		return "redirect:/board/list";
	}
	
	// /board/read + bno
	// bno에 해당하는 게시물 읽어온 후 read.jsp 보여주기	
	@GetMapping({"/read","/modify"})
	public void readGet(int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("bno 해당하는 게시물 요청"+bno);
		log.info("bno 해당하는 게시물 요청"+cri);
		
		BoardDTO dto = service.read(bno);
		model.addAttribute("dto",dto);
	}
	
	// /board/read + post => 수정 성공 시 수정된 게시물 보여주기
	@PostMapping("/modify")
	public String readPost(BoardDTO updateDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("bno 해당하는 게시물 수정 게시물 보여주기"+ updateDto);
		log.info("bno 해당하는 게시물 수정 요청-cri"+ cri);
		
		service.modifyUpdate(updateDto);
		
		//수정 성공
		rttr.addAttribute("bno", updateDto.getBno());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/read";
		
	}
	// /board/remove + bno
	// 성고시 list 보여주기
	@GetMapping("/remove")
	public String removeGet(int bno, Criteria cri, RedirectAttributes rttr) {
		log.info("게시물 삭제 요청"+bno);
		log.info("게시물 삭제 요청 - cri"+cri);
		
		service.delete(bno);
		
		//주소줄에 딸려보내는 방식
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		//세션을 이용하는 방식
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/board/list"; // redirect: 다시 컨트롤러로 간다

	}
	
	

}
