package com.study.myapp.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		
		// No bean
//		TV tv = (TV)ctx.getBean("lg"); //lg로 되어있는 bean 찾아와
		TV tv = (TV)ctx.getBean("samsung"); //samsung으로 되어있는 bean 찾아와
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
		
	}
}
