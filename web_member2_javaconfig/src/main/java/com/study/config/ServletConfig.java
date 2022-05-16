package com.study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.study.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.study.controller"})
public class ServletConfig implements WebMvcConfigurer {
	
	//<resources mapping="/resources/**" location="/resources/" />
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	//<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	//<beans:property name="prefix" value="/WEB-INF/views/" />
	//<beans:property name="suffix" value=".jsp" />
	//</beans:bean>
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/member/changPwd").addPathPatterns("/member/leave");
	}

}
