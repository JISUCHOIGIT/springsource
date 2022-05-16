package com.study.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.study.handler.CustomAccessDeniedHandler;
import com.study.handler.CustomLoginSuccessHandler;

@EnableWebSecurity  
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private DataSource dataSource;	
	
	public SecurityConfig(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	@Bean
	public CustomLoginSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public CustomAccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin()
		    .loginPage("/login")
		    .failureUrl("/login-error" )
		    .successHandler(loginSuccessHandler());
		
		http.logout()
		    .invalidateHttpSession(true)
		    .logoutSuccessUrl("/")
		    .deleteCookies("remember-me");
		
		
		http.exceptionHandling(exception -> exception.accessDeniedHandler(accessDeniedHandler()));
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}
	
}











