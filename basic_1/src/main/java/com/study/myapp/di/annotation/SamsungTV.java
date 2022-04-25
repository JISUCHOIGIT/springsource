package com.study.myapp.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {
	
	//private AppleSpeaker speaker; // 반드시 초기화 작업을 해야 함 초기화(생성자, setter 메소드)
	@Autowired
	private Speaker speaker;
	

	@Override
	public void powerOn() {
		System.out.println("SamsungTV 전원 On");

	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV 전원 Off");

	}

	@Override
	public void VolumeUp() {
		//System.out.println("LgTV Volume Up");
		speaker.volumeUp(); // speaker = null

	}

	@Override
	public void VolumeDown() {
		//System.out.println("LgTV Volume Down");
		speaker.volumeDown();

	}

}
