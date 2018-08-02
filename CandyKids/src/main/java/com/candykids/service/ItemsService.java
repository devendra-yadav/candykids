package com.candykids.service;

import java.util.List;
import java.util.Map;

import com.candykids.entity.Items;

public interface ItemsService {
	public Map<String, String> addItem(Items item);
	public Map<String, String> editItem(Items item);
	public List<Items> getAllItems();
	public Map<String, String> deleteItem(String itemId);
	public Items getItem(String itemId);
	public List<Items> getItemsForCategory(String category);
}
