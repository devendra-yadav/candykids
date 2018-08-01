package com.candykids.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candykids.dao.CategoryDao;
import com.candykids.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	@Transactional
	public Map<String, String> addCategory(Category category) {
		Map<String, String> result=categoryDao.addCategory(category);
		return result;
	}

	@Override
	@Transactional
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategories();
	}

	@Override
	@Transactional
	public Category getCategory(String categoryId) {
		
		return categoryDao.getCategory(categoryId);
	}

	@Override
	@Transactional
	public Map<String, String> editCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.editCategory(category);
	}

	@Override
	@Transactional
	public Map<String, String> deleteCategory(String categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.deleteCategory(categoryId);
	}

}
