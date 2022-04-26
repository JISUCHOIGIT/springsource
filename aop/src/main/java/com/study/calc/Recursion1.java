package com.study.calc;

/*
 * 재귀호출로 factorial 구현
 * 재귀호출 : 메소드 안에서 자신의 메소드를 다시 호출 (이해하기는 쉽지 않다)
 * 			기본단계와 재귀단계로 나뉨
 * */

public class Recursion1 {

	public static void main(String[] args) {
		int num = 4;
		func(num);

	}
	
	public static void func(int n) {
		
		if(n > 0) { // 재귀단계
			System.out.println("Hello");
			func(n-1);
		} else {
			return; // 기본단계
		}

	}
	
//	void countdown(int i) {
//		
//		if(i >= 0) { // 기본단계 : 어디까지 실행할 건지 설정 : return
//			return;
//		} else {
//			//재귀단계
//			countdown(i-1); // 무한루프로 빠질 확률 높음
//		}
//
//	}

}
