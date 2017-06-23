package com.ShoesKart.ShoesKartFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ShoesKart.ShoesKartBackend.Dao.CategoryDao;
import com.ShoesKart.ShoesKartBackend.model.Category;

@Controller
public class CategoryController 
{

	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/category")
	public String showCategoryPage()
	{
		System.out.println("---Category Page Displaying-----");
		return "category";
	}
	
	@RequestMapping(value="/AddCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("catname") String catname,@RequestParam("catdesc") String catdesc)
	{
		System.out.println("---Add Category Starting-----");
		
		System.out.println(catname+":::"+catdesc);
		
		Category category=new Category();
		category.setCatname(catname);
		category.setCatdesc(catdesc);
		
		categoryDao.insertUpdate(category);
		System.out.println("---Category Added----");
		return "category";
	}
	
}

