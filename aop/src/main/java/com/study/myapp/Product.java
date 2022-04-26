package com.study.myapp;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private String company;
	private String pname;
	private String price;
	
	public String getCompany() {
		// 메소드 잘 작동하는지 sysout 걸 수 있음
		// 1000개의 공통 sysout 을 위해서 aop사용
		
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void getInfo() throws Exception { // 참견을 위해 logAdivce 클래스 작성
		System.out.println("회사명 : "+company);
		System.out.println("상품명 : "+pname);
		System.out.println("가격 : "+price);
		throw new Exception("예외사항 발생");
	}
	
}
