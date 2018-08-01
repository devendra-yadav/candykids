package com.candykids.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.candykids.entity.Category;
import com.candykids.entity.Items;

@Repository
public class ItemsDaoImpl implements ItemsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Map<String, String> addItem(Items item) {
		Map<String, String> result=new HashMap<>();
		
		if(item==null) {
			result.put("failure", "Failed to add item as it was null.");
		}else {
			Session session=sessionFactory.getCurrentSession();
			session.save(item);
			result.put("success", "Successfully added item '"+item.getTitle()+"' to '"+item.getCategory().getName()+"' category.");
		}
		
		return result;
	}

	@Override
	public Category getCategory(String categoryName) {
		Category theCategory=null;
		if(categoryName!=null) {
			Session session=sessionFactory.getCurrentSession();
			theCategory=(Category)session.createQuery("from Category c where c.name=:name").setParameter("name", categoryName).getSingleResult();
		}
		
		return theCategory;
	}

	@Override
	public List<Items> getAllItems() {
		Session session=sessionFactory.getCurrentSession();
		List<Items> allItems=session.createQuery("from Items").getResultList();
		return allItems;
	}

	@Override
	public Map<String, String> deleteItem(String itemId) {
		Map<String, String> result=new HashMap<>();
		Session session=sessionFactory.getCurrentSession();
		
		if(itemId==null) {
			result.put("failure", "Failed to delete item as the provided itemId was null.");
		}else {
			try {
				int itemIdInt=Integer.parseInt(itemId);
				Items item=session.get(Items.class, itemIdInt);
				
				session.delete(item);
				result.put("success", "Successfully deleted item with itemID='"+item.getItemId()+"' and title : '"+item.getTitle()+"'");
			} catch (NumberFormatException e) {
				result.put("failure", "Failed to delete item with itemID='"+itemId+"' as provided ItemID was not a valid itemId");
			}
		}
		return result;
	}

	@Override
	public Map<String, String> editItem(Items item) {
		Map<String, String> result=new HashMap<>();
		Session session=sessionFactory.getCurrentSession();
		System.out.println("---> ITEM "+item);
		if(item==null) {
			result.put("failure", "Failed to update item as the item is null.");
		}else {
			session.saveOrUpdate(item);
			result.put("success", "Successfully updated item with itemID='"+item.getItemId()+"'");
		}
		
		return result;
	}

	@Override
	public Items getItem(String itemId) {
		Items item=null;
		Session session=sessionFactory.getCurrentSession();
		if(itemId==null) {
			return null;
		}else {
			try {
				int itemIdInt=Integer.parseInt(itemId);
				item=session.get(Items.class, itemIdInt);
			} catch (Exception e) {
				return null;
			}
		}
		
		return item;
	}

}
