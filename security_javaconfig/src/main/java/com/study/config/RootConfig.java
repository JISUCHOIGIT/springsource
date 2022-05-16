package com.study.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@EnableTransactionManagement // <tx:annotation-driven/> 활성화 대체
@EnableScheduling  //  <task:annotation-driven/> 활성화 대체
@Configuration
@ComponentScan({"com.study.service","com.study.task","com.study.handler"}) // @Service 활성화 대체
@MapperScan("com.study.mapper") //  mybatis 인터페이스, mapper 활성화 대체
public class RootConfig {
	
	@Bean  //객체 생성해달라고 부탁할 것들은 @Bean
	public DataSource dataSource() {
		//히카리 환경설정(커넥션 풀 설정 작업) 대체
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("javadb");
		hikariConfig.setPassword("12345");
		
		HikariDataSource datasource = new HikariDataSource(hikariConfig);
		return datasource;
	}
	
	@Bean // mybatis sql 작업을 해주는 객체 생성 대체
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFBean = new SqlSessionFactoryBean();
		sqlSessionFBean.setDataSource(dataSource());
		return sqlSessionFBean.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
