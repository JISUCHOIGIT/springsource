package com.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.dto.SampleDTO;
import com.sun.source.util.SimpleDocTreeVisitor;

import lombok.extern.slf4j.Slf4j;


// 게시판 댓글 사용하기 위해 : 
// return 하는 것들은 jsp가 아니다
@Slf4j
@RestController // return 하는 모든 것들은 데이터 그 자체, 서버에 보낼 때 깜빡이지 않고 서버에서 바로 등록해서 보여주기 위해 필요
public class BasicController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World"; //그대로 String이다 not jsp
	}
	
	@GetMapping(path = "/send.xml",produces = {MediaType.APPLICATION_XML_VALUE}) //json형태로 바꿔서 생산
	//② APPLICATION_XML_VALUE
	// error : No converter : json으로 바꾸는건 알겠는데 중간에 바꿔주는 converter가 없다
	 
	public SampleDTO sendDTO() { //객체 자체를 던져서 사용할 수 있음 // 객체 자체를 보내기 위해서는 컨버터가 필요
		SampleDTO dto = new SampleDTO();
		dto.setName("hong");
		dto.setBno("123");
		dto.setAddr("서울");
		
		return dto;
	}
	
	@GetMapping(path = "/send.json",produces = {MediaType.APPLICATION_JSON_VALUE}) //json형태로 바꿔서 생산
	//① APPLICATION_JSON_VALUE 
	// error : No converter : json으로 바꾸는건 알겠는데 중간에 바꿔주는 converter가 없다
	 
	public SampleDTO sendDTOJson() { //객체 자체를 던져서 사용할 수 있음
		SampleDTO dto = new SampleDTO();
		dto.setName("hong");
		dto.setBno("123");
		dto.setAddr("서울");
		
		return dto;
	}
	
	@GetMapping(path = "/send_list",produces = {MediaType.APPLICATION_JSON_VALUE}) //json형태로 바꿔서 생산
	//① APPLICATION_JSON_VALUE ② APPLICATION_XML_VALUE
	// error : No converter : json으로 바꾸는건 알겠는데 중간에 바꿔주는 converter가 없다
	 
	public List<SampleDTO> sendList() { //객체 자체를 던져서 사용할 수 있음
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		
		for(int i=0;i<10;i++) {
			SampleDTO dto = new SampleDTO();		
			dto.setName("hong");
			dto.setBno("123");
			dto.setAddr("서울");
			list.add(dto);
		}
		
		
		return list;
	}
	
	@GetMapping(path = "/get_map",produces = {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, SampleDTO> sendMap() { //객체 자체를 던져서 사용할 수 있음
		SampleDTO dto = new SampleDTO();
		dto.setName("hong");
		dto.setBno("123");
		dto.setAddr("서울");
		
		Map<String, SampleDTO> map = new HashMap<String, SampleDTO>();
		map.put("Frist", dto);
		
		return map;
	}
	// ResponseEntity 타입 : Http 상태코드 + 데이터 : 객체만 보내는것이 아닌 데이터와 같이
	// ex) 상태코드 : 404, 500, 406, 200(OK)
	@GetMapping(path= "/check",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<SampleDTO> check(Double height, Double weight) { //추후 ajax사용
      
      SampleDTO dto = new SampleDTO("123",height+ "",weight+ "");
      
      ResponseEntity<SampleDTO> result = null;
      
      if(height < 150) {
         //result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
         result = new ResponseEntity<>(dto, HttpStatus.BAD_GATEWAY);
         
      }else {
         //result = ResponseEntity.status(HttpStatus.OK).body(dto); 
         result = new ResponseEntity<>(dto, HttpStatus.OK);
      }
      return result;
   }

	

	// @pathVariable : REST 방식은 URL이 가지고 있는 값을 정보로 사용하는 경우가 많음
	// 				   URL 파라미터에 들어오는 값을 담을 수 있게 해줌
	//				   반드시 사용해야 함
	//@PathVariable 어노테이션을 이용해서 {템플릿 변수} 와 동일한 이름을 갖는 파라미터를 추가하면 됩니다.
	@GetMapping(path = "/product/{cat}/{pid}",produces = MediaType.APPLICATION_XML_VALUE)
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") String pid){			
		return new String[]{"category:"+cat, "product:"+pid};
	}
	
	//@RequestBody : JSON 데이트를 서버로 가져올 때 원하는 타입의 객체로 변환 있어야만 원하는 형식의 객체로 담아줌
	@PostMapping("/test1")
	public void test1(@RequestBody SampleDTO dto) {
		log.info("json 데이터 가져오기 "+dto);
	}
}
