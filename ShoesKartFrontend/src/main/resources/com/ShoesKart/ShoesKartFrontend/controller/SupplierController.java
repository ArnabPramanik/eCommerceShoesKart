package com.ShoesKart.ShoesKartFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ShoesKart.ShoesKartBackend.Dao.SupplierDao;
import com.ShoesKart.ShoesKartBackend.model.Supplier;
import org.springframework.ui.ModelMap;
@Controller
public class SupplierController {
	@Autowired
	SupplierDao supplierDao;

	@RequestMapping("/supplier")
	public String showSupplierPage(){
		
		return "supplier";
	}
	
	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier,
		BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "error";
	        }
		supplierDao.insertUpdate(supplier);
		System.out.println("Supplier has been inserted");
		
		return "supplier";
	}
}
