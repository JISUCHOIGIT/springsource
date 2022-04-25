package com.study.myapp;

public class LGTv implements TV {
	
	private Speaker speaker; // 객체 생성

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
		System.out.println("LGTV Volume Up");

	}

	@Override
	public void VolumeDown() {
		System.out.println("LGTV Volume Down");

	}

}
