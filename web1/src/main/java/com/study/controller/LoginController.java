package com.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.study.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
// requestMapping 사용하지 않으면 WEB-INF/view/login.jsp
public class LoginController {
	
		//@RequestMapping(path = "/login", method = RequestMethod.GET) // http://localhost:9090/sample/login => jsp 찾게 됨
		@GetMapping("/login")
		public String login() { //return : void  => WEB-INF/view/sample/login.jsp
			log.info("login....");
			return "/sample/login"; //string처리시 return 에 지정경로 기재해주기
		}
		
		//① 변수명 사용
		//@RequestMapping(path = "/login", method = RequestMethod.POST) // http://localhost:9090/sample/login => jsp 찾게 됨
//		@PostMapping("/login")
//		public void loginPost(String userid,String password,String addr,int age) { //return : void  => WEB-INF/view/sample/login.jsp
//			//한글은 깨짐 => 한글처리해야함
//			log.info("loginPost...."+userid+" "+password+" "+addr+" "+age);
//		}
		

		//② ~DTO 객체 사용
		@PostMapping("/login")
		public String loginPost(@ModelAttribute("user") UserDTO userDto) { //return : void  => WEB-INF/view/sample/login.jsp
			//한글은 깨짐 => 한글처리해야함
			log.info("login Post...."+userDto.getUserid()+" "+userDto.getPassword()+" "+userDto.getAddr()+" "+userDto.getAge());
			
			return "sample/logout";// 포워드로 움직임
			
//			return "home";  // 기본 포워드방식
//					  "redirect"  - sendredirect
//			return "redirect:/calc/add"; //가야할 경로(get 방식)
			
//			return "redirect:/"; //sendredirect 방식 : 값이 유지가 되지 않음
		}
		
		//③ HttpServletRequesst : 객체 사용 잘 사용하지 않음(필요한 경우만-대부분 사용 잘 안함)
//		@PostMapping("/login")
//		public void loginPost(HttpServletRequest request) {
//			String userid = request.getParameter("userid");
//			String password = request.getParameter("password");
//			String addr = request.getParameter("addr");
//			String age = request.getParameter("age");
//			log.info("loginPost...."+userid+" "+password+" "+addr+" "+age);
//		}
	
}
