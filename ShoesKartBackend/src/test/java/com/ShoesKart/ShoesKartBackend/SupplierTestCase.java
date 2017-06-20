package com.ShoesKart.ShoesKartBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ShoesKart.ShoesKartBackend.Dao.SupplierDao;
import com.ShoesKart.ShoesKartBackend.model.Supplier;


public class SupplierTestCase {
	@Autowired
	static SupplierDao supplierDao;
	static AnnotationConfigApplicationContext context;
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ShoesKart.ShoesKartBackend");
		context.refresh();
		supplierDao = (SupplierDao) context.getBean("supplierDao");
		
	}
	
	@Test
	public void addSupplier(){
		Supplier supplier = new Supplier();
		supplier.setName("Amazon");
		supplier.setAddress("Kolkata");
		supplierDao.insertUpdate(supplier);
		
	}
	@Test
	public void viewAll(){
		List<Supplier> suppliers =  supplierDao.getAll();
		for(Supplier supplier: suppliers){
			System.out.println(supplier.getId() + ":" + supplier.getName());
			
		}
		
	}
	@Test
	public void updateSupplier(){
		Supplier supplier = supplierDao.getById(1);
		supplier.setAddress("Delhi");
		supplierDao.insertUpdate(supplier);
				
	}
	@Test
	public void deleteSupplier(){
		Supplier supplier = supplierDao.getById(2);
		supplierDao.delete(supplier);
		System.out.println("Delete supplier");
	}
}

