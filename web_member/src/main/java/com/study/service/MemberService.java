package com.study.service;

import com.study.dto.AuthDTO;
import com.study.dto.ChangeDTO;
import com.study.dto.MemberDTO;

public interface MemberService {
	//회원가입
	public boolean register(MemberDTO register);
	public AuthDTO login(String userid, String name);
	public boolean change(ChangeDTO change);
	public boolean delete(String userid, String password);
	public String dupId(String userid);
}
