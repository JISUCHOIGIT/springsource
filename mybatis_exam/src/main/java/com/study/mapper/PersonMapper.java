package com.study.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.study.dto.PersonDTO;


// DAO 역할
public interface PersonMapper {
	
	//#{id},#{name} ===> ? 변경
	//"insert into person(id,name) values(?,?)"
	//@Insert("insert into person(id,name) values(#{id},#{name})")
	

//	// 복잡하면 사용하기 힘듬
//	public int insertPerson(@Param("id") String id, @Param("name") String name);
	
	
	//src/main/resources/com/study.mapper/personMapper.xml에서 실행하기 위해 호출
	// 파라미터 인자가 2개 3개 4개이면 어느 파라미터에 변수를 담을지 명확히 알려줘야 함
	// @param으로 지정
	public int insert(@Param("id") String id, @Param("name") String name);
	public int update(@Param("id") String id, @Param("name") String name);
	public int delete(String id);
	public PersonDTO select(String id);
}
