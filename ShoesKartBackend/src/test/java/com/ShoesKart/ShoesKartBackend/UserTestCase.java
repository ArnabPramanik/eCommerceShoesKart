package com.ShoesKart.ShoesKartBackend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ShoesKart.ShoesKartBackend.Dao.UserDao;
import com.ShoesKart.ShoesKartBackend.model.User;



public class UserTestCase {
	
	@Autowired
	static UserDao userDao;

	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init(){
	 context= new AnnotationConfigApplicationContext();
		context.scan("com.ShoesKart.ShoesKartBackend");
		context.refresh();
		userDao = (UserDao) context.getBean("userDao");
	}
	
	@Test
	public void addUser()
	{
		User user = new User();
		user.setCustname("Arnab");
		user.setAddress("Kolkata");
		user.setEmail("arnab@yahoo.com");
		user.setMobile("9831744521");
		user.setUsername("admin4");
		user.setPassword("admin");
		user.setRole("administrator");
		user.setEnabled(true);
		userDao.insertUpdate(user);
		
	}
	@Test
	public void deleteUser(){
		
		User user = userDao.getById("admin2");
		userDao.delete(user);
		System.out.println("The Product has been Deleted");
	}
	@Test
	public void updateUser(){
		User user = userDao.getById("admin");
		user.setEnabled(false);
		userDao.insertUpdate(user);
	}
	@Test
	public void readAllUser(){
		List <User> users = userDao.getAll();
		for(User user : users){
			System.out.println(user.getUsername() + ":" + user.getCustname());
		}
		
	}

}



