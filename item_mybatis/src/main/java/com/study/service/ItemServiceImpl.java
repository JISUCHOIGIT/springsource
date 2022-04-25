package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuyd.dto.ItemDTO;
import com.study.mapper.ItemMapper;

@Service("service")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper mapper;
	
	@Override
	public boolean itemInsert(ItemDTO insertDto) {
		return mapper.insert(insertDto)==1?true:false;
	}

	@Override
	public ItemDTO getRow(int num) {
		return mapper.selectOne(num);
	}

	@Override
	public boolean itemDelete(int num) {
		return mapper.delete(num)==1?true:false;
	}

	@Override
	public boolean itemUpdate(int num, String psize, int price) {
		return mapper.update(num, psize, price)==1?true:false;
	}

	@Override
	public List<ItemDTO> getList() {
		return mapper.select();
	}

}
