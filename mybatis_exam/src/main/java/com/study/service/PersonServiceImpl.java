package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.PersonDTO;
import com.study.mapper.PersonMapper;

@Service("person")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonMapper PersonMapper;

	@Override
	public boolean insertPerson(String id, String name) {
		return PersonMapper.insert(id, name)==1?true:false;
	}

	@Override
	public boolean updatePerson(String id, String name) {
		return PersonMapper.update(id, name)==1?true:false;
	}

	@Override
	public boolean deletePerson(String id) {
		return PersonMapper.delete(id)==1?true:false;
	}

	@Override
	public PersonDTO selectPerson(String id) {
		return PersonMapper.select(id);
	}

}
