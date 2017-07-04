package com.ShoesKart.ShoesKartFrontend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ShoesKart.ShoesKartBackend.Dao.CategoryDao;
import com.ShoesKart.ShoesKartBackend.Dao.ProductDao;
import com.ShoesKart.ShoesKartBackend.Dao.SupplierDao;
import com.ShoesKart.ShoesKartBackend.model.Category;
import com.ShoesKart.ShoesKartBackend.model.Product;
import com.ShoesKart.ShoesKartBackend.model.Supplier;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/category")
	public String viewCategory(Model m)
	{
		Category cat=new Category();
		m.addAttribute("list",categoryDao.getAll());
		m.addAttribute("category", cat);
		return "admincategory";
	}
	
	@PostMapping("/add/cat")
	public String addCategory(@ModelAttribute("category") Category cat, BindingResult result, ModelMap model)
	{
	
		categoryDao.insertUpdate(cat);
		return "redirect:/admin/category";
		//return "admincategory";
	}
	
	@RequestMapping("/deletecategory/{id}")
	public String removeCat(@PathVariable("id")int id)
	{
		System.out.println("In delete method");
		List <Product> products = productDao.getAll();
		for (Product product : products){
			if(product.getCat().getCatid() == id){
				product.setCat(null);
				productDao.insertUpdate(product);
			}
		}
		categoryDao.delete(categoryDao.getById(id));
		return "redirect:/admin/category";
	}
	
	@RequestMapping("/updatecategoryview/{id}")
	public String updateCatView(@PathVariable("id") int id,Model m){
		
		Category category = categoryDao.getById(id);
		List <Category> categories = categoryDao.getAll();
		m.addAttribute("list",categories);
		m.addAttribute("category",category);
		return "admincategory";
	}
	
	@RequestMapping("/supplier")
	public String viewSupplier(Model m){
		List <Supplier> suppliers = supplierDao.getAll();
		Supplier supplier = new Supplier();
		m.addAttribute("supList", suppliers);
		m.addAttribute("supplier",supplier);
		return "adminsupplier";
	}
	@RequestMapping("/supplier/add")
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier, BindingResult result, ModelMap m){
		supplierDao.insertUpdate(supplier);
		return "redirect:/admin/supplier";
	}
	
	
	@RequestMapping("/supplier/update/{id}")
	public String updateSupplier(@PathVariable("id") int id, Model m){
		Supplier supplier = supplierDao.getById(id);
		List <Supplier> suppliers = supplierDao.getAll();
		m.addAttribute("supplier",supplier);
		m.addAttribute("supList",suppliers);

		return "adminsupplier";
	}
	
	@RequestMapping("/supplier/delete/{id}")
	public String deleteSupplier(@PathVariable("id") int id){
		Supplier supplier = supplierDao.getById(id);
		supplierDao.delete(supplier);
		return "redirect:/admin/supplier";
	}
	
	
	//Product
	
	@RequestMapping("/product")
	public String showProduct(Model m){
		Product product = new Product();
		List <Product> products = productDao.getAll();
		m.addAttribute("product", product);
		m.addAttribute("prodList", products);
		List <Category> categories = categoryDao.getAll();
		LinkedHashMap <Integer, String> lh = new LinkedHashMap <Integer, String>();
		List <Supplier> suppliers = supplierDao.getAll();
		for (Supplier supplier : suppliers){
			lh.put(supplier.getId(),supplier.getName());
		}
		m.addAttribute("supMap",lh);
		m.addAttribute("catList",categories);
		return "adminproduct";
	}
	
	@RequestMapping("/product/add")
	public String addProduct(@ModelAttribute("product") Product product,HttpServletRequest request){
		
		String path = "C:\\Users\\ARNAB\\git\\ShoesKartFrontend\\src\\main\\webapp\\assets\\images\\";
		String fileinfo = path + product.getName() + ".jpg";
		File f = new File(fileinfo);
		if(!product.getPimage().isEmpty()){
			
			try{
				 byte[] bytes=product.getPimage().getBytes();
	             BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
	             bs.write(bytes);
	             bs.close();
				
			}
			catch(Exception e){
				System.out.print(e.getMessage());
			}
		}
		
		product.setCat(categoryDao.getById(product.getCat().getCatid()));
		productDao.insertUpdate(product);
		return "redirect:/admin/product";
	}
	
	@RequestMapping("/product/update/{id}")
	public String updateProduct(@PathVariable("id") int id, Model m){
		Product product = productDao.getById(id);
		List <Product> products = productDao.getAll();
		m.addAttribute("product", product);
		m.addAttribute("prodList",products);
		List <Category> categories = categoryDao.getAll();
		/*LinkedHashMap <Category, String> lh = new LinkedHashMap <Category, String>();
		for (Category cat : categories){
			lh.put(cat,cat.getCatname());
			
		}
		m.addAttribute("catList",lh);*/
		m.addAttribute("catList",categories);
		return "adminproduct";
	}
	
	@RequestMapping("product/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id){
		productDao.delete(productDao.getById(id));
		
		return "redirect:/admin/product";
	}
	
}
