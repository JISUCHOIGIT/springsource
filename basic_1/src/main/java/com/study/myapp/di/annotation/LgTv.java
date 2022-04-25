package com.study.myapp.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTv implements TV {
	
	@Autowired
	@Qualifier("apple")
	private Speaker speaker; // 객체 생성 AppleSpeaker, SonySpeaker

//	public LgTv(Speaker speaker) {
//		super();
//		this.speaker = speaker;
//	}

	@Override
	public void powerOn() {
		System.out.println("LGTV 전원 On");

	}

	@Override
	public void powerOff() {
		System.out.println("LGTV 전원 Off");

	}

	@Override
	public void VolumeUp() {
		//System.out.println("LGTV Volume Up");
		speaker.volumeUp();
	}

	@Override
	public void VolumeDown() {
		//System.out.println("LGTV Volume Down");
		speaker.volumeDown();
	}

}
