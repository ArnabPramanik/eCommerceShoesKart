package com.ShoesKart.ShoesKartBackend;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ShoesKart.ShoesKartBackend.Dao.CartDao;
import com.ShoesKart.ShoesKartBackend.model.Cart;


public class CartTestCase {
	
	@Autowired
	static CartDao cartDao;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ShoesKart.ShoesKartBackend");
		context.refresh();
		cartDao = (CartDao)context.getBean("cartDao");
	}
	
	@Test
	public void addCart(){
		Cart cart = new Cart();
		cart.setProdname("Jeans");
		cart.setUsername("abc");
		cart.setPrice(1);
		cart.setQuantity(3);
		cart.setStatus("Y");
		cartDao.insertUpdate(cart);
	}
	
	@Test
	public void readAllCart(){
		List<Cart> carts = cartDao.getAll("abc");
		for(Cart cart: carts){
			System.out.println(cart.getCartitemid() + ":" + cart.getProdid());
			
		}
	}
	
	@Test
	public void deleteCart(){
		Cart cart = cartDao.getById(3);
		cartDao.delete(cart);
		System.out.println("The Cart has been deleted");
		
	}
	@Test 
	public void updateCart(){
		Cart cart = cartDao.getById(2);
		cart.setProdname("shirt");
		cart.setPrice(5);
		cartDao.insertUpdate(cart);
	}
}

