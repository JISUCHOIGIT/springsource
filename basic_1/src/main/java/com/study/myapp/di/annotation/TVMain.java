package com.study.myapp.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		
		// No bean named 'lgTV' available
		TV tv = (TV) ctx.getBean("lgTV");
		tv.powerOn();
		tv.VolumeUp();
		tv.VolumeDown();
		tv.powerOff();

	}

}
