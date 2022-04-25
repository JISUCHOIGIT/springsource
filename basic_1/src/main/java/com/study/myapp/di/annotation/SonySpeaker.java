package com.study.myapp.di.annotation;

public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		System.out.println("SonySpeaker -- 객체 성공");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SonsySpeaker -- 볼륨 업");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("SonsySpeaker -- 볼륨 다운");
	}
}
