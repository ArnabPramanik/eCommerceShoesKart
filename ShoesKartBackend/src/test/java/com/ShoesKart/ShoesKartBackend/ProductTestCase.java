package com.ShoesKart.ShoesKartBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ShoesKart.ShoesKartBackend.Dao.CategoryDao;
import com.ShoesKart.ShoesKartBackend.Dao.ProductDao;
import com.ShoesKart.ShoesKartBackend.Dao.SupplierDao;
import com.ShoesKart.ShoesKartBackend.model.Product;

public class ProductTestCase {
	@Autowired
	static ProductDao productDao;
	@Autowired
	static CategoryDao categoryDao;
	@Autowired
	static SupplierDao supplierDao;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init(){
	 context= new AnnotationConfigApplicationContext();
		context.scan("com.ShoesKart.ShoesKartBackend");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");
		categoryDao=(CategoryDao)context.getBean("categoryDao");
		supplierDao = (SupplierDao)context.getBean("supplierDao");
	}
	
	@Test
	public void addProduct()
	{
		Product prd=new Product();
		prd.setName("p1");
		prd.setDescription("d1");
		prd.setPrice(234);
		prd.setSupplier(supplierDao.getById(1));
		prd.setQuantity(20);
		prd.setCat(categoryDao.getById(1));
		boolean result=productDao.insertUpdate(prd);
		assertEquals("done",true,result);
	}
	@Test
	public void deleteProduct(){
		
		Product product =productDao.getById(7);
		productDao.delete(product);
		System.out.println("The Product has been Deleted");
	}
	@Test
	public void updateProduct(){
		Product product = productDao.getById(1);
		product.setQuantity(30);
		productDao.insertUpdate(product);
	}
	@Test
	public void readAllProduct(){
		List <Product> products = productDao.getAll();
		for(Product product : products){
			System.out.println(product.getProdid() + ":" + product.getName());
		}
		
	}

}
