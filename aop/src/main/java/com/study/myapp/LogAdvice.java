package com.study.myapp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("log")
public class LogAdvice {
	
	
//	@Before(value="execution(* com.study.myapp.Product.getInfo())")
//	public void beforeLog() { //Product.public void getInfo() 실행되기 전에 호출
//		System.out.println("[공통로그] 비즈니스 로직 수행 전 호출");
//	}
	
//  exception 여부와 상관없이 메소드 실행 후 호출
//	@After(value="execution(* com.study.myapp.Product.getInfo())")
//	public void afterLog() { //Product.public void getInfo() 실행되기 전에 호출
//		System.out.println("[공통로그] 비즈니스 로직 수행 후 호출");
//	}
	
//  exception 나지 않아야 메소드 실행 후 호출
//	@AfterReturning(value="execution(* com.study.myapp.Product.getInfo())")
//	public void afterReturnLog() { //Product.public void getInfo() 실행되기 전에 호출
//		System.out.println("[공통로그] 비즈니스 로직 수행시 익셉션 없이 실행 후 호출");
//	}
	
//	@AfterReturning(value="execution(* com.study.myapp.Product.getInfo())")
//	public void afterReturnLog() { //Product.public void getInfo() 실행되기 전에 호출
//		System.out.println("[공통로그] 비즈니스 로직 수행시 익셉션 없이 실행 후 호출");
//	}
//	
//	@AfterThrowing(value="execution(* com.study.myapp.Product.getInfo())")
//	public void afterThrowLog() { //Product.public void getInfo() 실행되기 전에 호출
//		System.out.println("[공통로그] 비즈니스 로직 수행시 익셉션 발생 후 호출");
//	}
	
	
	// aop prox
	
	
	@Around(value="execution(* com.study.myapp.Product.getInfo())")
	public void aroundLog(ProceedingJoinPoint pjp) { //Product.public void getInfo() 실행되기 전에 호출
		System.out.println("[공통로그] 비즈니스 로직 수행시 전 호출");
		
		try {
			// 비즈니스 메소드 호출
			// 원래 실행하려던 getInfo() 호출
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("[공통로그] 비즈니스 로직 수행시 후 호출");
	}
	
}
