package com.study.mapper;

import org.apache.ibatis.annotations.Param;

import com.study.dto.AuthDTO;
import com.study.dto.ChangeDTO;
import com.study.dto.MemberDTO;

public interface MemberMapper {
	//CRUD 메소드 정의
	//C - 회원가입
	public int insert(MemberDTO register);
	
	//R - 로그인( 한사람에 대한 정보만 나오니 리스트가 아닌 AuthDTO로 받음
	public AuthDTO login(@Param("userid") String userid, @Param("password") String password);
	public String dupId(String userid);
	
	//U - 비빌번호 변경
	public int change(ChangeDTO change);
	
	//D - 탈퇴
	public int delete(@Param("userid") String userid, @Param("password") String password);

	
	
}

