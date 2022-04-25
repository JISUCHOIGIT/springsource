package com.study.myapp.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV {
	
	@Autowired // @Autowired 객체만 생성하면 내가 알아서 넣어줄게 하는 기능
	@Qualifier("apple")
	private Speaker speaker; 	
	
//	public SamsungTV() { //samsung TV deualt 생성자
//		
//	}
//	
//	//초기화 = 생성자
//	public SamsungTV(Speaker speaker) { //default 생성자가 없어짐.
//		super();
//		this.speaker = speaker;
//	}
//	
//	//초기화 = setter
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV 전원 On");
	}


	@Override
	public void powerOff() {
		System.out.println("SamsungTV 전원 Off");
	}

	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV Volume Up");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV Volume Down");
		speaker.volumeDown();
	}

}
