package com.study.myapp.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		TV tv = (TV) ctx.getBean("lg");
		//TV tv = (TV) ctx.getBean("samsungTV");
		tv.powerOn();
		tv.VolumeUp();
		tv.VolumeDown();
		tv.powerOff();

	}

}
