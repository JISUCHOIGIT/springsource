package com.study.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuceessHandler implements AuthenticationSuccessHandler {
	
	// 기본으로 성공 후 기본으로 동작하는 핸들러 대신 개발자가 원하는 곳으로 이동 가능

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		//부여된 권한 확인하기
		List<String> roleNames = new ArrayList<String>();
		authentication.getAuthorities().forEach(auth -> roleNames.add(auth.getAuthority()));
		
		
		log.info("roleNames"+roleNames);
		
		
		
		//권한이 ROLE_ADMIN 인 경우 admin_page 이동
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/member/admin-page");
			return;
		}
		
		//권한이 ROLE_USER 이거나 ROLE_MANAGER 라면 /board/list 컨트롤러로 이동
		if(roleNames.contains("ROLE_MEMBER") || roleNames.contains("ROLE_MANAGER")) {
			response.sendRedirect("/board/list");
			return;
		}
		//권한이 없는 경우
		response.sendRedirect("/");
		
		
		
		

	}

}
