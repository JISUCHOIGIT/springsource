package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dto.NumDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/calc/*")
public class AddController {
	
	@GetMapping("/add")
	public void addGet() {
		log.info("add.jsp 페이지요청..");
	}
	
//	@PostMapping("/add")
//	//@RequestParam : 넘어오는 파라미터 인자가 다를 수 있을때 지정해주는 역할 num1=op1 / num2=op2
//	public void addPost(@RequestParam("num1") int op1, @RequestParam("num2") int op2) {
//		log.info("덧셈요청");
//		//log.info("num1 + num2 =" +(num1 + num2));
//		log.info("num1 + num2 =" +(op1 + op2));  
//	}
	
//	@PostMapping("/add")
	//@RequestParam : 넘어오는 파라미터 인자가 다를 수 있을때 지정해주는 역할 num1=op1 / num2=op2
	//@RequestParam을 사용하든 안하든 값을 넣어주지 않는다면 400error 나게 됨
	//값을 전송하지 않고 error가 되지 않게 하는 코드 : @RequestParam(value="num1", required=false, defaultValue ="0")ㅎ
//	public void addPost(@RequestParam(value="num1", required=false, defaultValue ="0")int num1, @RequestParam(value="num2", required=false, defaultValue ="0")int num2) {
//		log.info("덧셈요청");
//		log.info("num1 + num2 =" +(num1 + num2)); 
//		
//		 어느 jsp로 갈 것인가? return타입이 무엇이냐에 따라 달라짐 : calc/add
//		 controller : 계산 다했으니 어느 페이지로 갈것인지 정해주는 기능
//	}
	
	// @ModelAttribute("이름") : 바인딩 객체의 이름을 변경
	// 							Model 객체에 값을 담는 것과 같은 기능 제공
	// 받았느냐 새로 값을 만들어 담았느냐
	
	@PostMapping("/add")
	public void addPost(@ModelAttribute("dto") NumDTO dto, Model model) { //바인딩, 이름을 따로 지정하지 않는다면 NumDTO를 소문자 numDTO로 바꿔서 찾게됨
		log.info("덧셈요청");
		log.info("num1 + num2 =" +(dto.getNum1()+dto.getNum2())); 
		
		int result = dto.getNum1() + dto.getNum2(); //계산 추출 후 model에 담기
		//result 값을 add.jsp에서 보여주기 : Model 객체 = request.setAttribute() 와 같은 개념
		model.addAttribute("result", result);
		
		
		
		
		
		
		
	}
}
