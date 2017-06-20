package com.ShoesKart.ShoesKartBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ShoesKart.ShoesKartBackend.Dao.CategoryDao;
import com.ShoesKart.ShoesKartBackend.model.Category;


public class CategoryTestCase{
	
	@Autowired
	static CategoryDao categoryDao;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ShoesKart.ShoesKartBackend");
		context.refresh();
		categoryDao = (CategoryDao)context.getBean("categoryDao");
	}
	
	@Test
	public void addCategory(){
		Category category = new Category();
		category.setCatname("Jeans");
		category.setCatdesc("Denim Jeans");
		categoryDao.insertUpdate(category);
	}
	
	@Test
	public void readAllCategory(){
		List<Category> categories = categoryDao.getAll();
		for(Category category: categories){
			System.out.println(category.getCatid() + ":" + category.getCatname());
			
		}
	}
	
	@Test
	public void deleteCategory(){
		Category category = categoryDao.getById(3);
		categoryDao.delete(category);
		System.out.println("The category has been deleted");
		
	}
	@Test 
	public void updateCategory(){
		Category category = categoryDao.getById(1);
		category.setCatname("shirt");
		category.setCatdesc("Made of cotton");
		categoryDao.insertUpdate(category);
	}
}