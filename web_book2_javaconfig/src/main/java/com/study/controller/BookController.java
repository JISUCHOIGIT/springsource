package com.study.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.BookDTO;
import com.study.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/book/*")
public class BookController {
	
	@Autowired
	private BookService service;
	
	// 전체 리스트 보여주기
	@GetMapping("/list")
	public void list(Model model) {
		log.info("도서 전체 목록 요청");
		
		//서비스 호출
		List<BookDTO> list = service.listAll();
		
		//list
		model.addAttribute("list",list);
	}
	// 도서 입력 폼 보여주기
	@GetMapping("/insert")
	public void insert() {
		log.info("도서 입력 폼 보여주기");	
	}
	
	// 도서 입력 요청
	@PostMapping("/insert")  //post로 요청하기
	   public String insertPost(BookDTO insertDto, RedirectAttributes rttr) {
	      log.info("도서 정보 가져오기");
	      
	      try {
	         if(service.bookInsert(insertDto)) {
	            return "redirect:/book/list";
	         }
	      } catch (Exception e) {
	         rttr.addFlashAttribute("error","코드를 확인하세요");
	         return "redirect:/book/insert";
	      }
	      
	      return "redirect:/book/insert";
	   }
		// 도서 삭제 폼 요청(delete.jsp 보여주기)
	@GetMapping("/delete")
	public void delete() {
		log.info("도서 삭제 폼 보여주기");
	}
	
	@PostMapping("/delete")
	public String deletePost(int code) {
		log.info("도서 삭제하기"+code);
		
		
		if(service.bookDelete(code)) {
			return "redirect:/book/list";
		}
		return "redirect:/book/delete";
		
	}
	
	// 도서 수정 페이지 보여주기
	@GetMapping("/update")
	public void updateGet() {
		log.info("도서 수정 페이지 보여주기");
	}
	
	// 도서 수정 서비스
	@PostMapping("/update")
	public String updatePost(int code, int price) {
		log.info("도서 수정 코드" + code + "도서 수정 가격" +price);
		
		if(service.bookUpdate(code, price)) {
			return "redirect:/book/list";
		}
		return "redirect:/book/update";
	}
	
	// 도서 검색 서비스
	@GetMapping("/search")
	public void searchGet() {
		log.info("도서 검색 페이지 보여주기");
	}
	
	@PostMapping("/search")
	public String searchPost(String criteria, String keyword, Model model) {
		log.info("도서 검색 정보" + criteria + " " + keyword);
		
		List<BookDTO> list = service.getSearchList(criteria, keyword);
		
		model.addAttribute("list",list);
					
		return "/book/list"; //controller get 방식(/book/list) 가기
		
		
		}
	}
	