package com.candykids.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.candykids.entity.Category;
import com.candykids.entity.Items;
import com.candykids.service.CategoryService;
import com.candykids.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/form-add-item")
	public String showFormToAddItem(Model model) {
		Items item=new Items();
		model.addAttribute("item",item);
		
		List<Category> allCategories=categoryService.getAllCategories();
		model.addAttribute("allCategories",allCategories);
		
		return "form-add-item";
	}
	
	@PostMapping("/addItem")
	public String addItem(@Valid @ModelAttribute("item") Items item, BindingResult results, @RequestParam("imageFile") String imageFile, Model model) {
		if(results.hasErrors()) {
			System.out.println(results);
			
		}
				
		Map<String, String> result=itemsService.addItem(item);
		System.out.println("Output of add item : "+result);
		model.addAttribute("result",result);
		
		Items newItem=new Items();
		model.addAttribute("item",newItem);
		
		List<Category> allCategories=categoryService.getAllCategories();
		model.addAttribute("allCategories",allCategories);
		return "form-add-item";
	}
	
	@GetMapping("/showAllItems")
	public String showAllItems(Model model) {
		
		List<Items> allItems=itemsService.getAllItems();
		model.addAttribute("allItems",allItems);
		
		return "show-all-items";
	}
	
	@GetMapping("/deleteItem")
	public String deleteItem(@RequestParam("itemId") String itemId, Model model) {
		Map<String, String> result=itemsService.deleteItem(itemId);
		System.out.println("Output of delete category : "+result);
		model.addAttribute("result", result);
		
		List<Items> allItems=itemsService.getAllItems();
		model.addAttribute("allItems",allItems);
		
		return "show-all-items";
	}
	
	@GetMapping("/formEditItem")
	public String formEditItem(@RequestParam("itemId") String itemId, Model model) {
		
		Items item=itemsService.getItem(itemId);
		
		model.addAttribute("item",item);
		
		List<Category> allCategories=categoryService.getAllCategories();
		model.addAttribute("allCategories",allCategories);
		
		return "form-edit-item";
	}
	
	@PostMapping("/editItem")
	public String editItem(@Valid @ModelAttribute("item") Items item, BindingResult results, Model model) {
		if(results.hasErrors()) {
			System.out.println(results);
			
		}
		
		Map<String, String> result=itemsService.editItem(item);
		System.out.println("Output of edit item : "+result);
		model.addAttribute("result",result);
		
		List<Items> allItems=itemsService.getAllItems();
		model.addAttribute("allItems",allItems);
		
		return "show-all-items";
	}
	
}
