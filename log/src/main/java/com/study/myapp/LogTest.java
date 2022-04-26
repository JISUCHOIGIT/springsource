package com.study.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j // -> private static final Logger log=LoggerFactory.getLogger(LogTest.class); 을 롬복으로 간단하게 표현
public class LogTest {
	
	//로그를 기억하기 위해 facade -- logback
	//로그를 처리할 패키지나 방법들이 담겨있는 설정 파일 필요
	//private static final Logger log=LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		log.error("error");
		log.warn("warn");
		log.info("info");
		log.debug("debug");
		//trace : debug로 잡아서 
		//[error > warn > info(참고사항정보) > debug(개발 시)까지만 나오게 됨]> trace(개발 시 - 모두 추적)
		log.trace("trace");
	}
}
