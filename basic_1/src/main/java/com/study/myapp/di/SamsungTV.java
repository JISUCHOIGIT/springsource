package com.study.myapp.di;

public class SamsungTV implements TV {
	
	//private AppleSpeaker speaker; // 반드시 초기화 작업을 해야 함 초기화(생성자, setter 메소드)
	
	private Speaker speaker;
	
	public SamsungTV() {

	}

	public SamsungTV(Speaker speaker) { //멤버변수의 초기화
		super();
		this.speaker = speaker;
	}
	
	// 초기화 혹은 변경을 위해 set 메소드 사용
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

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
