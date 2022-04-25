package com.study.service;

import java.util.List;

import com.stuyd.dto.ItemDTO;

public interface ItemService {
	//CRUD 호출
	public boolean itemInsert(ItemDTO insertDto);
	public ItemDTO getRow(int num);
	public boolean itemDelete(int num);
	public boolean itemUpdate(int num, String psize, int price);
	public List<ItemDTO> getList();
}
