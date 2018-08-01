package com.candykids.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candykids.dao.ItemsDao;
import com.candykids.entity.Category;
import com.candykids.entity.Items;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsDao itemsDao;
	
	@Override
	@Transactional
	public Map<String, String> addItem(Items item) {
		
		String categoryName=item.getCategory().getName();
		Category theCategory=itemsDao.getCategory(categoryName);
		if(theCategory!=null) {
			item.setCategory(theCategory);
		}
		
		return itemsDao.addItem(item);
	}

	@Override
	@Transactional
	public List<Items> getAllItems() {
		// TODO Auto-generated method stub
		return itemsDao.getAllItems();
	}

	@Override
	@Transactional
	public Map<String, String> deleteItem(String itemId) {
		// TODO Auto-generated method stub
		return itemsDao.deleteItem(itemId);
	}

	@Override
	@Transactional
	public Map<String, String> editItem(Items item) {
		String categoryName=item.getCategory().getName();
		Category theCategory=itemsDao.getCategory(categoryName);
		if(theCategory!=null) {
			item.setCategory(theCategory);
		}
		
		return itemsDao.editItem(item);
	}

	@Override
	@Transactional
	public Items getItem(String itemId) {
		
		return itemsDao.getItem(itemId);
	}

}
