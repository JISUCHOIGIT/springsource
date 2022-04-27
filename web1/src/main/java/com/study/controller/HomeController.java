package com.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.RegisterDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home"; //WEB-INF/views/home.jsp
	}
	
	//redirect 방식으로 움직일때 값을 전송하는 방법
	//① rttr.addAttribute("age",10); 주소줄에 age라는 이름으로 10 보내는 방식
	//  http://~~~~~~?age=10
	// 	path += "?page=+page+"&amount
	
	//② rttr.addFlashAttribute("num","15"); 주소줄로 가지는 않음
	
	
	//redirect로 보내는 방식
	@GetMapping("/doB")
	public String doB(RedirectAttributes rttr){
		rttr.addAttribute("age",10);
		rttr.addAttribute("addr","서울");
		rttr.addAttribute("name","홍길동");
		rttr.addFlashAttribute("num","15");
		return "redirect:/"; //home으로 이동
	}
	
	// 예전 방식
	@GetMapping("/doC")
	public ModelAndView doC() {
		//모델 형태로 담을 객체 1개
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("num",35);
		return mav;
	}
	
	@GetMapping("/doD")
	public RegisterDTO regist() {
		return new RegisterDTO();
	}
	
}
