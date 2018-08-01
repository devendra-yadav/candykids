package com.candykids.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.candykids.entity.Category;
import com.candykids.entity.Items;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Map<String, String> addCategory(Category category) {
		Map<String, String> result=new HashMap<>();
		Session session=sessionFactory.getCurrentSession();
		
		//Change category name to uppercase
		category.setName(category.getName().toUpperCase());
		
		if(category!=null) {
			if(category.getName()!=null&&category.getName().length()>0) {
				//Check if already exists
				List<Category> existingCategory=session.createQuery("from Category c where c.name=:name").setParameter("name", category.getName()).getResultList();
				if(existingCategory!=null && existingCategory.size()>0) {
					result.put("failure", "Category '"+category.getName()+"' already exists.");
				}else {
					session.saveOrUpdate(category);
					result.put("success", "Successfully added the category '"+category.getName()+"'");
				}
			}else {
				result.put("failure", "Failed to add the category '"+category.getName()+"'");
			}
		}else {
			result.put("failure", "Failed to add the category as it was null.");
		}
		return result;
	}

	@Override
	public List<Category> getAllCategories() {
		Session session=sessionFactory.getCurrentSession();
		List<Category> allCategories=session.createQuery("from Category").getResultList();
		
		return allCategories;
	}

	@Override
	public Category getCategory(String categoryId) {
		
		Session session=sessionFactory.getCurrentSession();
		Category theCategory=session.get(Category.class, Integer.parseInt(categoryId));
		
		return theCategory;
	}

	@Override
	public Map<String, String> editCategory(Category category) {
		Map<String, String> result=new HashMap<>();
		Session session=sessionFactory.getCurrentSession();
		
		//Change category name to uppercase
		category.setName(category.getName().toUpperCase());
		
		Category existingCategory=session.get(Category.class, category.getCategoryId());
		String oldCategoryName=existingCategory.getName();
		existingCategory.setName(category.getName());
		session.update(existingCategory);
		result.put("success", "Successfully updated category name from '"+oldCategoryName+"' to '"+category.getName()+"'");
		return result;
	}

	@Override
	public Map<String, String> deleteCategory(String categoryId) {
		Map<String, String> result=new HashMap<>();
		Session session=sessionFactory.getCurrentSession();
		
		if(categoryId==null) {
			result.put("failure", "Failed to delete category as the provided categoryId was null.");
		}else {
			try {
				int categoryIdInt=Integer.parseInt(categoryId);
				Category category=session.get(Category.class, categoryIdInt);
				
				//Get all items from this category and set thier category to null.
				List<Items> allItemsForGivenCategory=category.getItems();
				for(Items item:allItemsForGivenCategory) {
					item.setCategory(null);
				}
				
				session.delete(category);
				result.put("success", "Successfully deleted category '"+category.getName()+"'");
			} catch (NumberFormatException e) {
				result.put("failure", "Failed to delete category as the provided categoryId '"+categoryId+"' was not valid.");
			}
		}
		
		return result;
	}

}
