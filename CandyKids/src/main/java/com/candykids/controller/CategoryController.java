package com.candykids.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.candykids.entity.Category;
import com.candykids.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/form-add-category")
	public String showFormToAddCategory(Model model) {
		Category category=new Category();
		model.addAttribute("category",category);
		return "form-add-category";
	}
	
	@PostMapping("/addCategory")
	public String processAddCategory(@Valid @ModelAttribute("category") Category category, BindingResult results, Model model) {
		if(results.hasErrors()) {
			System.out.println(results);
			return "form-add-category";
		}
		Map<String, String> result=categoryService.addCategory(category);
		
		System.out.println("Output of add category : "+result);
		model.addAttribute("category",new Category());
		model.addAttribute("result",result);
		return "form-add-category";
	}
	
	@GetMapping("/showAllCategories")
	public String showAllCategories(Model model) {
		List<Category> allCategories=categoryService.getAllCategories();
		System.out.println("Got all categories : "+allCategories);
		model.addAttribute("allCategories",allCategories);
		return "all-categories";
	}
	
	@GetMapping("/showEditForm")
	public String showFormToEditCategory(@RequestParam("categoryId") String categoryId, Model model) {
		Category theCategory=categoryService.getCategory(categoryId);
		model.addAttribute("category", theCategory);
		return "form-edit-category";
	}
	
	@PostMapping("/editCategory")
	public String processEditCategory(@Valid @ModelAttribute("category") Category category, BindingResult results, Model model) {
		if(results.hasErrors()) {
			System.out.println(results);
			return "form-edit-category";
		}
		
		Map<String, String> result=categoryService.editCategory(category);
		System.out.println("Output of edit category "+result);
		model.addAttribute("result",result);
		
		List<Category> allCategories=categoryService.getAllCategories();
		model.addAttribute("allCategories",allCategories);
		
		return "all-categories";
	}
	
	@GetMapping("/deleteCategory")
	public String deleteCategory(@RequestParam("categoryId") String categoryId, Model model) {
		Map<String, String> result=categoryService.deleteCategory(categoryId);
		System.out.println("Output of delete category : "+result);
		model.addAttribute("result", result);
		
		List<Category> allCategories=categoryService.getAllCategories();
		model.addAttribute("allCategories",allCategories);
		
		return "all-categories";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
}
