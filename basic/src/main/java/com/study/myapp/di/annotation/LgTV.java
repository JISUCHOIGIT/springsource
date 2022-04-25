package com.study.myapp.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg") //이름 지정
public class LgTV implements TV {
	
	@Autowired
	@Qualifier("sony") // @Qualifier : 특정 객체 담아달라고 요청
	private Speaker speaker; //speaker 객체 AppleSpeaker, SonySpeaker

//	public LgTV(Speaker speaker) {
//		super();
//		this.speaker = speaker;
//	}

	@Override
	public void powerOn() {
		System.out.println("LgTV 전원 On");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV 전원 Off");
	}

	@Override
	public void volumeUp() {
		//System.out.println("LgTV Volume Up");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//System.out.println("LgTV Volume Down");
		speaker.volumeDown();
	}

}
