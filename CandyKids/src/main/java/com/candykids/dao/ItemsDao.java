package com.candykids.dao;

import java.util.List;
import java.util.Map;

import com.candykids.entity.Category;
import com.candykids.entity.Items;

public interface ItemsDao {
	public Map<String, String> addItem(Items item);
	public Map<String, String> editItem(Items item);
	public Category getCategory(String categoryName);
	public List<Items> getAllItems();
	public Map<String, String> deleteItem(String itemId);
	public Items getItem(String itemId);
	public List<Items> getItemsForCategory(String category);
}
