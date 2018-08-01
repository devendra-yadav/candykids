package com.candykids.dao;

import java.util.List;
import java.util.Map;

import com.candykids.entity.Category;

public interface CategoryDao {
	public Map<String, String> addCategory(Category category);
	public Map<String, String> editCategory(Category category);
	public Map<String, String> deleteCategory(String categoryId);
	public List<Category> getAllCategories();
	public Category getCategory(String categoryId);
}
