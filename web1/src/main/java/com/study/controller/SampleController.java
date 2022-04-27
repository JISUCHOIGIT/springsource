package com.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller 
@Slf4j
@RequestMapping("/sample/*") // http://localhost:9090/sample/**
public class SampleController {
	
	// 앞쪽 고정 : /WEB-INF/views
	// 뒤쪽 고정 : .jsp
	
	// 컨트롤러의 리턴 타입이 void 인 경우
	// http://localhost:9090/ 다음 부분이 jsp 페이지를 찾는데 사용됨
	
	// 컨트롤러의 리턴 타입이 String인 경우
	// return 값만을 가지고 jsp 페이지를 찾습니다.
	
	// return : void & string으로만
	
	// @RequestMapping("/login") => GET + POST 둘 다 허용
	// @RequestMapping(path = "/login", method = RequestMethod.GET) => GET만 허용한다는 의믜
	
	
//	
	@RequestMapping(path = "/basic", method = RequestMethod.GET) // http://localhost:9090/sample/basic => jsp 찾게 됨
	public void basic(@ModelAttribute("page")int page, Model model) { //return : void => WEB-INF/view/sample/basic.jsp
		log.info("basic...."); // WEB-INF/views/sapmle/basic.jsp
		
		//page 변수값을 jsp 보여주기 : Model
		//model.addAttribute("page", page);
	
	}
//	
	
//
//	//@RequestMapping(path = "/login", method = RequestMethod.GET) // http://localhost:9090/sample/login => jsp 찾게 됨
//	@GetMapping("/login")
//	public void login() { //return : void  => WEB-INF/view/sample/login.jsp
//		log.info("login....");
//	}
	
	//Controller 파라미터 수집
	//① 변수명 사용
	//② ~DTO 객체 사용 (jsp값 유지)
	//③ HttpServletRequesst 객체 사용 / 객체 사용 잘 사용하지 않음(필요한 경우만-대부분 사용 잘 안함)
	
	
	//① 변수명 사용
	//@RequestMapping(path = "/login", method = RequestMethod.POST) // http://localhost:9090/sample/login => jsp 찾게 됨
//	@PostMapping("/login")
//	public void loginPost(String userid,String password,String addr,int age) { //return : void  => WEB-INF/view/sample/login.jsp
//		//한글은 깨짐 => 한글처리해야함
//		log.info("loginPost...."+userid+" "+password+" "+addr+" "+age);
//	}
	

	//② ~DTO 객체 사용
//	@PostMapping("/login")
//	public void loginPost(UserDTO userDto) { //return : void  => WEB-INF/view/sample/login.jsp
//		//한글은 깨짐 => 한글처리해야함
//		log.info("loginPost...."+userDto.getUserid()+" "+userDto.getPassword()+" "+userDto.getAddr()+" "+userDto.getAge());
//	}
	
	//③ HttpServletRequesst : 객체 사용 잘 사용하지 않음(필요한 경우만-대부분 사용 잘 안함)
//	@PostMapping("/login")
//	public void loginPost(HttpServletRequest request) {
//		String userid = request.getParameter("userid");
//		String password = request.getParameter("password");
//		String addr = request.getParameter("addr");
//		String age = request.getParameter("age");
//		log.info("loginPost...."+userid+" "+password+" "+addr+" "+age);
//
//	}
	
	//@RequestMapping(path = "/doA", method = RequestMethod.GET) // http://localhost:9090/sample/doA => jsp 찾게 됨
	@GetMapping("doA")
	public void doA(String userid) { //return : void  => WEB-INF/view/sample/doA.jsp
		log.info("doA...."+userid); 
		//get 방식에서 parameter형식으로 넘기는 방법:http://localhost:9090/sample/doA?userid=hong123
	}
	
	//@RequestMapping(value = "/insert", method = RequestMethod.GET) // http://localhost:9090/sample/insert => jsp 찾게 됨

	//@RequestParam("이름") : 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른 경우 사용
	
	
	// @RequestParam("ids") : 배열이 채워짐 insert...[111, 222, 333]
	// annotation 사용하지 않으면 배열 비어있음 []
	@GetMapping("insert")
	public String insert(@RequestParam("ids") ArrayList<String> ids) { 
		log.info("insert..."+ids); //WEB-INF/view/insert.jsp
		return "insert"; // return : insert 값으로 jsp 페이지를 찾음
		//http://localhost:9090/sample/insert?ids=111&ids=222&ids=333
	}

}
