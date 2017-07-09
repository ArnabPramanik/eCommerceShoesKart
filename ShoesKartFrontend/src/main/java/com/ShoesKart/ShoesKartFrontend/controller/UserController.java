package com.ShoesKart.ShoesKartFrontend.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ShoesKart.ShoesKartBackend.Dao.CategoryDao;
import com.ShoesKart.ShoesKartBackend.Dao.ProductDao;
import com.ShoesKart.ShoesKartBackend.Dao.SupplierDao;
import com.ShoesKart.ShoesKartBackend.model.Category;
import com.ShoesKart.ShoesKartBackend.model.Product;
import com.ShoesKart.ShoesKartBackend.model.Supplier;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/product")
	public String showProduct(Model m){

		List <Product> products = productDao.getAll();
		m.addAttribute("prodList", products);

		return "userproduct";
	}
	
	@RequestMapping("/home")
	public String showUserHome(){
		return "redirect:/login_success";
	}
	
	@RequestMapping("/product/view/{prodId}")
	public String viewProduct(@PathVariable("prodId") int prodId,Model m){
		m.addAttribute("product", productDao.getById(prodId));
		
		return "productfocus";
	}
	
	@RequestMapping("/product/cart/{prdId}")
	public String viewCart(){
		
		return "cart";
	}
}
